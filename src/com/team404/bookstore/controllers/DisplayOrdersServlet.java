package com.team404.bookstore.controllers;

import com.team404.bookstore.entity.*;
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


@WebServlet("/DisplayOrdersServlet")
/*
    Call this servlet to display all order information on orders page
 */
public class DisplayOrdersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession hs = request.getSession();
        UserEntity user = (UserEntity) hs.getAttribute("user");
        int userId = user.getId();

        OrderProcessService orderProcessService = new OrderProcessService();
        //get orderEntity list based on userid
        List<OrderEntity> orderEntityList = orderProcessService.DisplayMyOrder(userId);

        ProductCatalogService productCatalogService = new ProductCatalogService();
        List<OrderBookCombine> orderBookCombineList = new ArrayList<>();

        for(OrderEntity i : orderEntityList) {

            OrderEntity orderEntity = i;
            List<OrderBookEntity> orderBookEntities = orderProcessService.GetOrderBooks(i.getId());
            List<BookEntity> bookEntityList = new ArrayList<>();

            for(OrderBookEntity j : orderBookEntities) {
                BookEntity bookEntity = productCatalogService.getProductInfo(j.getBookid());
                bookEntityList.add(bookEntity);
            }

            OrderBookCombine orderBookCombine = new OrderBookCombine();
            orderBookCombine.setBookEntityList(bookEntityList);
            orderBookCombine.setOrderEntity(orderEntity);

            orderBookCombineList.add(orderBookCombine);

        }
        //put this list in the session
        hs.setAttribute("orderEntityList", orderBookCombineList);
        response.sendRedirect("/pages/orders.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
