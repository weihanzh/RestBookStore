package com.team404.bookstore.controllers;
import com.team404.bookstore.entity.ShoppingCartEntity;
import com.team404.bookstore.entity.UserEntity;
import com.team404.bookstore.service.OrderProcessService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/DisplayCheckoutServlet")
/*
    Call this servlet to display the checkout page and create an order
 */
public class DisplayCheckoutServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //createOrder(shoppingCartInfo, shipping info): creates a purchase order including shipping, taxes, total amount
        // due based on shopping cart info on orders page
        HttpSession hs = request.getSession();
        UserEntity user = (UserEntity) hs.getAttribute("user");
        int userId = user.getId();
        OrderProcessService orderProcessService = new OrderProcessService();
        List<ShoppingCartEntity> shoppingCartEntityList = orderProcessService.DisplayShoppingCart(userId);
        if (!shoppingCartEntityList.isEmpty()) //if the shopping cart is not empty
        {
            System.out.println("shopping cart not empty");
            int orderid = orderProcessService.createOrder(userId);//create an order
            hs.setAttribute("orderid", orderid);
            response.sendRedirect("/pages/checkout.jsp");
        } else {
            System.out.println("Your shopping cart is empty!");
            response.sendRedirect("/GetAllProductsServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
