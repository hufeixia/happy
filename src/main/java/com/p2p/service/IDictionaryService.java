package com.p2p.service;

import com.p2p.model.Dictionary;
import com.p2p.util.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IDictionaryService {
    //删除
    int deleByPrimary(Dictionary dictionary);

    //增加
    int insertSelective(Dictionary record);


    //修改
    int updateByPrimaryKeySelective(Dictionary record);


    //查询（模糊查询）
    List<Dictionary> listAll(Dictionary record);


    List<Dictionary> listAllPage(String dname, PageBean pageBean);





}