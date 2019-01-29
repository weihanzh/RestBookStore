package com.team404.bookstore.controllers;//package com.team404.bookstore.controllers;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebServlet("/UserLogoutServlet")
///*
//    User calls this servlet to logout
// */
//public class UserLogoutServlet extends HttpServlet
//{
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
//    {
//        HttpSession session = request.getSession(false);
//        if(session != null){ //invalid all sessions
//            session.invalidate();
//        }
//        response.sendRedirect("/GetAllProductsServlet");
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
//    {
//        doPost(request, response);
//    }
//}
