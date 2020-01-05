package com.p2p.service.impl;

import com.p2p.dto.DataDto;
import com.p2p.mapper.BorrowMapper;
import com.p2p.model.Borrow;
import com.p2p.service.IBorrowService;
import com.p2p.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImp implements IBorrowService {

    @Autowired
    private BorrowMapper borrowMapper;

    @Override
    public int deleteByPrimaryKey(Integer borrowId) {

        return borrowMapper.deleteByPrimaryKey(borrowId);
    }

    @Override
    public int insert(Borrow record) {

        return borrowMapper.insert(record);
    }

    @Override
    public int insertSelective(Borrow record) {

        return borrowMapper.insertSelective(record);
    }

    @Override
    public Borrow selectByPrimaryKey(Integer borrowId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Borrow record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Borrow record) {
        return 0;
    }

    @Override
    public List<Borrow> QueryListBorrow(Borrow record) {
        return borrowMapper.QueryListBorrow(record);
    }

    @Override
    public List<Borrow> listPage(String userName, String startDate, String endDate, PageBean pageBean) {
        return borrowMapper.listPage(userName, startDate, endDate, pageBean);
    }

    @Override
    public List<Borrow> listStatusPage(String userName, String startDate, String endDate, PageBean pageBean) {
        return borrowMapper.listStatusPage(userName, startDate, endDate, pageBean);
    }

    @Override
    public int updateStatus(Borrow borrow) {
        return borrowMapper.updateStatus(borrow);
    }


}
