package com.p2p.controller;

import com.p2p.model.Account;
import com.p2p.model.Repayment;
import com.p2p.service.IAccountService;
import com.p2p.service.IRepaymentService;
import com.p2p.util.PageBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RepaymentController {

    @Autowired
    private IRepaymentService repaymentService;

    @Autowired
    private IAccountService accountService;

    @RequestMapping(value = "/addRepayment")
    @ResponseBody
    @CrossOrigin
    public Map addRepayment(Repayment repayment) {
        System.out.println("repayment==="+repayment);
        Map<String, Object> message = new HashMap<String, Object>();
        int insert = repaymentService.insert(repayment);
        if (0 != insert) {
            message.put("code", 1);
            message.put("addInfo", "还款成功");
            System.out.println(repayment);
            Account account = new Account();
            account.setUname(repayment.getUname());//用户名
            Account acc = accountService.QueryAccount(account);
            System.out.println(acc);
            if(null!=acc){
                account.setAmount(acc.getAvail()-repayment.getRepaymentmoney());//总金额=总金额-可用金额
                account.setAvail(acc.getAvail()-repayment.getRepaymentmoney());
                account.setWait(acc.getWait()-repayment.getRepaymentmoney());
                int i = accountService.updateByPrimaryKey(account);
                if(0!=i){
                    int primaryKey = repaymentService.QueryMaxKey();
//                    if(0!=primaryKey){
//                        repayment.setRid(primaryKey);
//                        System.out.println("repayment==="+repayment);
////                        repayment.setRemain();
//                        int updateRepayment = repaymentService.UpdateRepayment(repayment);
//                        System.out.println("primaryKey=========="+primaryKey);
//                    }

                }

            }
        } else {
            message.put("addInfo", "还款失败，请检查余额后重试");
        }

        return message;
    }


    @RequestMapping(value = "/QuerySingRepayment")
    @ResponseBody
    @CrossOrigin
    public List QuerySingRepayment(Repayment repayment) {
        System.out.println(repayment);
        List<Repayment> repayments = repaymentService.RepaymentQuerySing(repayment);
        return repayments;
    }

    @RequestMapping(value = "/RepaymentPage")
    @ResponseBody
    @CrossOrigin
    public Map RepaymentPage(Repayment repayment,HttpServletRequest request) {
        String endRdate = request.getParameter("endRdate");
        repayment.setEndRdate(endRdate);
        Map<String,Object> json = new HashMap<String,Object>();
        PageBean pageBean = new PageBean();
        pageBean.initPageBean(request,pageBean);
        List<Repayment> repayments = repaymentService.QueryPage(repayment.getUname(),repayment.getRdate(),repayment.getEndRdate(), pageBean);
        json.put("repayments",repayments);
        json.put("pageBean",pageBean);
        return json;
    }




}
