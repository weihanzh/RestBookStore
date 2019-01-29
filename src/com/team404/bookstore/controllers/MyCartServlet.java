package com.team404.bookstore.controllers;

import com.team404.bookstore.entity.BookEntity;
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

@WebServlet("/MyCartServlet")
/*
    Call this servlet to add items into the shopping cart
 */
public class MyCartServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //Check the quantity, it should not be any invalid values
        String str = request.getParameter("quantity");
        if (str == null || str.equals("") || Integer.parseInt(str) <= 0) {
            System.out.println("Invalid input quantity!");
            response.sendRedirect("/pages/detail.jsp");
            return;
        }
        Integer quantity = Integer.parseInt(str);
        HttpSession hs = request.getSession();
        BookEntity book = (BookEntity) hs.getAttribute("detailinfo");
        String bookId = book.getBookid();
        UserEntity userEntity = (UserEntity) hs.getAttribute("user");
        int userId = userEntity.getId();

        ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity();
        shoppingCartEntity.setBookid(bookId);
        shoppingCartEntity.setQuantity(quantity);
        shoppingCartEntity.setUserid(userId);
        //get book information from DB to display
        // and get quantity from detail page,
        // update the new quantity for this book in the DB
        // and the shoppingcartlist httpsession
        OrderProcessService orderProcessService = new OrderProcessService();
        boolean flag = orderProcessService.AddItemtoCart(shoppingCartEntity);
        if (flag) { // Add to cart is successful
            List<ShoppingCartEntity> shoppingCartEntityList = orderProcessService.DisplayShoppingCart(userId);
            hs.setAttribute("shoppingcartlist", shoppingCartEntityList);
            response.sendRedirect("/DisplayShoppingCartServlet");
        } else {
            response.sendRedirect("/pages/detail.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
