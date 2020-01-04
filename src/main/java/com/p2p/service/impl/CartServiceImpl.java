package com.p2p.service.impl;

import com.p2p.model.Cart;
import com.p2p.service.ICartService;

public class CartServiceImpl implements ICartService {
    @Override
    public int deleteByPrimaryKey(Integer cid) {
        return 0;
    }

    @Override
    public int insert(Cart record) {
        return 0;
    }

    @Override
    public int insertSelective(Cart record) {
        return 0;
    }

    @Override
    public Cart selectByPrimaryKey(Integer cid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Cart record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Cart record) {
        return 0;
    }
}
