package com.team404.bookstore.filter;

import com.team404.bookstore.entity.UserEntity;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = {"/pages/mycart.jsp","/pages/checkout.jsp", "/pages/account.jsp", "/pages/orders.jsp", "/MyCartServlet", "/DisplayShoppingCartServlet", "/DisplayOrdersServlet"})
public class LoginFilter implements Filter
{
    public void destroy()
    {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException
    {
        HttpSession hs = ((HttpServletRequest)req).getSession();
        UserEntity userEntity = (UserEntity) hs.getAttribute("user");
        if (userEntity == null) {
            ((HttpServletResponse)resp).sendRedirect("/pages/signin.jsp");
            return;
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException
    {

    }

}
