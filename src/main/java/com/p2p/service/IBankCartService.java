package com.p2p.service;

import com.p2p.model.BankCart;

import java.util.List;

public interface IBankCartService {
    int deleteByPrimaryKey(Integer bcid);

    int insert(BankCart record);

    int insertSelective(BankCart record);

    BankCart selectByPrimaryKey(Integer bcid);

    int updateByPrimaryKeySelective(BankCart record);

    int updateByPrimaryKey(BankCart record);

    List<BankCart> QueryBankCartBySfz(BankCart bankCart);
}