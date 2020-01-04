package com.p2p.mapper;

import com.p2p.model.Repayment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepaymentMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Repayment record);

    int insertSelective(Repayment record);

    Repayment selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Repayment record);

    int updateByPrimaryKey(Repayment record);

    Repayment RepaymentQuerySing(Repayment record);

    int UpdateRepayment(Repayment record);

    int QueryMaxKey();
}