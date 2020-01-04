package com.p2p.service.impl;

import com.p2p.mapper.BankCartMapper;
import com.p2p.model.BankCart;
import com.p2p.service.IBankCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankCartServiceImpl implements IBankCartService {

    @Autowired
    private BankCartMapper bankCartMapper;

    @Override
    public int deleteByPrimaryKey(Integer bcid) {
        return 0;
    }

    @Override
    public int insert(BankCart record) {

        return bankCartMapper.insert(record);
    }

    @Override
    public int insertSelective(BankCart record) {
        return 0;
    }

    @Override
    public BankCart selectByPrimaryKey(Integer bcid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BankCart record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(BankCart record) {
        return 0;
    }

    @Override
    public List<BankCart> QueryBankCartBySfz(BankCart bankCart) {

        return bankCartMapper.QueryBankCartBySfz(bankCart);
    }
}
