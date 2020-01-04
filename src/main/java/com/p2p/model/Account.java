package com.p2p.model;

import lombok.ToString;

@ToString
public class Account {
    private Integer aid;

    private String uname;

    private Integer amount;

    private Integer avail;

    private Integer freeze;

    private Integer wait;

    private Integer astatus;

    private Integer money;

    public Account(Integer aid, String uname, Integer amount, Integer avail, Integer freeze, Integer wait, Integer astatus) {
        this.aid = aid;
        this.uname = uname;
        this.amount = amount;
        this.avail = avail;
        this.freeze = freeze;
        this.wait = wait;
        this.astatus = astatus;
    }

    public Account() {
        super();
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAvail() {
        return avail;
    }

    public void setAvail(Integer avail) {
        this.avail = avail;
    }

    public Integer getFreeze() {
        return freeze;
    }

    public void setFreeze(Integer freeze) {
        this.freeze = freeze;
    }

    public Integer getWait() {
        return wait;
    }

    public void setWait(Integer wait) {
        this.wait = wait;
    }

    public Integer getAstatus() {
        return astatus;
    }

    public void setAstatus(Integer astatus) {
        this.astatus = astatus;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "aid=" + aid +
                ", uname='" + uname + '\'' +
                ", amount=" + amount +
                ", avail=" + avail +
                ", freeze=" + freeze +
                ", wait=" + wait +
                ", astatus=" + astatus +
                '}';
    }
}