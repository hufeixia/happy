package com.p2p.service;

import com.p2p.model.Details;
import com.p2p.util.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IDetailsService {

    //删除
    int delByPrimary(Details details);

    //增加
    int insertSelective(Details record);

    //修改
    int updateByPrimaryKeySelective(Details record);

    //查询（模糊查询）
    List<Details> listPage(String dname, PageBean pageBean);

    List<Details> listAllPage(String detailsName, PageBean pageBean);




}