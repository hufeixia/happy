package com.p2p.service.impl;

import com.p2p.model.Base;
import com.p2p.service.IBaseService;

public class BaseServiceImpl implements IBaseService {
    @Override
    public int deleteByPrimaryKey(Integer bid) {
        return 0;
    }

    @Override
    public int insert(Base record) {
        return 0;
    }

    @Override
    public int insertSelective(Base record) {
        return 0;
    }

    @Override
    public Base selectByPrimaryKey(Integer bid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Base record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Base record) {
        return 0;
    }
}
