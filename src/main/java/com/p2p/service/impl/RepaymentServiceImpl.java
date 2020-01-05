package com.p2p.service.impl;

import com.p2p.mapper.RepaymentMapper;
import com.p2p.model.Repayment;
import com.p2p.service.IRepaymentService;
import com.p2p.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepaymentServiceImpl implements IRepaymentService {

    @Autowired
    private RepaymentMapper repaymentMapper;

    @Override
    public int deleteByPrimaryKey(Integer rid) {
        return 0;
    }

    @Override
    public int insert(Repayment record) {

        return repaymentMapper.insert(record);
    }

    @Override
    public int insertSelective(Repayment record) {
        return repaymentMapper.insertSelective(record);
    }

    @Override
    public Repayment selectByPrimaryKey(Integer rid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Repayment record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Repayment record) {
        return 0;
    }

    @Override
    public List<Repayment> RepaymentQuerySing(Repayment record) {

        return repaymentMapper.RepaymentQuerySing(record);
    }

    @Override
    public int UpdateRepayment(Repayment record) {

        return repaymentMapper.UpdateRepayment(record);
    }

    @Override
    public int QueryMaxKey() {
        return repaymentMapper.QueryMaxKey();
    }

    @Override
    public List<Repayment> QueryPage(String uname, String rdate, String endRdate,PageBean pageBean) {
        return repaymentMapper.QueryPage(uname,rdate,endRdate,pageBean);
    }
}
