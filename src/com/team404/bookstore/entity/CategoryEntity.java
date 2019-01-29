package com.team404.bookstore.entity;

import java.util.Objects;

public class CategoryEntity
{
    private int id;
    private String category;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return id == that.id &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, category);
    }
}
