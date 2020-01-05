package com.p2p.mapper;

import com.p2p.model.Repayment;
import com.p2p.util.PageBean;
import org.apache.ibatis.annotations.Param;
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

    List<Repayment> RepaymentQuerySing(Repayment record);

    int UpdateRepayment(Repayment record);

    int QueryMaxKey();

    List<Repayment> QueryPage(@Param("uname") String uname,@Param("rdate") String rdate,@Param("endRdate") String endRdate,PageBean pageBean);




}