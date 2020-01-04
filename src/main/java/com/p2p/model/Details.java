package com.p2p.model;

import lombok.ToString;

@ToString
public class Details {
    private Integer detailsId;

    private Integer did;

    private String detailsName;

    private String dname;

    public Details(Integer detailsId, String detailsName,Integer did,String dname) {
        this.detailsId = detailsId;
        this.detailsName = detailsName;
        this.did=did;
        this.dname=dname;
    }

    public Details() {
        super();
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Integer detailsId) {
        this.detailsId = detailsId;
    }

    public String getDetailsName() {
        return detailsName;
    }

    public void setDetailsName(String detailsName) {
        this.detailsName = detailsName;
    }
}