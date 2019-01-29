package com.team404.bookstore.dao;

import com.team404.bookstore.entity.BookEntity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;


import java.util.List;

public class BookDao {
    private static SessionFactory sessionFactory;

    public List<BookEntity> ListBook() {
        List<BookEntity> list = null;
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            list = session.getNamedQuery("ListBookQuery").list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    public List<BookEntity> ListBook(int categoryid) {
        List<BookEntity> list = null;
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.getNamedQuery("ListBookByCidQuery");
            query.setParameter("categoryid", categoryid);
            list = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    public BookEntity GetBookById(String id) {
        BookEntity bookEntity = null;
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            bookEntity= (BookEntity) session.get(BookEntity.class, id);
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return  bookEntity;
    }

}