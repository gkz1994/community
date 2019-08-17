package com.gkzcode.community.controller;

import com.gkzcode.community.mapper.UserMapper;
import com.gkzcode.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName controller
 * @Description TODO
 * @Author gkz
 * @Date 2019/8/12 04:36
 * @Version 1.0
 **/
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request){
        Cookie[]cookies =request.getCookies();
        if(cookies!=null && cookies.length != 0){
        for (Cookie cookie : cookies) {
            if("token".equals(cookie.getName())){
                String token=cookie.getValue();
                User user=userMapper.findByToken(token);
                if(user!=null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        }
        return "index";
    }
}
