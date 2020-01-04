package com.p2p.model;

public class Base {
    private Integer bid;

    private String bname;

    private String bytpe;

    private String bstatus;

    private String breamrk;

    public Base(Integer bid, String bname, String bytpe, String bstatus, String breamrk) {
        this.bid = bid;
        this.bname = bname;
        this.bytpe = bytpe;
        this.bstatus = bstatus;
        this.breamrk = breamrk;
    }

    public Base() {
        super();
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBytpe() {
        return bytpe;
    }

    public void setBytpe(String bytpe) {
        this.bytpe = bytpe;
    }

    public String getBstatus() {
        return bstatus;
    }

    public void setBstatus(String bstatus) {
        this.bstatus = bstatus;
    }

    public String getBreamrk() {
        return breamrk;
    }

    public void setBreamrk(String breamrk) {
        this.breamrk = breamrk;
    }
}