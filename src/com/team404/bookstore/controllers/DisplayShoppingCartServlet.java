package com.team404.bookstore.controllers;

import com.team404.bookstore.entity.BookCartCombine;
import com.team404.bookstore.entity.BookEntity;
import com.team404.bookstore.entity.ShoppingCartEntity;
import com.team404.bookstore.entity.UserEntity;
import com.team404.bookstore.service.OrderProcessService;
import com.team404.bookstore.service.ProductCatalogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/DisplayShoppingCartServlet")
/*
    Call this servlet to display all books in the shopping cart
    as well as the quantities of books
 */
public class DisplayShoppingCartServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //combine shopping cart list and book information together
        // to show the book shopping cart combine list
        HttpSession hs = request.getSession();
        List<ShoppingCartEntity> shoppingCartEntityList = (List<ShoppingCartEntity>)hs.getAttribute("shoppingcartlist");
        UserEntity userEntity = (UserEntity)hs.getAttribute("user");
        int userId = userEntity.getId();
        List<BookCartCombine> list = new ArrayList<>();
        ProductCatalogService productCatalogService = new ProductCatalogService();
        if (shoppingCartEntityList != null)
        {
            for (ShoppingCartEntity shoppingCartEntity : shoppingCartEntityList)
            {
                BookCartCombine bookCartCombine = new BookCartCombine();
                bookCartCombine.setShoppingCartEntity(shoppingCartEntity);
                String bookId = shoppingCartEntity.getBookid();
                BookEntity bookEntity = productCatalogService.getProductInfo(bookId);
                bookCartCombine.setBookEntity(bookEntity);
                list.add(bookCartCombine);
            }
            hs.setAttribute("bookcartcomblist", list);
        } else {
            OrderProcessService orderProcessService = new OrderProcessService();
            shoppingCartEntityList = orderProcessService.DisplayShoppingCart(userId);
            for (ShoppingCartEntity shoppingCartEntity : shoppingCartEntityList)
            {
                BookCartCombine bookCartCombine = new BookCartCombine();
                bookCartCombine.setShoppingCartEntity(shoppingCartEntity);
                String bookId = shoppingCartEntity.getBookid();
                BookEntity bookEntity = productCatalogService.getProductInfo(bookId);
                bookCartCombine.setBookEntity(bookEntity);
                list.add(bookCartCombine);
            }
            hs.setAttribute("bookcartcomblist", list);
        }
        response.sendRedirect("/pages/mycart.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
