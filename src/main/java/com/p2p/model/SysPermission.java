package com.p2p.model;

import lombok.ToString;

@ToString
public class SysPermission {
    private Integer perid;

    private String pername;

    private Integer pid;

    private String permission;

    public SysPermission(Integer perid, String pername, Integer pid, String permission) {
        this.perid = perid;
        this.pername = pername;
        this.pid = pid;
        this.permission = permission;
    }

    public SysPermission() {
        super();
    }

    public Integer getPerid() {
        return perid;
    }

    public void setPerid(Integer perid) {
        this.perid = perid;
    }

    public String getPername() {
        return pername;
    }

    public void setPername(String pername) {
        this.pername = pername;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}