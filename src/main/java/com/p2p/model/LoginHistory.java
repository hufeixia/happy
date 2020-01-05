package com.p2p.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import java.util.Date;

/**
 * 登录历史
 */
@ToString
public class LoginHistory {
    private Integer historyId;

    private String uName;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date historyDate;

    private String startDate;
    private String endDate;


    public LoginHistory(Integer historyId, String uName, Date historyDate,String startDate,String endDate) {
        this.historyId = historyId;
        this.uName = uName;
        this.historyDate = historyDate;
        this.startDate = startDate;
        this.endDate = endDate;
    }


    public LoginHistory() {
        super();
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Date getHistoryDate() {
        return historyDate;
    }

    public void setHistoryDate(Date historyDate) {
        this.historyDate = historyDate;
    }
}