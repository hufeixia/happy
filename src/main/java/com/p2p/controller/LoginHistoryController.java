package com.p2p.controller;

import com.p2p.model.Details;
import com.p2p.model.LoginHistory;
import com.p2p.service.IDetailsService;
import com.p2p.service.ILoginHistoryService;
import com.p2p.util.PageBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping(value = "/LoginHistory")
public class LoginHistoryController {

    @Autowired
    private ILoginHistoryService iLoginHistoryService;



    @RequestMapping(value = "/listPage")//查询登陆记录
    @CrossOrigin
    public Map listPage(LoginHistory loginHistory, HttpServletRequest req){
        System.out.println("-----------------------"+loginHistory);

        Map<String, Object> map = new HashMap<String, Object>();
        PageBean pageBean = new PageBean();
        pageBean.initPageBean(req,pageBean);
//        loginHistory.setuName("得到");
        List<LoginHistory> loginHistories = iLoginHistoryService.listPage(loginHistory.getuName(), loginHistory.getStartDate(), loginHistory.getEndDate(), pageBean);

        map.put("loginHistories", loginHistories);
        map.put("page", pageBean.getPage());
        map.put("total", pageBean.getTotal());
        map.put("rows", pageBean.getRows());


        return map;
    }




    @RequestMapping(value = "/addHistory")//新增
    @CrossOrigin
    public void addHistory(LoginHistory loginHistory){
        int i = iLoginHistoryService.insertSelective(loginHistory);


    }














}
