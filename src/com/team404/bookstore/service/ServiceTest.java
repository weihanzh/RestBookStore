package com.team404.bookstore.service;

import com.team404.bookstore.entity.AddressEntity;
import com.team404.bookstore.entity.UserEntity;

public class ServiceTest {

    public static void main(String args[]){
        UserEntity userEntity = new UserEntity();
        AddressEntity addressEntity = new AddressEntity();
        OrderProcessService orderProcessService = new OrderProcessService();
        ProductCatalogService productCatalogService = new ProductCatalogService();


/*        userEntity.setUsername("weiw4180@163.com");
        userEntity.setPassword("123123");
        userEntity.setFirstname("Wei");
        userEntity.setLastname("Wei");
        addressEntity.setCountry("Canada"); addressEntity.setProvince("ON");
        addressEntity.setStreet("190 Lees Ave 212"); addressEntity.setZip("K1S 5L5");
        addressEntity.setPhone("17600364180");*/

//        System.out.println(orderProcessService.getUserinfo(10).getUsername());

//        List<CategoryEntity> list = productCatalogService.getCategoryList();
//        for(int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getId()+" "+list.get(i).getCategory());
//        }

//        List<BookEntity> list = productCatalogService.getProductList(1);
//        for(int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getBookid() + " " + list.get(i).getTitle() + " " + list.get(i).getCategoryid());
//        }

//        BookEntity bookEntity = productCatalogService.getProductInfo("1627794258");
//        System.out.println(bookEntity.getBookid() + " " + bookEntity.getTitle() + " " + bookEntity. getPrice());

//        CategoryEntity categoryEntity = productCatalogService.getCategory(1);
////        System.out.println(categoryEntity.getId() + " " + categoryEntity.getCategory());



    }
}
