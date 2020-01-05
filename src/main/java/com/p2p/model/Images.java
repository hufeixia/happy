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

    private String remark;

    private String auditor;

    private String status;

    public Images(Integer iid, String identityid, String uname, String imgPath, String itype, Integer scope, String remark, String auditor, String status) {
        this.iid = iid;
        this.identityid = identityid;
        this.uname = uname;
        this.imgPath = imgPath;
        this.itype = itype;
        this.scope = scope;
        this.remark = remark;
        this.auditor = auditor;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Images{" +
                "iid=" + iid +
                ", identityid='" + identityid + '\'' +
                ", uname='" + uname + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", itype='" + itype + '\'' +
                ", scope=" + scope +
                ", remark='" + remark + '\'' +
                ", auditor='" + auditor + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}