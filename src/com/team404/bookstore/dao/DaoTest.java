package com.team404.bookstore.dao;

import com.team404.bookstore.entity.BookEntity;

import java.util.List;

public class DaoTest
{
    public static void main(String args[]){
        BookDao bookDao = new BookDao();
        List<BookEntity> list = bookDao.ListBook();
        System.out.println(list);
    }
}
