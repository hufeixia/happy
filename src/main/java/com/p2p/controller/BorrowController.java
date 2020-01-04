package com.p2p.controller;

import com.p2p.model.Borrow;
import com.p2p.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class BorrowController {

    @Autowired
    private IBorrowService borrowService;

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

}
