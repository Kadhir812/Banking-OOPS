package com.example.bean;

public class Cart {
    private int cartId;
    private String ownerName;
    private double totalAmount;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Cart [cartId=" + cartId + ", ownerName=" + ownerName + ", totalAmount=" + totalAmount + "]";
    }
}
