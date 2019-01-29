package com.team404.bookstore.controllers;

import com.team404.bookstore.entity.AddressEntity;
import com.team404.bookstore.entity.BookEntity;
import com.team404.bookstore.entity.UserEntity;
import com.team404.bookstore.service.OrderProcessService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

public class UserLoginAction implements UserAction
{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String emailUserName = request.getParameter("email");
        String password = request.getParameter("password");
        /* call getAccount(accountName, accountPassword, accountInfo)
         * service method returns accountInfo if accountName exists
         * and accountPassword is correct, otherwise returns null
         */
        /*
            we should validate email and password in advance
         */
        if (emailUserName != null && emailUserName.length() > 0
                && emailUserName.indexOf("@") > 0
                && emailUserName.indexOf("@") < emailUserName.length() - 1
                && password != null && password.length() >= 6)
        {
            UserEntity u = new UserEntity();
            u.setUsername(emailUserName);
            u.setPassword(password);
//            OrderProcessService orderProcessService = new OrderProcessService();
//            boolean flag = orderProcessService.getAccount(u);
            Client client = ClientBuilder.newClient();
            String URL= "http://localhost:8080/rest/OrderProcess/getAccount";
            WebTarget target= client.target(URL);
            Invocation.Builder ib = target.request(MediaType.TEXT_PLAIN);
            Response res = ib.post(Entity.entity(u, MediaType.APPLICATION_JSON));
            boolean flag = res.readEntity(Boolean.class);
            HttpSession hs = request.getSession();
            if (!flag)
            {
                //login fail
                response.sendRedirect("/pages/signin.jsp");
            } else
            {
                //UserEntity ue = orderProcessService.GetUserByAccount(emailUserName);
                URL = "http://localhost:8080/rest/OrderProcess/getUserByAccount";
                target = client.target(URL).path("/{username}").resolveTemplate("username", emailUserName);
                ib = target.request(MediaType.APPLICATION_JSON);
                res = ib.get();
                UserEntity ue = res.readEntity(UserEntity.class);
                //AddressEntity address = orderProcessService.getAddressinfo(ue.getId());
                URL = "http://localhost:8080/rest/OrderProcess/getAddressInfo";
                target = client.target(URL).path("/{userid}").resolveTemplate("userid", ue.getId());
                ib = target.request(MediaType.APPLICATION_JSON);
                res = ib.get();
                AddressEntity address = res.readEntity(AddressEntity.class);
                //login success, put user information and address into the session
                hs.setAttribute("user", ue);
                hs.setAttribute("address", address);
                response.sendRedirect("/pages/index.jsp");
            }
            System.out.println("The login userName and password are valid");
        } else { //invalid email or password
            System.out.println("The login information is invalid");
            response.sendRedirect("/pages/signin.jsp");
        }
    }
}
