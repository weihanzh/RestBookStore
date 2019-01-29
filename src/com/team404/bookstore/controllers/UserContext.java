package com.team404.bookstore.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserContext
{
    private UserAction userAction;
    public UserContext(UserAction userAction) {
        this.userAction = userAction;
    }
    public void executeAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        userAction.execute(request, response);
    }
}
