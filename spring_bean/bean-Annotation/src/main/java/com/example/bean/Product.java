package com.example.bean;

public class Product {
    int productId;
   String productName;
   double price;
   Cart cartObj;

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

    public Cart getCartObj() {
        return cartObj;
    }

    public void setCartObj(Cart cartObj) {
        this.cartObj = cartObj;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", cartObj=" + cartObj + "]";
    }
}
