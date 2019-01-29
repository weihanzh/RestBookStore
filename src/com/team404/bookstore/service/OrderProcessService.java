package com.team404.bookstore.service;

import com.team404.bookstore.dao.*;
import com.team404.bookstore.entity.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Path("/OrderProcess")
public class OrderProcessService {
    private UserDao userDao;
    private AddressDao addressDao;
    private ShoppingCartDao shoppingCartDao;
    private BookDao bookDao;
    private OrderDao orderDao;
    private OrderBookDao orderBookDao;
    private CountDao countDao;

    /*Submit Function*/
    @POST
    @Path("/createAccount")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean CreateAccount(@QueryParam("emailUserName") String emailUserName, @QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName, @QueryParam("password") String password, AddressEntity addressEntity) {
        boolean flag = true;
        userDao = new UserDao();
        addressDao = new AddressDao();
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(emailUserName);
        userEntity.setFirstname(firstName);
        userEntity.setLastname(lastName);
        userEntity.setPassword(password);
        UserEntity userEntity1 = userDao.GetUserbyAccount(userEntity.getUsername());

        if(userEntity1 != null) {
            flag = false;
        }
        else {
            int id = userDao.AddUser(userEntity);
            addressEntity.setUserid(id);
            System.out.print(addressEntity.getUserid());
            addressDao.AddAddress(addressEntity);
        }
        return  flag;
    }

    /*Login Verification*/
    @POST
    @Path("/getAccount")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean getAccount(UserEntity userEntity) {
        boolean flag = true;
        userDao = new UserDao();

        UserEntity userEntity1 = userDao.GetUserbyAccount(userEntity.getUsername());

        if(userEntity1 != null){
            if(userEntity.getPassword().equals(userEntity1.getPassword())) {
                flag = true;
            } else {
                flag = false;
            }
        } else {

            flag = false;
        }
        return flag;
    }
    /*
        Get UserEntity by username provided
     */
    @GET
    @Path("/getUserByAccount/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserEntity GetUserByAccount(@PathParam("username") String username) {
        userDao = new UserDao();

        UserEntity userEntity = userDao.GetUserbyAccount(username);

        return  userEntity;
    }

    /*Personal Info-UserAccount Info*/
    public UserEntity getUserinfo(int id) {
        userDao = new UserDao();

        UserEntity userEntity = userDao.GetUserById(id);

        return userEntity;
    }

    /*Personal Info-Address Info*/
    @GET
    @Path("/getAddressInfo/{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public AddressEntity getAddressinfo(@PathParam("userid") int userid) {
        addressDao = new AddressDao();

        AddressEntity addressEntity = addressDao.getAddressByUid(userid);

        return addressEntity;
    }

    /*Customer add item(s) to their own shopping cart*/
    public boolean AddItemtoCart(ShoppingCartEntity shoppingCartEntity) {

        shoppingCartDao = new ShoppingCartDao();

        if(shoppingCartDao.GetCartItem(shoppingCartEntity.getUserid(),
                shoppingCartEntity.getBookid()) == null) {
            return shoppingCartDao.AddShoppingCart(shoppingCartEntity);
        }

        else {
            return shoppingCartDao.UpdateItemQuantity(shoppingCartEntity);
        }

    }

    /*Display customers' shopping cart contents*/
    public List<ShoppingCartEntity> DisplayShoppingCart(int userid) {
        shoppingCartDao = new ShoppingCartDao();

        return shoppingCartDao.GetShoppingCartByUid(userid);
    }

    /*Delete single item in shopping cart*/
    public boolean DeleteSingleItem(int id) {
        shoppingCartDao = new ShoppingCartDao();

        return shoppingCartDao.DeleteShoppingItemById(id);
    }

    /*Calculate the amount of check-out items*/
    public int CalculateAmount(List<ShoppingCartEntity> list) {
        int amount = 0;
        for (ShoppingCartEntity i : list) {
            amount += i.getQuantity();
        }
        return amount;
    }

    /*Calculate a order's total cost(without tax)*/
    public float CalculateTotalPrice(List<ShoppingCartEntity> list) {
        bookDao = new BookDao();
        float totalPrice = 0;

        for(ShoppingCartEntity i : list) {
            BookEntity bookEntity = bookDao.GetBookById(i.getBookid());
            totalPrice += bookEntity.getPrice()*i.getQuantity();
        }
        return totalPrice;
    }

    /*createOrder function's Inner function:Generate the time when order is created*/
    public String GetOrderGenerationTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return (String)df.format(new Date());
    }

    /*creates a purchase order including shipping, taxes, total amount due based on shopping cart info*/
    public int createOrder(int userid) {

        shoppingCartDao = new ShoppingCartDao();
        addressDao = new AddressDao();
        orderDao = new OrderDao();

        OrderEntity orderEntity = new OrderEntity();
        List<ShoppingCartEntity> list = shoppingCartDao.GetShoppingCartByUid(userid);

        orderEntity.setUserid(userid);
        orderEntity.setGenerationtime(Timestamp.valueOf(GetOrderGenerationTime()));
        orderEntity.setTotalprice(CalculateTotalPrice(list));
        orderEntity.setAddressid(addressDao.getAddressByUid(userid).getId());
        orderEntity.setStatus("Processing");
        if(addressDao.getAddressByUid(userid).getProvince().equals("ON")) {
            orderEntity.setShipping(5);
            orderEntity.setTax(orderEntity.getTotalprice()*0.13);
            orderEntity.setAftertaxprice(orderEntity.getTotalprice()*1.13+orderEntity.getShipping());
        }else {
            orderEntity.setShipping(8);
            orderEntity.setTax(orderEntity.getTotalprice()*0.08);
            orderEntity.setAftertaxprice(orderEntity.getTotalprice()*1.08+orderEntity.getShipping());
        }
        orderEntity.setAmount(CalculateAmount(list));

        int id = orderDao.AddOrder(orderEntity);

        createOrderBook(list, id);

        shoppingCartDao.DeleteShoppingItems(userid);

        return id;
    }

    /*Create & Save OrderBook entities by using ShoppingCart entities*/
    public void createOrderBook(List<ShoppingCartEntity> list, int id) {
        orderBookDao = new OrderBookDao();
        for(ShoppingCartEntity i : list) {
            OrderBookEntity orderBookEntity = new OrderBookEntity();
            orderBookEntity.setOrderid(id);
            orderBookEntity.setBookid(i.getBookid());
            orderBookEntity.setQuantity(i.getQuantity());
            orderBookDao.AddOrderBook(orderBookEntity);
        }
    }

    /*Confirm User's Order, Fail every 5th times among every orders*/
    public boolean confirmOrder(int orderid) {
        countDao = new CountDao();
        orderDao = new OrderDao();
        boolean flag = true;

        if(countDao.getCount().getCounts() % 5 == 0 && countDao.getCount().getCounts() >= 5) {
            countDao.CountUpdate();
            flag = false;
            orderDao.UpdateOrderStatus(orderid, flag);
        }else {
            countDao.CountUpdate();
            flag = true;
            orderDao.UpdateOrderStatus(orderid, flag);
        }
        return flag;
    }

    /*My Order Page-Display User's Order List(Should be used with some other functions to display the details)*/
    public List<OrderEntity> DisplayMyOrder (int userid) {
        orderDao = new OrderDao();

        return orderDao.GetOdersByUid(userid);
    }
    /*
        Get a list of OrderBookEntity based on orderid
     */
    public List<OrderBookEntity> GetOrderBooks (int orderid) {
        orderBookDao = new OrderBookDao();

        return  orderBookDao.GetOrderBookByOid(orderid);
    }
}