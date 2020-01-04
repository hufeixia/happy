package com.p2p.mapper;

import com.p2p.model.BankCart;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BankCartMapper {
    int deleteByPrimaryKey(Integer bcid);

    int insert(BankCart record);

    int insertSelective(BankCart record);

    BankCart selectByPrimaryKey(Integer bcid);

    int updateByPrimaryKeySelective(BankCart record);

    int updateByPrimaryKey(BankCart record);

    List<BankCart> QueryBankCartBySfz(BankCart bankCart);

}