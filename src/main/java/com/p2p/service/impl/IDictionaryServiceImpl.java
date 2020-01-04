package com.p2p.service.impl;

import com.p2p.mapper.DictionaryMapper;
import com.p2p.model.Dictionary;
import com.p2p.service.IDictionaryService;
import com.p2p.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class IDictionaryServiceImpl implements IDictionaryService {

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Override
    public int deleByPrimary(Dictionary dictionary) {
        return dictionaryMapper.deleByPrimary(dictionary);
    }

    @Override
    public int insertSelective(Dictionary record) {
        return dictionaryMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Dictionary record) {
        return dictionaryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Dictionary> listAll(Dictionary record) {
        return dictionaryMapper.listAll(record);
    }

    @Override
    public List<Dictionary> listAllPage(String dname, PageBean pageBean) {
        return dictionaryMapper.listAllPage(dname,pageBean);
    }


}
