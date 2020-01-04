package com.p2p.service;

import com.p2p.model.Base;

public interface IBaseService {
    int deleteByPrimaryKey(Integer bid);

    int insert(Base record);

    int insertSelective(Base record);

    Base selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Base record);

    int updateByPrimaryKey(Base record);
}