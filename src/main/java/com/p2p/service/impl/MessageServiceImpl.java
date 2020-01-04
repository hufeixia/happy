package com.p2p.service.impl;

import com.p2p.model.Message;
import com.p2p.service.IMessageService;

public class MessageServiceImpl implements IMessageService {
    @Override
    public int deleteByPrimaryKey(Integer mid) {
        return 0;
    }

    @Override
    public int insert(Message record) {
        return 0;
    }

    @Override
    public int insertSelective(Message record) {
        return 0;
    }

    @Override
    public Message selectByPrimaryKey(Integer mid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Message record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Message record) {
        return 0;
    }
}
