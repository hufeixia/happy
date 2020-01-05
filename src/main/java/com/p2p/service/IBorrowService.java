package com.p2p.service;

import com.p2p.dto.DataDto;
import com.p2p.model.Borrow;
import com.p2p.util.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IBorrowService {
    int deleteByPrimaryKey(Integer borrowId);

    int insert(Borrow record);

    int insertSelective(Borrow record);

    Borrow selectByPrimaryKey(Integer borrowId);

    int updateByPrimaryKeySelective(Borrow record);

    int updateByPrimaryKey(Borrow record);

    List<Borrow> QueryListBorrow(Borrow record);

    //模查时间，姓名
    List<Borrow> listPage(String userName,String startDate , String endDate , PageBean pageBean);

    //查询状态为0的数据
    List<Borrow> listStatusPage(String userName,String startDate , String endDate , PageBean pageBean);

    //修改状态为1
    int updateStatus(Borrow borrow);





}