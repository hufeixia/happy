package com.p2p.model;

import java.util.Date;

public class Onloan {
    private Integer oid;

    private Integer uid;

    private Integer omoney;

    private String ointerest;

    private String timelimit;

    private String oremark;

    private Date ocreatedate;

    private String status;

    private String otitle;

    public Onloan(Integer oid, Integer uid, Integer omoney, String ointerest, String timelimit, String oremark, Date ocreatedate, String status, String otitle) {
        this.oid = oid;
        this.uid = uid;
        this.omoney = omoney;
        this.ointerest = ointerest;
        this.timelimit = timelimit;
        this.oremark = oremark;
        this.ocreatedate = ocreatedate;
        this.status = status;
        this.otitle = otitle;
    }

    public Onloan() {
        super();
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getOmoney() {
        return omoney;
    }

    public void setOmoney(Integer omoney) {
        this.omoney = omoney;
    }

    public String getOinterest() {
        return ointerest;
    }

    public void setOinterest(String ointerest) {
        this.ointerest = ointerest;
    }

    public String getTimelimit() {
        return timelimit;
    }

    public void setTimelimit(String timelimit) {
        this.timelimit = timelimit;
    }

    public String getOremark() {
        return oremark;
    }

    public void setOremark(String oremark) {
        this.oremark = oremark;
    }

    public Date getOcreatedate() {
        return ocreatedate;
    }

    public void setOcreatedate(Date ocreatedate) {
        this.ocreatedate = ocreatedate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOtitle() {
        return otitle;
    }

    public void setOtitle(String otitle) {
        this.otitle = otitle;
    }
}