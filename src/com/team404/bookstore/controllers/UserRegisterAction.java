package com.team404.bookstore.controllers;

import com.team404.bookstore.entity.AddressEntity;
import com.team404.bookstore.entity.BookEntity;
import com.team404.bookstore.entity.UserEntity;
import com.team404.bookstore.service.OrderProcessService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

public class UserRegisterAction implements UserAction
{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String emailUserName = request.getParameter("email");
        //address need to be completed here
        String country = request.getParameter("country");
        String province = request.getParameter("province");
        String street = request.getParameter("street");
        String zipcode = request.getParameter("zip");
        String phone = request.getParameter("tel");
        String password = request.getParameter("password");
        String confirmPass = request.getParameter("confirm_password");
        /*
            we should validate the register form information in advance
         */
        if (firstName != null && firstName.length() > 0 &&
                lastName != null && lastName.length() > 0 &&
                emailUserName != null && emailUserName.length() > 0 &&
                emailUserName.indexOf("@") > 0 &&
                emailUserName.indexOf("@") < emailUserName.length() - 1 &&
                country != null && country.length() > 0 &&
                province != null && province.length() > 0 &&
                street != null && street.length() > 0 &&
                zipcode != null && zipcode.length() > 0 &&
                phone != null && phone.length() > 0 &&
                password != null && password.length() >= 6 &&
                confirmPass != null && confirmPass.length() >= 6 &&
                password.equals(confirmPass) && isNumeric(phone))
        {
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(emailUserName);
            userEntity.setFirstname(firstName);
            userEntity.setLastname(lastName);
            userEntity.setPassword(password);

            AddressEntity addressEntity = new AddressEntity();
            addressEntity.setCountry(country);
            addressEntity.setProvince(province);
            addressEntity.setStreet(street);
            addressEntity.setZip(zipcode);
            addressEntity.setPhone(phone);
            /*call createAccount(accountName, accountInfo)
             *service method to determine if this account
             * already exists, if exists it fails to create
             * if not exists, insert the account information
             * to DB(user table and address table both)
             */
//            OrderProcessService orderProcessService = new OrderProcessService();
//            boolean flag = orderProcessService.CreateAccount(emailUserName, firstName, lastName, password, addressEntity);
            Client client = ClientBuilder.newClient();
            String URL= "http://localhost:8080/rest/OrderProcess/createAccount";
            WebTarget target= client.target(URL).queryParam("emailUserName", emailUserName).queryParam("firstName", firstName)
                    .queryParam("lastName", lastName).queryParam("password", password);
            Invocation.Builder ib = target.request(MediaType.TEXT_PLAIN);
            Response res = ib.post(Entity.entity(addressEntity, MediaType.APPLICATION_JSON));
            boolean flag = res.readEntity(boolean.class);
            if (!flag)//the accountName already exists, fail to create account
            {
                System.out.println("The accountName already exists!");
                response.sendRedirect("/pages/register.jsp");
            } else
            {
                System.out.println("Register successfully!");
                response.sendRedirect("/pages/signin.jsp");
            }
        } else {//register fails, invalid information
            System.out.println("Register fails, invalid information!");
            response.sendRedirect("/pages/register.jsp");
        }
    }
    /*
        A function to determine if the String is numeric
     */
    public boolean isNumeric(String str)
    {
        for (int i = 0; i < str.length(); i++)
        {
            if (!Character.isDigit(str.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }
}
