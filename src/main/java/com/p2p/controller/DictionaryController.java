package com.p2p.controller;

import com.p2p.model.Dictionary;
import com.p2p.service.IDictionaryService;
import com.p2p.util.PageBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping(value = "/Dictionary")
public class DictionaryController {

    @Autowired
    private IDictionaryService iDictionaryService;

    @RequestMapping(value = "/listDictionary")//查询数据字典
    @CrossOrigin
    public List<Dictionary> listDictionary(Dictionary dictionary) {
        List<Dictionary> dictionaries = iDictionaryService.listAll(dictionary);
        System.out.println(dictionaries);

        return dictionaries;
    }

    @RequestMapping(value = "/listPage")//查询数据字典
    @CrossOrigin
    public Map listPage(@Param("dname")Dictionary dictionary, HttpServletRequest req) {
//        System.out.println("hhhhhhhhhhhhhhhhhh"+req);
//        System.out.println("---------------------------------"+dictionary.getDname());
        PageBean pageBean = new PageBean();
        pageBean.initPageBean(req, pageBean);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Dictionary> dictionaries = iDictionaryService.listAllPage(dictionary.getDname(),pageBean);
        map.put("dictionaries", dictionaries);
        map.put("page", pageBean.getPage());
        map.put("total", pageBean.getTotal());
        map.put("rows", pageBean.getRows());
        return map;
    }


    @RequestMapping(value = "/addDictionary")//新增
    @CrossOrigin
    public Map addDictionary(Dictionary dictionary) {
        int i = 0;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", "数据字典名称重复，请重新输入");
        map.put("code", "500");
        try {
            i = iDictionaryService.insertSelective(dictionary);
            System.out.println(i);
            if (i > 0) {
                map.put("message", "增加成功");
                map.put("code", "200");
            }
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
        }


        return map;
    }


    @RequestMapping(value = "/delDictionary")//删除
    @CrossOrigin
    public Map delDictionary(Dictionary dictionary) {
        System.out.println("------------------------------" + dictionary.getDid());
        int i = iDictionaryService.deleByPrimary(dictionary);
        System.out.println(i);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", "删除失败");
        map.put("code", 500);
        if (i > 0) {
            map.put("message", "删除成功");
            map.put("code", 200);
        }

        return map;
    }


    @RequestMapping(value = "/upDictionary")//修改
    @CrossOrigin
    public Map upDictionary(Dictionary dictionary) {
        int i = 0;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", "修改失败,数据字典名称重复");
        map.put("code", 500);
        try {
            i = iDictionaryService.updateByPrimaryKeySelective(dictionary);
            if (i > 0) {
                map.put("message", "修改成功");
                map.put("code", 200);
            }
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
        }

        return map;
    }


}
