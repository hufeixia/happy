package com.p2p.mapper;

import com.p2p.model.LoginHistory;
import com.p2p.util.PageBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginHistoryMapper {

    //增加
    int insertSelective(LoginHistory record);

    //模查
    List<LoginHistory> listPage(@Param("uName") String uName, @Param("startDate") String startDate, @Param("endDate") String endDate, PageBean pageBean);






}