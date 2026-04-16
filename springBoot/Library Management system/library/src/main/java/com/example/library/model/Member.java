package com.example.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;
    private String memberName;
    private String emailId;
    private String password;
    private String phoneNumber;

    public Member() {
    }

    public Member(String memberName, String emailId, String password, String phoneNumber) {
        this.memberName = memberName;
        this.emailId = emailId;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public Member(int memberId, String memberName, String emailId, String password, String phoneNumber) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.emailId = emailId;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Member [memberId=" + memberId + ", memberName=" + memberName + ", emailId=" + emailId
                + ", phoneNumber=" + phoneNumber + "]";
    }
}