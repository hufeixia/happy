package com.p2p.mapper;

import com.p2p.model.Borrow;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowMapper {
    int deleteByPrimaryKey(Integer borrowId);

    int insert(Borrow record);

    int insertSelective(Borrow record);

    Borrow selectByPrimaryKey(Integer borrowId);

    int updateByPrimaryKeySelective(Borrow record);

    int updateByPrimaryKey(Borrow record);

    List<Borrow> QueryListBorrow(Borrow record);
}