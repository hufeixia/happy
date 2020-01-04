package com.p2p.service;

import com.p2p.model.Repayment;
import org.springframework.stereotype.Repository;

public interface IRepaymentService {
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