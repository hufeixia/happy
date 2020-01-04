package com.p2p.mapper;

import com.p2p.model.Onloan;

public interface OnloanMapper {
    int deleteByPrimaryKey(Integer oid);

    int insert(Onloan record);

    int insertSelective(Onloan record);

    Onloan selectByPrimaryKey(Integer oid);

    int updateByPrimaryKeySelective(Onloan record);

    int updateByPrimaryKey(Onloan record);
}