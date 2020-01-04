package com.p2p.model;

import lombok.ToString;

@ToString
public class Personal {
    private Integer pid;

    private String uname;

    private String grxl;

    private Integer profit;

    private String marriage;

    private String thing;

    private String housing;

    private String pstatus;

    public Personal(Integer pid, String uname,String grxl, Integer profit, String marriage, String thing, String housing, String pstatus) {
        this.pid = pid;
        this.uname = uname;
        this.grxl = grxl;
        this.profit = profit;
        this.marriage = marriage;
        this.thing = thing;
        this.housing = housing;
        this.pstatus = pstatus;
    }

    public Personal() {
        super();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getGrxl() {
        return grxl;
    }

    public void setGrxl(String grxl) {
        this.grxl = grxl;
    }

    public Integer getProfit() {
        return profit;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
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

    public String getPstatus() {
        return pstatus;
    }

    public void setPstatus(String pstatus) {
        this.pstatus = pstatus;
    }
}