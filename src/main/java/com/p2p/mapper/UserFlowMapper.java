package com.p2p.mapper;

import com.p2p.model.UserFlow;
import com.p2p.util.PageBean;
import lombok.ToString;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFlowMapper {
    //增加
    int insertSelective(UserFlow record);

    //查询
    List<UserFlow> queryPage(@Param("userName")String userName, @Param("startDate")String startDate, @Param("endDate")String endDate, PageBean pageBean);

    //修改
    int updateStatus(UserFlow userFlow);

    //查询审核
    List<UserFlow> queryStatus(@Param("userName")String userName,@Param("flowType")String flowType,@Param("flowStatus")String flowStatus, @Param("startDate")String startDate, @Param("endDate")String endDate, PageBean pageBean);



}