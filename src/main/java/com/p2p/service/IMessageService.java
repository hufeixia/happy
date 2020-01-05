package com.p2p.service;

import com.p2p.model.Images;
import com.p2p.model.Message;
import com.p2p.util.PageBean;

import java.util.List;

public interface IMessageService {
    int deleteByPrimaryKey(Integer mid);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}