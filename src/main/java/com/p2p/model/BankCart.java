package com.p2p.model;

import lombok.ToString;

@ToString
public class BankCart {
    private Integer bcid;

    private String bsfz;

    private String bealname;

    private String bcartid;

    private String btel;

    private String btype;

    public BankCart(Integer bcid, String bsfz, String bealname, String bcartid, String btel, String btype) {
        this.bcid = bcid;
        this.bsfz = bsfz;
        this.bealname = bealname;
        this.bcartid = bcartid;
        this.btel = btel;
        this.btype = btype;
    }

    public BankCart() {
        super();
    }

    public Integer getBcid() {
        return bcid;
    }

    public void setBcid(Integer bcid) {
        this.bcid = bcid;
    }

    public String getBsfz() {
        return bsfz;
    }

    public void setBsfz(String bsfz) {
        this.bsfz = bsfz;
    }

    public String getBealname() {
        return bealname;
    }

    public void setBealname(String bealname) {
        this.bealname = bealname;
    }

    public String getBcartid() {
        return bcartid;
    }

    public void setBcartid(String bcartid) {
        this.bcartid = bcartid;
    }

    public String getBtel() {
        return btel;
    }

    public void setBtel(String btel) {
        this.btel = btel;
    }

    public String getBtype() {
        return btype;
    }

    public void setBtype(String btype) {
        this.btype = btype;
    }
}