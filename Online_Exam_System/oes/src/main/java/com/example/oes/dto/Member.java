package com.example.oes.dto;

public class Member {
    private int userId;
    private String name;
    private String email;

    Member() { }

    public Member(int userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
