package com.p2p.model;

import java.util.Date;

public class Message {
    private Integer mid;

    private Integer uid;

    private String mname;

    private String msex;

    private String elite;

    private String mcartid;

    private Date bosdy;

    private String maddress;

    private String organ;

    private String education;

    private String marital;

    private Integer monthly;

    private String thing;

    private String housing;

    public Message(Integer mid, Integer uid, String mname, String msex, String elite, String mcartid, Date bosdy, String maddress, String organ, String education, String marital, Integer monthly, String thing, String housing) {
        this.mid = mid;
        this.uid = uid;
        this.mname = mname;
        this.msex = msex;
        this.elite = elite;
        this.mcartid = mcartid;
        this.bosdy = bosdy;
        this.maddress = maddress;
        this.organ = organ;
        this.education = education;
        this.marital = marital;
        this.monthly = monthly;
        this.thing = thing;
        this.housing = housing;
    }

    public Message() {
        super();
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMsex() {
        return msex;
    }

    public void setMsex(String msex) {
        this.msex = msex;
    }

    public String getElite() {
        return elite;
    }

    public void setElite(String elite) {
        this.elite = elite;
    }

    public String getMcartid() {
        return mcartid;
    }

    public void setMcartid(String mcartid) {
        this.mcartid = mcartid;
    }

    public Date getBosdy() {
        return bosdy;
    }

    public void setBosdy(Date bosdy) {
        this.bosdy = bosdy;
    }

    public String getMaddress() {
        return maddress;
    }

    public void setMaddress(String maddress) {
        this.maddress = maddress;
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMarital() {
        return marital;
    }

    public void setMarital(String marital) {
        this.marital = marital;
    }

    public Integer getMonthly() {
        return monthly;
    }

    public void setMonthly(Integer monthly) {
        this.monthly = monthly;
    }

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }

    public String getHousing() {
        return housing;
    }

    public void setHousing(String housing) {
        this.housing = housing;
    }
}