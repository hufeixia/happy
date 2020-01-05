package com.p2p.controller;

import com.p2p.dto.DataDto;
import com.p2p.model.Account;
import com.p2p.model.AccountFlow;
import com.p2p.model.UserFlow;
import com.p2p.service.IAccountFlowService;
import com.p2p.service.IAccountService;
import com.p2p.service.IUserFlowService;
import com.p2p.util.PageBean;
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
@RequestMapping(value = "/UserFlow")
public class UserFlowController {

    @Autowired
    private IUserFlowService iUserFlowService;
    @Autowired
    private IAccountService accountService;



    @RequestMapping(value = "/listPage")//查询用户流水记录
    @CrossOrigin
    public Map listPage(UserFlow userFlow, DataDto dataDto, HttpServletRequest req){
        Map<String, Object> map = new HashMap<String, Object>();
        PageBean pageBean = new PageBean();
        pageBean.initPageBean(req,pageBean);
        List<UserFlow> userFlows = iUserFlowService.queryPage(userFlow.getUserName(), dataDto.getStartDate(), dataDto.getEndDate(), pageBean);
        map.put("userFlows", userFlows);
        map.put("page", pageBean.getPage());
        map.put("total", userFlows.size());
        map.put("rows", pageBean.getRows());


        return map;
    }



    //修改状态
    @RequestMapping(value = "/updateStatus")//修改状态
    @CrossOrigin
    public Map updateStatus(UserFlow userFlow){
        System.out.println("=========================="+userFlow);
        Map map =new HashMap();
        Account account = new Account();
        int i = iUserFlowService.updateStatus(userFlow);
        map.put("code",500);
        if(i>0){
            map.put("code",200);
        }
        Account account1=null;
        if(userFlow.getUserName() != null){
            account.setUname(userFlow.getUserName());
            account1= accountService.QueryAccount(account);
            System.out.println("根据名字查信息"+account1);
        }

        if(account1 != null){
            if(userFlow.getFlowType().equals("充值")){//往账号加钱
               int amount = account1.getAmount()+userFlow.getFlowMoney();
               int avail=account1.getAvail()+userFlow.getFlowMoney();
                System.out.println("money======"+amount);
                account.setAmount(amount);
                account.setAvail(avail);
                account.setWait(account1.getWait());
                int a = accountService.updateByPrimaryKey(account);

            }
            if(userFlow.getFlowType().equals("提现")){//往账号减钱
                int amount = account1.getAmount()-userFlow.getFlowMoney();
                int avail=account1.getAvail()-userFlow.getFlowMoney();
                System.out.println("money======"+amount);
                account.setAmount(amount);
                account.setAvail(avail);
                account.setWait(account1.getWait());
                int a = accountService.updateByPrimaryKey(account);

            }

        }

        return map;
    }


    @RequestMapping(value = "/listType")//
    @CrossOrigin
    public Map listType(UserFlow userFlow, DataDto dataDto, HttpServletRequest req){
//        System.out.println("--------------------"+userFlow.getUserName());
        Map<String, Object> map = new HashMap<String, Object>();
        PageBean pageBean = new PageBean();
        pageBean.initPageBean(req,pageBean);
        List<UserFlow> userFlows = iUserFlowService.queryStatus(userFlow.getUserName(),userFlow.getFlowType(),userFlow.getFlowStatus(),dataDto.getStartDate(),dataDto.getEndDate(),pageBean);

        map.put("userFlows", userFlows);
        map.put("page", pageBean.getPage());
        map.put("total", userFlows.size());
        map.put("rows", pageBean.getRows());


        return map;
    }















}
