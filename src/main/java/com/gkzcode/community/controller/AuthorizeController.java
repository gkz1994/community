package com.gkzcode.community.controller;

import com.gkzcode.community.mapper.UserMapper;
import com.gkzcode.community.dto.AccessTokenDto;
import com.gkzcode.community.dto.GithubUserDto;
import com.gkzcode.community.model.User;
import com.gkzcode.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @ClassName OauthorizeController
 * @Description TODO
 * @Author gkz
 * @Date 2019/8/15 01:26
 * @Version 1.0
 **/
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Autowired
    private UserMapper userMapper;

    @Value("${github.client.id}")
    private String clientid;

    @Value("${github.redirect.uri}")
    private String redirecturi;

    @Value("${github.client.secret}")
    private String clientsecret;

    @GetMapping("/callback")
    public String getUser(@RequestParam(name="state")String state,
                          @RequestParam(name="code")String code,
                          HttpServletRequest request,
                          HttpServletResponse response){
        AccessTokenDto accessToken=new AccessTokenDto();
        accessToken.setState(state);
        accessToken.setCode(code);
        accessToken.setClient_id(clientid);
        accessToken.setRedirect_uri(redirecturi);
        accessToken.setClient_secret(clientsecret);
        String token=githubProvider.getToken(accessToken);
        GithubUserDto githubUserDto=githubProvider.getUser(token);
        if(githubUserDto!=null){
            User user=new User();
            user.setName(githubUserDto.getName());
            String userToken=UUID.randomUUID().toString();
            user.setToken(userToken);
            user.setAccountId(String.valueOf(githubUserDto.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            user.setAvatarUrl(githubUserDto.getAvatarUrl());
            userMapper.insert(user);
            response.addCookie(new Cookie("token",userToken));
            request.getSession().setAttribute("user",githubUserDto);
            return "redirect:/";
        }else{
            return "redirect:/";
        }
    }
}
