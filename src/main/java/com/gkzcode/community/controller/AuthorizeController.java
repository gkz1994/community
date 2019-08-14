package com.gkzcode.community.controller;

import com.gkzcode.community.dto.AccessTokenDto;
import com.gkzcode.community.dto.GithubUserDto;
import com.gkzcode.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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

    @Value("${github.client.id}")
    private String clientid;

    @Value("${github.redirect.uri}")
    private String redirecturi;

    @Value("${github.client.secret}")
    private String clientsecret;

    @GetMapping("/callback")
    public String getUser(@RequestParam(name="state")String state, @RequestParam(name="code")String code, HttpServletRequest request){
        AccessTokenDto accessToken=new AccessTokenDto();
        accessToken.setState(state);
        accessToken.setCode(code);
        accessToken.setClient_id(clientid);
        accessToken.setRedirect_uri(redirecturi);
        accessToken.setClient_secret(clientsecret);
        String token=githubProvider.getToken(accessToken);
        GithubUserDto user=githubProvider.getUser(token);
        System.out.println(user);
        return "index";
    }


}
