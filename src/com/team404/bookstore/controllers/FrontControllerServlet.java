package com.team404.bookstore.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FrontControllerServlet")
public class FrontControllerServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String userAction = request.getParameter("useraction");
        if (userAction.equals("login")) {
            UserContext userContext = new UserContext(new UserLoginAction());
            userContext.executeAction(request, response);
        } else if (userAction.equals("register")) {
            UserContext userContext = new UserContext(new UserRegisterAction());
            userContext.executeAction(request, response);
        } else if (userAction.equals("logout")) {
            UserContext userContext = new UserContext(new UserLogoutAction());
            userContext.executeAction(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
