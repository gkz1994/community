package com.gkzcode.community.controller;

import com.gkzcode.community.mapper.QuestionMapper;
import com.gkzcode.community.mapper.UserMapper;
import com.gkzcode.community.model.Question;
import com.gkzcode.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName PublishController
 * @Description TODO
 * @Author gkz
 * @Date 2019/8/17 02:44
 * @Version 1.0
 **/
@Controller
public class PublishController {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam("title")String title,
            @RequestParam("description")String description,
            @RequestParam("tag")String tag,
            HttpServletRequest request,
            Model model){
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);
        if(title==null || title ==""){
            model.addAttribute("error","标题不能为空");
            return "publish";
        }

        if(description==null || description ==""){
            model.addAttribute("error","内容描述不能为空");
            return "publish";
        }

        if(tag==null || tag ==""){
            model.addAttribute("error","标签不能为空");
            return "publish";
        }


        User user = null;
        Cookie[]cookies =request.getCookies();
        for (Cookie cookie : cookies) {
            if("token".equals(cookie.getName())){
                String token=cookie.getValue();
                user=userMapper.findByToken(token);
                if(user!=null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }



        Question question=new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());

        if(user == null){
            model.addAttribute("error","用户未登录");
            return "publish";

        }

        questionMapper.create(question);
        return "redirect:/";
    }
}
