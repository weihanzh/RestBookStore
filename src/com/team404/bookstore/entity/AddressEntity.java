package com.team404.bookstore.entity;

import java.util.Objects;

public class AddressEntity
{
    private int id;
    private String street;
    private String province;
    private String country;
    private String zip;
    private String phone;
    private int userid;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getProvince()
    {
        return province;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getZip()
    {
        return zip;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public int getUserid()
    {
        return userid;
    }

    public void setUserid(int userid)
    {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return id == that.id &&
                userid == that.userid &&
                Objects.equals(street, that.street) &&
                Objects.equals(province, that.province) &&
                Objects.equals(country, that.country) &&
                Objects.equals(zip, that.zip) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, street, province, country, zip, phone, userid);
    }
}
