package com.team404.bookstore.entity;

import java.sql.Timestamp;
import java.util.Objects;

public class OrderEntity
{
    private int id;
    private int userid;
    private Timestamp generationtime;
    private double totalprice;
    private Integer addressid;
    private String status;
    private double shipping;
    private double tax;
    private double aftertaxprice;
    private int amount;

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

    public Timestamp getGenerationtime()
    {
        return generationtime;
    }

    public void setGenerationtime(Timestamp generationtime)
    {
        this.generationtime = generationtime;
    }

    public double getTotalprice()
    {
        return totalprice;
    }

    public void setTotalprice(double totalprice)
    {
        this.totalprice = totalprice;
    }

    public Integer getAddressid()
    {
        return addressid;
    }

    public void setAddressid(Integer addressid)
    {
        this.addressid = addressid;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public double getShipping()
    {
        return shipping;
    }

    public void setShipping(double shipping)
    {
        this.shipping = shipping;
    }

    public double getTax()
    {
        return tax;
    }

    public void setTax(double tax)
    {
        this.tax = tax;
    }

    public double getAftertaxprice()
    {
        return aftertaxprice;
    }

    public void setAftertaxprice(double aftertaxprice)
    {
        this.aftertaxprice = aftertaxprice;
    }

    public int getAmount()
    {
        return amount;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return id == that.id &&
                userid == that.userid &&
                Double.compare(that.totalprice, totalprice) == 0 &&
                Double.compare(that.shipping, shipping) == 0 &&
                Double.compare(that.tax, tax) == 0 &&
                Double.compare(that.aftertaxprice, aftertaxprice) == 0 &&
                amount == that.amount &&
                Objects.equals(generationtime, that.generationtime) &&
                Objects.equals(addressid, that.addressid) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, userid, generationtime, totalprice, addressid, status, shipping, tax, aftertaxprice, amount);
    }
}
