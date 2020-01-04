package com.p2p.model;

import lombok.ToString;

import java.util.Date;

@ToString
public class Users {
    private Integer userid;

    private String username;

    private String password;

    private String salt;

    private String tel;

    private Date createdate;

    public Users(Integer userid, String username, String password, String salt, String tel, Date createdate) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.tel = tel;
        this.createdate = createdate;
    }

    public Users() {
        super();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}