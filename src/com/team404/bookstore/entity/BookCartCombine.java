package com.team404.bookstore.entity;

import java.util.Objects;

public class BookCartCombine
{
    private BookEntity bookEntity;
    private ShoppingCartEntity shoppingCartEntity;

    public BookEntity getBookEntity()
    {
        return bookEntity;
    }

    public void setBookEntity(BookEntity bookEntity)
    {
        this.bookEntity = bookEntity;
    }

    public ShoppingCartEntity getShoppingCartEntity()
    {
        return shoppingCartEntity;
    }

    public void setShoppingCartEntity(ShoppingCartEntity shoppingCartEntity)
    {
        this.shoppingCartEntity = shoppingCartEntity;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof BookCartCombine)) return false;
        BookCartCombine that = (BookCartCombine) o;
        return Objects.equals(getBookEntity(), that.getBookEntity()) &&
                Objects.equals(getShoppingCartEntity(), that.getShoppingCartEntity());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getBookEntity(), getShoppingCartEntity());
    }
}
