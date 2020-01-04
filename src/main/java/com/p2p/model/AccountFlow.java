package com.p2p.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import java.util.Date;

@ToString
public class AccountFlow {
    private Integer flowId;

    private String userName;

    private String flowType;

    private Integer flowMoney;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date flowDate;

    //时间
    private String startDate;
    private String endDate;

    public AccountFlow(Integer flowId, String userName, String flowType, Integer flowMoney, Date flowDate,String endDate,String startDate) {
        this.flowId = flowId;
        this.userName = userName;
        this.flowType = flowType;
        this.flowMoney = flowMoney;
        this.flowDate = flowDate;
        this.endDate = endDate;
        this.startDate = startDate;
    }

    public AccountFlow() {
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