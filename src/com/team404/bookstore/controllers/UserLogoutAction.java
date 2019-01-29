package com.team404.bookstore.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserLogoutAction implements UserAction
{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession(false);
        if(session != null){ //invalid all sessions
            session.invalidate();
        }
        response.sendRedirect("/GetAllProductsServlet");
    }
}

