package com.p2p.service.impl;

import com.p2p.mapper.UserFlowMapper;
import com.p2p.model.UserFlow;
import com.p2p.service.IUserFlowService;
import com.p2p.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFlowServiceImpl implements IUserFlowService {

    @Autowired
    private UserFlowMapper userFlowMapper;

    @Override
    public int insertSelective(UserFlow record) {
        return userFlowMapper.insertSelective(record);
    }

    @Override
    public List<UserFlow> queryPage(String userName, String startDate, String endDate, PageBean pageBean) {
        return userFlowMapper.queryPage(userName, startDate, endDate, pageBean);
    }

    @Override
    public int updateStatus(UserFlow userFlow) {
        return userFlowMapper.updateStatus(userFlow);
    }

    @Override
    public List<UserFlow> queryStatus(String userName, String flowType,String flowStatus ,String startDate, String endDate, PageBean pageBean) {
        return userFlowMapper.queryStatus(userName, flowType,flowStatus, startDate, endDate, pageBean);
    }


}
