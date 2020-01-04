package com.p2p.model;

import lombok.ToString;

@ToString
public class SysUserRole {
    private Integer urid;

    private Integer userid;

    private Integer roleid;

    public SysUserRole(Integer urid, Integer userid, Integer roleid) {
        this.urid = urid;
        this.userid = userid;
        this.roleid = roleid;
    }

    public SysUserRole() {
        super();
    }

    public Integer getUrid() {
        return urid;
    }

    public void setUrid(Integer urid) {
        this.urid = urid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
}