package com.p2p.service;

import com.p2p.model.Borrow;

import java.util.List;

public interface IBorrowService {
    int deleteByPrimaryKey(Integer borrowId);

    int insert(Borrow record);

    int insertSelective(Borrow record);

    Borrow selectByPrimaryKey(Integer borrowId);

    int updateByPrimaryKeySelective(Borrow record);

    int updateByPrimaryKey(Borrow record);

    List<Borrow> QueryListBorrow(Borrow record);
}