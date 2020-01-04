package com.p2p.mapper;

import com.p2p.dto.AccountMoneyDto;
import com.p2p.model.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    Account QueryAccount(Account record);

    int UpdateAccountAlipayMoney(Account record);


}