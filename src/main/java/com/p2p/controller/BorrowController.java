package com.p2p.controller;

import com.github.pagehelper.Page;
import com.p2p.dto.DataDto;
import com.p2p.model.AccountFlow;
import com.p2p.model.Borrow;
import com.p2p.service.IAccountFlowService;
import com.p2p.service.IBorrowService;
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
@CrossOrigin
public class BorrowController {

    @Autowired
    private IBorrowService borrowService;

    @Autowired
    private IAccountFlowService iAccountFlowService;

    @RequestMapping(value = "/addBorrow")
    @ResponseBody
    public Map addBorrow(Borrow borrow){
        Map<String,Object> message = new HashMap<String,Object>();
        int i = borrowService.insertSelective(borrow);
        if(0!=i){
            message.put("code",1);
            message.put("addInfo","贷款成功");
        }else{
            message.put("addInfo","贷款失败");
        }
        return message;
    }

    @RequestMapping(value = "/QueryBorrow")
    @ResponseBody
    public List QueryBorrow(Borrow borrow){
        List<Borrow> borrows = borrowService.QueryListBorrow(borrow);
        return borrows;
    }


    @RequestMapping(value = "/listBorrowPage")
    @ResponseBody
    public Map listBorrowPage(Borrow borrow, DataDto dataDto,HttpServletRequest req){
        Map map =new HashMap();
        PageBean pageBean = new PageBean();
        pageBean.initPageBean(req,pageBean);
        List<Borrow> borrows = borrowService.listPage(borrow.getUserName(), dataDto.getStartDate(), dataDto.getEndDate(), pageBean);

        map.put("borrows", borrows);
        map.put("page", pageBean.getPage());
        map.put("total", pageBean.getTotal());
        map.put("rows", pageBean.getRows());

        return map;
    }


    @RequestMapping(value = "/listStatusPage")
    @ResponseBody
    public Map listStatusPage(Borrow borrow, DataDto dataDto,HttpServletRequest req){
        System.out.println("-----------------"+borrow.getBorrowStatus());
        Map map =new HashMap();
        PageBean pageBean = new PageBean();
        pageBean.initPageBean(req,pageBean);
        List<Borrow> borrows = borrowService.listStatusPage(borrow.getUserName(),dataDto.getStartDate(),dataDto.getEndDate(),pageBean);

        map.put("borrows", borrows);
        map.put("page", pageBean.getPage());
        map.put("total", pageBean.getTotal());
        map.put("rows", pageBean.getRows());

        return map;
    }


    @RequestMapping(value = "/updateStatus")
    @ResponseBody
    public Map updateStatus(Borrow borrow){
        System.out.println("--------------------------"+borrow);
        Map map =new HashMap();
        int i = borrowService.updateStatus(borrow);
        map.put("code",500);
        if(i>0){
            map.put("code",200);

            //成功的同时加一条系统流水
            AccountFlow accountFlow = new AccountFlow();
            accountFlow.setUserName(borrow.getUserName());
            accountFlow.setFlowMoney(borrow.getBorrowMoney());
            accountFlow.setFlowBorrow(borrow.getBorrowTitle());
            accountFlow.setFlowType("借款");
            int a = iAccountFlowService.insertSelective(accountFlow);
            System.out.println("================"+a);
        }

        return map;
    }







}
