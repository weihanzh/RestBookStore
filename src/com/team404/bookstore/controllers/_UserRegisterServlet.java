package com.team404.bookstore.controllers;//package com.team404.bookstore.controllers;
//
//import com.team404.bookstore.entity.AddressEntity;
//import com.team404.bookstore.entity.UserEntity;
//import com.team404.bookstore.service.OrderProcessService;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebServlet("/UserRegisterServlet")
///*
//    User calls this servlet to register a new account
// */
//public class UserRegisterServlet extends HttpServlet
//{
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
//    {
//        UserContext userContext = new UserContext(new UserRegisterAction());
//        userContext.executeAction(request, response);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
//    {
//        doPost(request, response);
//    }
//
//}
