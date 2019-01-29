package com.team404.bookstore.entity;

import java.util.Objects;

public class OrderBookEntity
{
    private int id;
    private int orderid;
    private String bookid;
    private int quantity;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getOrderid()
    {
        return orderid;
    }

    public void setOrderid(int orderid)
    {
        this.orderid = orderid;
    }

    public String getBookid()
    {
        return bookid;
    }

    public void setBookid(String bookid)
    {
        this.bookid = bookid;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderBookEntity that = (OrderBookEntity) o;
        return id == that.id &&
                orderid == that.orderid &&
                quantity == that.quantity &&
                Objects.equals(bookid, that.bookid);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, orderid, bookid, quantity);
    }
}
