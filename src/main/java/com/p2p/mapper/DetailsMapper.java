package com.p2p.mapper;

import com.p2p.model.Details;
import com.p2p.util.PageBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailsMapper {

    //删除
    int delByPrimary(Details details);

    //增加
    int insertSelective(Details record);

    //修改
    int updateByPrimaryKeySelective(Details record);

    //查询（模糊查询）
    List<Details> listPage(@Param("dname") String dname, PageBean pageBean);

    List<Details> QueryType();

    List<Details> listAllPage(@Param("detailsName") String detailsName, PageBean pageBean);



}