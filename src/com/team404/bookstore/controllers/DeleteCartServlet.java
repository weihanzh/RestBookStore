package com.team404.bookstore.controllers;

import com.team404.bookstore.entity.BookCartCombine;
import com.team404.bookstore.entity.ShoppingCartEntity;
import com.team404.bookstore.service.OrderProcessService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet("/DeleteCartServlet")
/*
    Call this servlet to delete items in the shopping cart
 */
public class DeleteCartServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //get shopping cart id from client URL parameter
        int shoppingCartId = Integer.parseInt(request.getParameter("sid"));
        OrderProcessService orderProcessService = new OrderProcessService();
        //call delete service method to delete the item
        orderProcessService.DeleteSingleItem(shoppingCartId);
        HttpSession hs = request.getSession();
        List<ShoppingCartEntity> shoppingCartEntityList = (List<ShoppingCartEntity>)hs.getAttribute("shoppingcartlist");
        ShoppingCartEntity item = null;
        Iterator<ShoppingCartEntity> iterator = shoppingCartEntityList.iterator();
        while (iterator.hasNext()) {
            ShoppingCartEntity entity = iterator.next();
            if (entity.getId() == shoppingCartId) {
                item = entity;
                iterator.remove();
                break;
            }
        }
        //update shopping cart session and bookcart session lists
        hs.setAttribute("shoppingcartlist", shoppingCartEntityList);
        List<BookCartCombine> bookCartCombineList = (List<BookCartCombine>) hs.getAttribute("bookcartcomblist");
        Iterator<BookCartCombine> iterator1 = bookCartCombineList.iterator();
        while (iterator1.hasNext()) {
            BookCartCombine entity1 = iterator1.next();
            if (entity1.getShoppingCartEntity().equals(item)) {
                iterator1.remove();
                break;
            }
        }
        hs.setAttribute("bookcartcomblist", bookCartCombineList);
        response.sendRedirect("/pages/mycart.jsp");
    }
}
