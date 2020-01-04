package com.p2p.controller;

import com.p2p.model.Account;
import com.p2p.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping(value = "/QueryAccount")
    @ResponseBody
    public Account QueryAccount(Account account){
        Account a = accountService.QueryAccount(account);
        return a;
    }

}
