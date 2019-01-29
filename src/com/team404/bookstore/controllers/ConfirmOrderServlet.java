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
import java.util.List;

@WebServlet("/ConfirmOrderServlet")
/*
    Calls this servlet to verify billing and shipping information
    and confirm the order
 */
public class ConfirmOrderServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //we should validate the creditAccount and creditName in advance
        // to proceed the payment
        String creditAccount = request.getParameter("credit_account");
        String creditName = request.getParameter("credit_name");
        if (creditAccount != null && creditAccount.length() == 16
            && creditName != null && creditName.length() > 0)
        {
            // every 5th request is refused on the website
            HttpSession hs = request.getSession();
            int orderid = (int) hs.getAttribute("orderid");
            List<BookCartCombine> bookCartCombineList = (List<BookCartCombine>) hs.getAttribute("bookcartcomblist");
            bookCartCombineList.clear();
            hs.setAttribute("bookcartcomblist", bookCartCombineList);
            List<ShoppingCartEntity> shoppingCartEntityList = (List<ShoppingCartEntity>) hs.getAttribute("shoppingcartlist");
            shoppingCartEntityList.clear();
            hs.setAttribute("shoppingcartlist", shoppingCartEntityList);
            OrderProcessService orderProcessService = new OrderProcessService();
            boolean flag = orderProcessService.confirmOrder(orderid);
            if (flag)//request is successful
            {
                response.sendRedirect("/pages/success.jsp");
            } else
            {
                response.sendRedirect("/pages/fail.jsp");
            }
        } else {//credit information incorrect
            response.sendRedirect("/pages/checkout.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
