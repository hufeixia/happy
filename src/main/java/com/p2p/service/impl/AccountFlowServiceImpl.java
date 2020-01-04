package com.p2p.service.impl;

import com.p2p.mapper.AccountFlowMapper;
import com.p2p.model.AccountFlow;
import com.p2p.service.IAccountFlowService;
import com.p2p.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccountFlowServiceImpl implements IAccountFlowService {

    @Autowired
    private AccountFlowMapper accountFlowMapper;


    @Override
    public int insertSelective(AccountFlow record) {
        return accountFlowMapper.insertSelective(record);
    }

    @Override
    public AccountFlow selectByPrimaryKey(Integer flowId) {
        return accountFlowMapper.selectByPrimaryKey(flowId);
    }

    @Override
    public List<AccountFlow> listPage(PageBean pageBean, String userName, String flowType) {
        return accountFlowMapper.listPage(pageBean,userName,flowType);
    }

    @Override
    public List<AccountFlow> listAllPage(PageBean pageBean, String userName, String endDate, String startDate) {
        return accountFlowMapper.listAllPage(pageBean,userName,endDate,startDate);
    }




}
