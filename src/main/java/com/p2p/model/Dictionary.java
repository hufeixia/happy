package com.p2p.model;

import lombok.ToString;

@ToString
public class Dictionary {
    private Integer did;

    private String dname;

    private String dsynopsis;

    private String dictIsEditable;

    public Dictionary(Integer did, String dname, String dsynopsis, String dictIsEditable) {
        this.did = did;
        this.dname = dname;
        this.dsynopsis = dsynopsis;
        this.dictIsEditable = dictIsEditable;
    }

    public Dictionary() {
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

    public String getDsynopsis() {
        return dsynopsis;
    }

    public void setDsynopsis(String dsynopsis) {
        this.dsynopsis = dsynopsis;
    }

    public String getDictIsEditable() {
        return dictIsEditable;
    }

    public void setDictIsEditable(String dictIsEditable) {
        this.dictIsEditable = dictIsEditable;
    }
}