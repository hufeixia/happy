package com.p2p.model;

import lombok.ToString;

@ToString
public class Images {
    private Integer iid;

    private String identityid;

    private String uname;

    private String imgPath;

    private String itype;

    private Integer scope;

    private String status;

    public Images(Integer iid, String identityid, String uname, String imgPath, String itype, Integer scope, String status) {
        this.iid = iid;
        this.identityid = identityid;
        this.uname = uname;
        this.imgPath = imgPath;
        this.itype = itype;
        this.scope = scope;
        this.status = status;
    }

    public Images() {
        super();
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public String getIdentityid() {
        return identityid;
    }

    public void setIdentityid(String identityid) {
        this.identityid = identityid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getItype() {
        return itype;
    }

    public void setItype(String itype) {
        this.itype = itype;
    }

    public Integer getScope() {
        return scope;
    }

    public void setScope(Integer scope) {
        this.scope = scope;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}