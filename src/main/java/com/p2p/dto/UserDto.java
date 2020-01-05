package com.p2p.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import java.util.Date;

@ToString
//链表查询的对象
public class UserDto {


//    select u.username,u.createdate,u.tel,i.realname,i.cartid,i.istatus from t_sys_user u left join identity i on  u.username = i.uname
//p.grxl,p.marriage,p.thing,p.housing

    private String username;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createdate;
    private String realname;
    private String cartid;
    private String istatus;
    private String grxl;//学历
    private Integer profit;
    private String marriage;
    private String thing;
    private String housing;


    public UserDto(){}

    public UserDto(String username, Date createdate, String realname, String cartid, String istatus, String grxl, Integer profit, String marriage, String thing, String housing) {
        this.username = username;
        this.createdate = createdate;
        this.realname = realname;
        this.cartid = cartid;
        this.istatus = istatus;
        this.grxl = grxl;
        this.profit = profit;
        this.marriage = marriage;
        this.thing = thing;
        this.housing = housing;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getCartid() {
        return cartid;
    }

    public void setCartid(String cartid) {
        this.cartid = cartid;
    }

    public String getIstatus() {
        return istatus;
    }

    public void setIstatus(String istatus) {
        this.istatus = istatus;
    }
}
