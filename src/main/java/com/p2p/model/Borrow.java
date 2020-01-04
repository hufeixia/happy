package com.p2p.model;

import java.util.Date;

public class Borrow {
    private Integer borrowId;

    private String userName;

    private Integer borrowMoney;

    private String borrowInterest;

    private String borrowTitle;

    private String borrowBetweenDate;

    private Date borrowData;

    private String borrowRemark;

    private String method;

    private Integer borrowStatus;

    public Borrow(Integer borrowId, String userName, Integer borrowMoney, String borrowInterest, String borrowTitle, String borrowBetweenDate, Date borrowData, String borrowRemark, String method, Integer borrowStatus) {
        this.borrowId = borrowId;
        this.userName = userName;
        this.borrowMoney = borrowMoney;
        this.borrowInterest = borrowInterest;
        this.borrowTitle = borrowTitle;
        this.borrowBetweenDate = borrowBetweenDate;
        this.borrowData = borrowData;
        this.borrowRemark = borrowRemark;
        this.method = method;
        this.borrowStatus = borrowStatus;
    }

    public Borrow() {
        super();
    }

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getBorrowMoney() {
        return borrowMoney;
    }

    public void setBorrowMoney(Integer borrowMoney) {
        this.borrowMoney = borrowMoney;
    }

    public String getBorrowInterest() {
        return borrowInterest;
    }

    public void setBorrowInterest(String borrowInterest) {
        this.borrowInterest = borrowInterest;
    }

    public String getBorrowTitle() {
        return borrowTitle;
    }

    public void setBorrowTitle(String borrowTitle) {
        this.borrowTitle = borrowTitle;
    }

    public String getBorrowBetweenDate() {
        return borrowBetweenDate;
    }

    public void setBorrowBetweenDate(String borrowBetweenDate) {
        this.borrowBetweenDate = borrowBetweenDate;
    }

    public Date getBorrowData() {
        return borrowData;
    }

    public void setBorrowData(Date borrowData) {
        this.borrowData = borrowData;
    }

    public String getBorrowRemark() {
        return borrowRemark;
    }

    public void setBorrowRemark(String borrowRemark) {
        this.borrowRemark = borrowRemark;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer getBorrowStatus() {
        return borrowStatus;
    }

    public void setBorrowStatus(Integer borrowStatus) {
        this.borrowStatus = borrowStatus;
    }
}