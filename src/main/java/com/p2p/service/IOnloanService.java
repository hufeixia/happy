package com.p2p.service;

import com.p2p.model.Onloan;

public interface IOnloanService {
    int deleteByPrimaryKey(Integer oid);

    int insert(Onloan record);

    int insertSelective(Onloan record);

    Onloan selectByPrimaryKey(Integer oid);

    int updateByPrimaryKeySelective(Onloan record);

    int updateByPrimaryKey(Onloan record);
}