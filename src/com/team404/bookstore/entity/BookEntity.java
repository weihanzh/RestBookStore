package com.team404.bookstore.entity;

import java.util.Objects;

public class BookEntity
{
    private String bookid;
    private String title;
    private int price;
    private String author;
    private int categoryid;
    private String imgUrl;
    private String description;
    private Integer publisherYear;

    public String getBookid()
    {
        return bookid;
    }

    public void setBookid(String bookid)
    {
        this.bookid = bookid;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public int getCategoryid()
    {
        return categoryid;
    }

    public void setCategoryid(int categoryid)
    {
        this.categoryid = categoryid;
    }

    public String getImgUrl()
    {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Integer getPublisherYear()
    {
        return publisherYear;
    }

    public void setPublisherYear(Integer publisherYear)
    {
        this.publisherYear = publisherYear;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return price == that.price &&
                categoryid == that.categoryid &&
                Objects.equals(bookid, that.bookid) &&
                Objects.equals(title, that.title) &&
                Objects.equals(author, that.author) &&
                Objects.equals(imgUrl, that.imgUrl) &&
                Objects.equals(description, that.description) &&
                Objects.equals(publisherYear, that.publisherYear);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(bookid, title, price, author, categoryid, imgUrl, description, publisherYear);
    }
}
