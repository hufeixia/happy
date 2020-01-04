package com.p2p.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

@ToString
public class Repayment {
    private Integer rid;

    private Integer borrowid;

    private String uname;

    private String rtitle;

    private String rmothod;

    private Integer borrowmoney;

    private Integer repaymentmoney;

    private Integer remain;

    private String borrowdate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private String rdate;

    private Integer rstatus;

    public Repayment(Integer rid, Integer borrowid, String uname, String rtitle, String rmothod, Integer borrowmoney, Integer repaymentmoney, Integer remain, String borrowdate, String rdate, Integer rstatus) {
        this.rid = rid;
        this.borrowid = borrowid;
        this.uname = uname;
        this.rtitle = rtitle;
        this.rmothod = rmothod;
        this.borrowmoney = borrowmoney;
        this.repaymentmoney = repaymentmoney;
        this.remain = remain;
        this.borrowdate = borrowdate;
        this.rdate = rdate;
        this.rstatus = rstatus;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getBorrowid() {
        return borrowid;
    }

    public void setBorrowid(Integer borrowid) {
        this.borrowid = borrowid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getRtitle() {
        return rtitle;
    }

    public void setRtitle(String rtitle) {
        this.rtitle = rtitle;
    }

    public String getRmothod() {
        return rmothod;
    }

    public void setRmothod(String rmothod) {
        this.rmothod = rmothod;
    }

    public Integer getBorrowmoney() {
        return borrowmoney;
    }

    public void setBorrowmoney(Integer borrowmoney) {
        this.borrowmoney = borrowmoney;
    }

    public Integer getRepaymentmoney() {
        return repaymentmoney;
    }

    public void setRepaymentmoney(Integer repaymentmoney) {
        this.repaymentmoney = repaymentmoney;
    }

    public Integer getRemain() {
        return remain;
    }

    public void setRemain(Integer remain) {
        this.remain = remain;
    }

    public String getBorrowdate() {
        return borrowdate;
    }

    public void setBorrowdate(String borrowdate) {
        this.borrowdate = borrowdate;
    }

    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate;
    }

    public Integer getRstatus() {
        return rstatus;
    }

    public void setRstatus(Integer rstatus) {
        this.rstatus = rstatus;
    }

    @Override
    public String toString() {
        return "Repayment{" +
                "rid=" + rid +
                ", borrowid=" + borrowid +
                ", uname='" + uname + '\'' +
                ", rtitle='" + rtitle + '\'' +
                ", rmothod='" + rmothod + '\'' +
                ", borrowmoney=" + borrowmoney +
                ", repaymentmoney=" + repaymentmoney +
                ", remain=" + remain +
                ", borrowdate='" + borrowdate + '\'' +
                ", rdate='" + rdate + '\'' +
                ", rstatus=" + rstatus +
                '}';
    }
}