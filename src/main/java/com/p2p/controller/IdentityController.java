package com.p2p.controller;

import com.p2p.model.Identity;
import com.p2p.model.Images;
import com.p2p.service.IdentityService;
import com.p2p.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@CrossOrigin
public class IdentityController {

    @Autowired
    private IdentityService identityService;

    @Autowired
    private ImagesService imagesService;

    @RequestMapping(value = "/addIdentity")
    @ResponseBody
    public Map addIdentity(Identity identity, HttpServletRequest request) {
        Map<String, Object> message = new HashMap<String, Object>();
        Images img = new Images();
        Identity i = identityService.IdentityByPrimaryRealName(identity.getUname());
        if (i == null) {
            identity.setIid(request.getSession().getServletContext().getAttribute("iid").toString());
            img.setIdentityid(identity.getIid());
            img.setUname(identity.getUname());
            int i1 = imagesService.ImagesByPrimaryImgType(img);
            System.out.println("-----------------"+i1);
            int insert = identityService.insert(identity);
            if (0 != insert) {
                message.put("code", "0");
                message.put("addInfo", "认证成功");
            } else {
                message.put("addInfo", "认证失败");
            }
        } else {
            message.put("addInfo", "认证失败,该用户已进行实名认证");
        }


        return message;
    }


    @RequestMapping(value = "/queryIdentityByUname")
    @ResponseBody
    public Map queryIdentityByUname(Identity identity, String reg) {
        System.out.println("identity--------:" + identity.getUname());
        Map<String, Object> result = new HashMap<String, Object>();
        Identity i = identityService.IdentityByPrimaryRealName(identity.getUname());
        if (null != i) {
            if (reg.equals("grzl")) {
                String s = i.getCartid().replaceAll("(?<=[\\d]{5})\\d(?=[\\d]{3})", "*");
                i.setCartid(s);
                //姓名打码
                String realname = i.getRealname();
                String realname1 = null;
                char[] r = realname.toCharArray();
                if (r.length == 1) {
                    realname1 = realname;
                }
                if (r.length == 2) {
                    realname1 = realname.replaceFirst(realname.substring(1), "*");
                }
                if (r.length > 2) {
                    realname1 = realname.replaceFirst(realname.substring(1, r.length - 1), "*");
                }
                i.setRealname(realname1);
                result.put("identity", i);
            } else {
                result.put("identity", i);
            }
        }
        return result;
    }

}

