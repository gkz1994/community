package com.gkzcode.community.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
/**
 * @ClassName controller
 * @Description TODO
 * @Author gkz
 * @Date 2019/8/12 04:36
 * @Version 1.0
 **/
@Controller
public class HelloController {

    @GetMapping("/")
    public String hello(@RequestParam(name="name",required = false,defaultValue = "world")String name, Model model){
        model.addAttribute("name",name);
        return "index";
    }
}
