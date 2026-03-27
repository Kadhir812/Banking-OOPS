package com.example.junitlifecycle;

public class Bank {
    private int balance;
    private String account;
    private String name;
    private String email;

    public Bank(int balance, String account, String name, String email) {
        this.balance = balance;
        this.account = account;
        this.name = name;
        this.email = email;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    @Override
    public String toString() {
        return "Bank [balance=" + balance + ", account=" + account + ", name=" + name + ", email=" + email + "]";
    }


    public void deposit(int amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
           System.out.println("Deposit valid amount");
        }
    }

    
    public void withdraw(int amount) {
        if (amount > 0) {
            if (this.balance - amount >= 1500) {
                this.balance -= amount;
            } else {
                System.out.println("Cannot withdraw maintain balance 1500");
            }
        } else {
            System.out.println("Withdraw valid amount");
        }
    }

    

    
}
