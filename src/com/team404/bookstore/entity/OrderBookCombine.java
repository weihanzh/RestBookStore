package com.team404.bookstore.entity;

import java.util.List;
import java.util.Objects;

public class OrderBookCombine
{
    private OrderEntity orderEntity;
    private List<BookEntity> bookEntityList;

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public List<BookEntity> getBookEntityList() {
        return bookEntityList;
    }

    public void setBookEntityList(List<BookEntity> bookEntityList) {
        this.bookEntityList = bookEntityList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderBookCombine that = (OrderBookCombine) o;
        return Objects.equals(orderEntity, that.orderEntity) &&
                Objects.equals(bookEntityList, that.bookEntityList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderEntity, bookEntityList);
    }
}
