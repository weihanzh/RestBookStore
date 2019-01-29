package com.team404.bookstore.dao;

import com.team404.bookstore.entity.ShoppingCartEntity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;


import java.util.List;

public class ShoppingCartDao {
    private static SessionFactory sessionFactory =
            new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();


    public boolean AddShoppingCart(ShoppingCartEntity shoppingCartEntity) {
        boolean flag = true;
        Session session = sessionFactory.openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(shoppingCartEntity);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            flag = false;
        } finally {
            session.close();
        }
        return  flag;
    }

    public List<ShoppingCartEntity> GetShoppingCartByUid(int userid) {
        Session session = sessionFactory.openSession();

        List<ShoppingCartEntity> list = null;

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.getNamedQuery("getCartQuery");
            query.setParameter("userid", userid);
            list = query.list();
            transaction.commit();
        }catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    public boolean DeleteShoppingCartItemsBySid(List<Integer> idList) {
        Session session = sessionFactory.openSession();
        boolean flag = true;

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            for(Integer val : idList) {
                Query query = session.getNamedQuery("DeleteItemsQuery");
                query.setParameter("val", val);
                query.executeUpdate();
                transaction.commit();
            }
            transaction.commit();
        }catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            flag = false;
        } finally {
            session.close();
        }
        return flag;
    }

    public boolean DeleteShoppingItems(int userid) {
        Session session = sessionFactory.openSession();
        boolean flag = true;

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.getNamedQuery("DeleteItemsByUidQuery");
            query.setParameter("userid", userid);
            query.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            flag = false;
        } finally {
            session.close();
        }
        return flag;
    }

    public boolean DeleteShoppingItemById(int id) {
        Session session = sessionFactory.openSession();
        boolean flag = true;

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.getNamedQuery("DeleteItemByIdQuery");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            flag = false;
        } finally {
            session.close();
        }
        return flag;
    }

    public ShoppingCartEntity GetCartItem(int userid, String bookid) {
        Session session = sessionFactory.openSession();
        ShoppingCartEntity shoppingCartEntity1 = null;

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.getNamedQuery("GetCartItemQuery");
            query.setParameter("userid", userid);
            query.setParameter("bookid", bookid);
            List<ShoppingCartEntity> list = query.list();
            transaction.commit();
            if(list.size() != 0) {
                shoppingCartEntity1 = list.get(0);
            }
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return  shoppingCartEntity1;
    }

    public boolean UpdateItemQuantity(ShoppingCartEntity shoppingCartEntity) {
        Session session = sessionFactory.openSession();
        boolean flag = true;
        Transaction transaction = null;

        ShoppingCartEntity shoppingCartEntity1 = GetCartItem(shoppingCartEntity.getUserid(), shoppingCartEntity.getBookid());
        int previouQuantity = shoppingCartEntity1.getQuantity();

        try {
            transaction = session.beginTransaction();
            Query query = session.getNamedQuery("UpdateItemQuantityQuery");
            query.setParameter("quantity", shoppingCartEntity.getQuantity()+previouQuantity);
            query.setParameter("id", shoppingCartEntity1.getId());
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            flag = false;
        }finally {
            session.close();
        }

        return  flag;
    }
}