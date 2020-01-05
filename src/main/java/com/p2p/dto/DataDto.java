package com.p2p.dto;

import lombok.ToString;

@ToString
public class DataDto {
    private String endDate;
    private String startDate;

    public DataDto(){}

    public DataDto(String endDate, String startDate) {
        this.endDate = endDate;
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
