package com.p2p.mapper;

import com.p2p.model.Base;

public interface BaseMapper {
    int deleteByPrimaryKey(Integer bid);

    int insert(Base record);

    int insertSelective(Base record);

    Base selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Base record);

    int updateByPrimaryKey(Base record);
}