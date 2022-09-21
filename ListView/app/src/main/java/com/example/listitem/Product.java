package com.example.listitem;


public class Product {
    int imgView, add, minus;
    String name, infor;
    int price;
    int productID;

    public Product(int productID, String name,String infor, int price, int imgView, int add, int minus) {
        this.name = name;
        this.infor = infor;
        this.price = price;
        this.productID = productID;
        this.imgView = imgView;
        this.add = add;
        this.minus = minus;
    }
}
