package com.p2p.service;

import com.p2p.model.LoginHistory;
import com.p2p.util.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ILoginHistoryService {


    int insertSelective(LoginHistory record);


    //模查
    List<LoginHistory> listPage(String uName, String startDate, String endDate, PageBean pageBean);



}