package com.p2p.service.impl;

import com.p2p.mapper.DetailsMapper;
import com.p2p.model.Details;
import com.p2p.service.IDetailsService;
import com.p2p.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IDetailsServiceImpl implements IDetailsService {

    @Autowired
    private DetailsMapper detailsMapper;

    @Override
    public int delByPrimary(Details details) {
        return detailsMapper.delByPrimary(details);
    }

    @Override
    public int insertSelective(Details record) {
        return detailsMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Details record) {
        return detailsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Details> listPage(String dname, PageBean pageBean) {
        return detailsMapper.listPage(dname,pageBean);
    }


    @Override
    public List<Details> listAllPage(String detailsName, PageBean pageBean) {
        return detailsMapper.listAllPage(detailsName,pageBean);
    }


}
