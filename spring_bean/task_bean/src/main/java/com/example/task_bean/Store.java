package com.example.task_bean;

import org.springframework.beans.factory.annotation.Autowired;

public class Store {
    String storeName;
    String location;
    String ownerName;

    @Autowired
    Product pr;

   
    
    
    public Store() {
    }
    
    
    public Store(String storeName, String location, String ownerName) {
        this.storeName = storeName;
        this.location = location;
        this.ownerName = ownerName;
    }
    
    
    public String getStoreName() {
        return storeName;
    }
    
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }


    public Product getPr() {
        return pr;
    }


    public void setPr(Product pr) {
        this.pr = pr;
    }
    
    @Override
    public String toString() {
        return "Store [storeName=" + storeName + ", location=" + location + ", ownerName=" + ownerName + ", pr=" + pr + "]";
    }

    
}
