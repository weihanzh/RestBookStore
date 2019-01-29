package com.team404.bookstore.controllers;

import com.team404.bookstore.entity.BookEntity;
import com.team404.bookstore.entity.CategoryEntity;
import com.team404.bookstore.service.ProductCatalogService;
import com.team404.bookstore.sslConfig.SslConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@WebServlet("/GetAllProductsServlet")
/*
    Calls this servlet to get all products and categories list
 */
public class GetAllProductsServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //call service method getProductList (): gets the list of
        //all products if no category is specified
        //In this case, categoryid is not specified, we should provide all products
        ProductCatalogService productCatalogService = new ProductCatalogService();
//        List<BookEntity> bookList = productCatalogService.getProductList();
//        SslConfig sslconf= new SslConfig();
        Client client = ClientBuilder.newClient();
        String URL= "http://localhost:8080/rest/ProductCatalog/getProductList";
        WebTarget target= client.target(URL);
        Invocation.Builder ib = target.request(MediaType.APPLICATION_JSON);
        Response res = ib.get();
        List<BookEntity> bookList = res.readEntity(new GenericType<List<BookEntity>>() {
        });
        //call service method getCategoryList(): gets the list of product categories for the store
//        List<CategoryEntity> categories = productCatalogService.getCategoryList();
        URL = "http://localhost:8080/rest/ProductCatalog/getCategoryList";
        target= client.target(URL);
        ib = target.request(MediaType.APPLICATION_JSON);
        res = ib.get();
        List<CategoryEntity> categories = res.readEntity(new GenericType<List<CategoryEntity>>() {
        });
        HttpSession hs = request.getSession();
        hs.setAttribute("allbooks", bookList);
        hs.setAttribute("categories", categories);
        response.sendRedirect("/pages/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request,response);
    }
}
