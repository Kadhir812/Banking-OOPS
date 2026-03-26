package com.example.crud.dto;

public class Product {
    int productId;
    String productName;
    double price;
    String city;
    
     Product() {}
     
    public Product(int productId, String productName, double price, String city) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.city = city;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", city=" + city + "]";
    }

}
