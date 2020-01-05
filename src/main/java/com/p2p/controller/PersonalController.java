package com.p2p.controller;

import com.p2p.model.Personal;
import com.p2p.service.IPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/Personal")
public class PersonalController {

    @Autowired
    private IPersonalService personalService;

    @RequestMapping(value = "/personalByName")
    @ResponseBody
    @CrossOrigin
    public Personal personalByName(@RequestParam String uname) {
        Personal p = personalService.PersonalByPrimaryName(uname);
        return p;
    }

    @RequestMapping(value = "/addPersonal")
    @ResponseBody
    @CrossOrigin
    public Map addPersonal(Personal personal) {
        Map<String, Object> message = new HashMap<String, Object>();
        Personal personal1 = personalService.PersonalByPrimaryName(personal.getUname());//得到用户信息
        if(null!=personal1){
            int per = personalService.updateByPrimaryKey(personal);
            if (0 != per) {
                message.put("code", 0);
                message.put("addInfo", "资料完善成功");
            } else {
                message.put("addInfo", "资料完善失败，请核对后重试");
            }
        }else{
            int insert = personalService.insert(personal);
            if (0 != insert) {
                message.put("code", 0);
                message.put("addInfo", "资料完善成功");
            } else {
                message.put("addInfo", "资料完善失败，请核对后重试");
            }
        }
        return message;
    }
}
