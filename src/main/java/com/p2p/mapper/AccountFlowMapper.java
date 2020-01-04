package com.p2p.mapper;

import com.p2p.model.AccountFlow;
import com.p2p.util.PageBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AccountFlowMapper {

    int insertSelective(AccountFlow record);

    AccountFlow selectByPrimaryKey(Integer flowId);

    List<AccountFlow> listPage(PageBean pageBean, @Param("userName") String userName, @Param("flowType") String flowType);

    //时间
    List<AccountFlow> listAllPage(PageBean pageBean, @Param("userName") String userName, @Param("endDate") String endDate, @Param("startDate") String startDate);



}