package com.team404.bookstore.service;

import com.team404.bookstore.dao.BookDao;
import com.team404.bookstore.dao.CategoryDao;
import com.team404.bookstore.entity.BookEntity;
import com.team404.bookstore.entity.CategoryEntity;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/ProductCatalog")
public class ProductCatalogService {

    private CategoryDao categoryDao;
    private BookDao bookDao;

    /* gets the list of product categories for the store */
    @GET
    @Path("/getCategoryList")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoryEntity> getCategoryList() {
        categoryDao = new CategoryDao();

        List<CategoryEntity> list = categoryDao.ListCategory();

        return list;
    }

    /*gets the list of products*/
    @GET
    @Path("/getProductList")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BookEntity> getProductList() {
        bookDao = new BookDao();
        List<BookEntity> list = null;

        list = bookDao.ListBook();

        return list;
    }

    /*gets the list of products for a category*/
    @GET
    @Path("/getProductList/{categoryid}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BookEntity> getProductList(@PathParam("categoryid") int categoryid) {
        bookDao = new BookDao();
        List<BookEntity> list = null;

        list = bookDao.ListBook(categoryid);

        return list;
    }

    /* gets the detailed product information for a product.*/
    @GET
    @Path("/getProductInfo/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public BookEntity getProductInfo(@PathParam("id") String id) {
        bookDao = new BookDao();
        BookEntity bookEntity = null;

        bookEntity = bookDao.GetBookById(id);

        return  bookEntity;
    }

    /*get the detailed Category info*/
    @GET
    @Path("/getCategory/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CategoryEntity getCategory(@PathParam("id") int id) {
        categoryDao = new CategoryDao();

        CategoryEntity categoryEntity = categoryDao.getCategoryById(id);

        return categoryEntity;
    }

}
