package com.p2p.service;

import com.p2p.model.UserFlow;
import com.p2p.util.PageBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IUserFlowService {
    //增加
    int insertSelective(UserFlow record);

    //查询
    List<UserFlow> queryPage( String userName,String startDate,String endDate, PageBean pageBean);

    //修改
    int updateStatus(UserFlow userFlow);

    //查询审核
    List<UserFlow> queryStatus(String userName,String flowType,String flowStatus,String startDate,String endDate, PageBean pageBean);



}