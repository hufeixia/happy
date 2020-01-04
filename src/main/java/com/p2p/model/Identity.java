package com.p2p.model;

import lombok.ToString;

@ToString
public class Identity {
    private String iid;

    private String uname;

    private String realname;

    private String sex;

    private String cartid;

    private String bosdy;

    private String idaddress;

    private String istatus;

    public Identity(String iid, String uname, String realname, String sex, String cartid, String bosdy, String idaddress, String istatus) {
        this.iid = iid;
        this.uname = uname;
        this.realname = realname;
        this.sex = sex;
        this.cartid = cartid;
        this.bosdy = bosdy;
        this.idaddress = idaddress;
        this.istatus = istatus;
    }

    public Identity() {
        super();
    }

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCartid() {
        return cartid;
    }

    public void setCartid(String cartid) {
        this.cartid = cartid;
    }

    public String getBosdy() {
        return bosdy;
    }

    public void setBosdy(String bosdy) {
        this.bosdy = bosdy;
    }

    public String getIdaddress() {
        return idaddress;
    }

    public void setIdaddress(String idaddress) {
        this.idaddress = idaddress;
    }

    public String getIstatus() {
        return istatus;
    }

    public void setIstatus(String istatus) {
        this.istatus = istatus;
    }
}