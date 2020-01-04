package com.p2p.service.impl;

import com.p2p.mapper.LoginHistoryMapper;
import com.p2p.model.LoginHistory;
import com.p2p.service.ILoginHistoryService;
import com.p2p.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoginHistoryServiceImpl implements ILoginHistoryService {

    @Autowired
    private LoginHistoryMapper loginHistoryMapper;


    @Override
    public int insertSelective(LoginHistory record) {
        return loginHistoryMapper.insertSelective(record);
    }

    @Override
    public List<LoginHistory> listPage(String uName, String startDate, String endDate, PageBean pageBean) {
        return loginHistoryMapper.listPage(uName, startDate, endDate, pageBean);
    }

}
