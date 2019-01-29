package com.team404.bookstore.controllers;

import com.team404.bookstore.entity.BookEntity;
import com.team404.bookstore.entity.CategoryEntity;
import com.team404.bookstore.service.ProductCatalogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/GetDetailServlet")
/*
    Call this servlet to get detail information about books
 */
public class GetDetailServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //get bookid by getting bid parameter values based on the bookId values hidden in the form
        String bookId = request.getParameter("bid");
        //call service method
        ProductCatalogService productCatalogService = new ProductCatalogService();
        //getProductInfo(productid): gets the detailed product information for a product.
        BookEntity book = productCatalogService.getProductInfo(bookId);
        CategoryEntity categoryEntity = productCatalogService.getCategory(book.getCategoryid());
        HttpSession hs = request.getSession();
        //put detail book information and category in the session
        hs.setAttribute("detailinfo", book);
        hs.setAttribute("detailCategory", categoryEntity);
        response.sendRedirect("/pages/detail.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
