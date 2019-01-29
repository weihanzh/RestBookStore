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
import java.util.List;

@WebServlet("/GetByCategoryServlet")
/*
    Call this servlet to get all books based on a specified category
 */
public class GetByCategoryServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //get categoryid by getting cid parameter values based on hidden categoryId
        Integer categoryId = Integer.parseInt(request.getParameter("cid"));
        //call service method getProductList (categoryid): gets the list of products for a category,
        // or all products if no category is specified
        ProductCatalogService productCatalogService = new ProductCatalogService();

        if (categoryId != null) {
            List<BookEntity> categoryBooks =  productCatalogService.getProductList(categoryId);
            CategoryEntity categoryEntity = productCatalogService.getCategory(categoryId);
            HttpSession hs = request.getSession();
            hs.setAttribute("categorybooks", categoryBooks);
            hs.setAttribute("categoryentity", categoryEntity);
            response.sendRedirect("/pages/products.jsp");
        } else {
            response.sendRedirect(request.getContextPath()+"/GetAllProductsServlet");
        }
    }
}
