package com.p2p.dto;

import lombok.ToString;

@ToString
public class AccountMoneyDto {
    private Integer money;

    public AccountMoneyDto(){
    }

    public AccountMoneyDto(Integer money) {
        this.money = money;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "AccountMoneyDto{" +
                "money=" + money +
                '}';
    }
}
