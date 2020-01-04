package com.p2p.service;

import com.p2p.model.AccountFlow;
import com.p2p.util.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IAccountFlowService {


    int insertSelective(AccountFlow record);

    AccountFlow selectByPrimaryKey(Integer flowId);

    List<AccountFlow> listPage(PageBean pageBean, String userName, String flowType);

    List<AccountFlow> listAllPage(PageBean pageBean, String userName, String endDate, String startDate);



  
}