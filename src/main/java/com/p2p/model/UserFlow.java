package com.p2p.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import java.util.Date;

@ToString
public class UserFlow {
    private Integer flowId;

    private String userName;

    private String flowType;

    private Integer flowMoney;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date flowDate;

    private String flowStatus;

    public UserFlow(Integer flowId, String userName, String flowType, Integer flowMoney, Date flowDate, String flowStatus) {
        this.flowId = flowId;
        this.userName = userName;
        this.flowType = flowType;
        this.flowMoney = flowMoney;
        this.flowDate = flowDate;
        this.flowStatus = flowStatus;
    }

    public UserFlow() {
        super();
    }

    public String getFlowStatus() {
        return flowStatus;
    }

    public void setFlowStatus(String flowStatus) {
        this.flowStatus = flowStatus;
    }

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFlowType() {
        return flowType;
    }

    public void setFlowType(String flowType) {
        this.flowType = flowType;
    }

    public Integer getFlowMoney() {
        return flowMoney;
    }

    public void setFlowMoney(Integer flowMoney) {
        this.flowMoney = flowMoney;
    }

    public Date getFlowDate() {
        return flowDate;
    }

    public void setFlowDate(Date flowDate) {
        this.flowDate = flowDate;
    }
}