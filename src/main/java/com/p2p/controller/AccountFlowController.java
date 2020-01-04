package com.p2p.controller;

import com.p2p.model.AccountFlow;
import com.p2p.model.LoginHistory;
import com.p2p.service.IAccountFlowService;
import com.p2p.service.ILoginHistoryService;
import com.p2p.util.PageBean;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/AccountFlow")
public class AccountFlowController {

    @Autowired
    private IAccountFlowService iAccountFlowService;



    @RequestMapping(value = "/listPage")//查询登陆记录
    @CrossOrigin
    public Map listPage(AccountFlow accountFlow, HttpServletRequest req){
        System.out.println("--------------------"+accountFlow.getUserName());

        Map<String, Object> map = new HashMap<String, Object>();
        PageBean pageBean = new PageBean();
        pageBean.initPageBean(req,pageBean);
//        loginHistory.setuName("得到");
//        List<AccountFlow> accountFlows = iAccountFlowService.listPage(pageBean, accountFlow.getUserName(), accountFlow.getFlowType());

        List<AccountFlow> accountFlows = iAccountFlowService.listAllPage(pageBean, accountFlow.getUserName(), accountFlow.getEndDate(), accountFlow.getStartDate());
        map.put("accountFlows", accountFlows);
        map.put("page", pageBean.getPage());
        map.put("total", pageBean.getTotal());
        map.put("rows", pageBean.getRows());


        return map;
    }
















}
