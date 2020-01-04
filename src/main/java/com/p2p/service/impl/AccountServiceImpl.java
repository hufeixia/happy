package com.p2p.service.impl;

import com.p2p.dto.AccountMoneyDto;
import com.p2p.mapper.AccountMapper;
import com.p2p.model.Account;
import com.p2p.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public int deleteByPrimaryKey(Integer aid) {
        return 0;
    }

    @Override
    public int insert(Account record) {
        return 0;
    }

    @Override
    public int insertSelective(Account record) {
        return 0;
    }

    @Override
    public Account selectByPrimaryKey(Integer aid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Account record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Account record) {

        return accountMapper.updateByPrimaryKey(record);
    }

    @Override
    public Account QueryAccount(Account record) {
        return accountMapper.QueryAccount(record);
    }

    @Override
    public int UpdateAccountAlipayMoney(Account record) {
        return accountMapper.UpdateAccountAlipayMoney(record);
    }
}
