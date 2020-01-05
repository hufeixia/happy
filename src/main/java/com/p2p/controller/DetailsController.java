package com.p2p.controller;

import com.p2p.model.Details;
import com.p2p.service.IDetailsService;
import com.p2p.util.PageBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping(value = "/Details")
public class DetailsController {

    @Autowired
    private IDetailsService iDetailsService;

    @RequestMapping(value = "/listDetails")//查询数据字典
    @CrossOrigin
    public Map listDetails(Details details,HttpServletRequest req){
        Map<String, Object> map = new HashMap<String, Object>();
        PageBean pageBean = new PageBean();
        pageBean.initPageBean(req,pageBean);
        System.out.println("---------------------------"+details.getDname());
        List<Details> detailsList = iDetailsService.listPage(details.getDname(),pageBean);
        System.out.println(detailsList);
        map.put("detailsList", detailsList);
        map.put("page", pageBean.getPage());
        map.put("total", detailsList.size());
        map.put("rows", pageBean.getRows());
        System.out.println("----------------"+pageBean.getTotal()+pageBean.getPage());

        return  map;
    }


    @RequestMapping(value = "/listPage")//查询数据字典
    @CrossOrigin
    public Map listPage(Details details,HttpServletRequest req){
        Map<String, Object> map = new HashMap<String, Object>();
        PageBean pageBean = new PageBean();
        pageBean.initPageBean(req,pageBean);
        List<Details> details1 = iDetailsService.listAllPage(details.getDetailsName(),pageBean);
        map.put("dictionaries", details1);
        map.put("page", pageBean.getPage());
        map.put("total", pageBean.getTotal());
        map.put("rows", pageBean.getRows());


        return map;
    }

    @RequestMapping(value = "/addDetails")//新增
    @CrossOrigin
    public Map addDetails(Details details){
        int i=0;
        try {
            i = iDetailsService.insertSelective(details);
        }catch (DuplicateKeyException e){
            e.printStackTrace();
        }
        System.out.println(i);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("message","增加失败,名称已存在,请重新输入");
        map.put("code","500");
        if(i>0){
            map.put("message","增加成功");
            map.put("code","200");
        }

        return  map;
    }


    @RequestMapping(value = "/delDetails")//删除
    @CrossOrigin
    public Map delDetails(Details details){
        System.out.println("------------------------------------------"+details.getDetailsId());
        int i = iDetailsService.delByPrimary(details);
        System.out.println(i);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("message","删除失败");
        map.put("code",500);
        if(i>0){
            map.put("message","删除成功");
            map.put("code",200);
        }

        return  map;
    }


    @RequestMapping(value = "/upDetails")//修改
    @CrossOrigin
    public Map upDetails(Details details){
        int i = 0;
        try {
            i = iDetailsService.updateByPrimaryKeySelective(details);
        }catch(DuplicateKeyException e){
            e.printStackTrace();
        }
        System.out.println(i);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("message","修改失败,名称已存在,请重新输入");
        map.put("code",500);
        if(i>0){
            map.put("message","修改成功");
            map.put("code",200);
        }

        return  map;
    }



    @RequestMapping(value = "/Querytpes")//查询数据字典
    @CrossOrigin
    public List Querytpes(){
        List<Details> details1 = iDetailsService.QueryType();
        return details1;
    }








}
