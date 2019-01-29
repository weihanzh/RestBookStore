package com.team404.bookstore.entity;

import java.util.Objects;

public class ShoppingCartEntity
{
    private int id;
    private int userid;
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

    public int getUserid()
    {
        return userid;
    }

    public void setUserid(int userid)
    {
        this.userid = userid;
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
        ShoppingCartEntity that = (ShoppingCartEntity) o;
        return id == that.id &&
                userid == that.userid &&
                quantity == that.quantity &&
                Objects.equals(bookid, that.bookid);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, userid, bookid, quantity);
    }
}
