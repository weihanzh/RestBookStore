package com.team404.bookstore.dao;

import com.team404.bookstore.entity.OrderEntity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;


import java.util.List;

public class OrderDao {
    private static SessionFactory sessionFactory =
            new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

    public int AddOrder (OrderEntity orderEntity) {
        Session session = sessionFactory.openSession();
        int id = 0;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(orderEntity);
            transaction.commit();
            id = orderEntity.getId();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return id;
    }

    public List<OrderEntity> GetOdersByUid(int userid) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<OrderEntity> list = null;

        try {
            transaction = session.beginTransaction();
            Query query = session.getNamedQuery("GetOdersByUidQuery");
            query.setParameter("userid", userid);
            list = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    public void UpdateOrderStatus(int id, boolean flag) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Query query = session.getNamedQuery("UpdateOrderStatusQuery");
            if(flag) {
                query.setParameter("status", "Success");
            } else {
                query.setParameter("status", "Failed");
            }
            query.setParameter("id", id);
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
