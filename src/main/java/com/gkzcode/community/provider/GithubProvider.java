package com.gkzcode.community.provider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gkzcode.community.dto.AccessTokenDto;
import com.gkzcode.community.dto.GithubUserDto;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @ClassName GithubProvider
 * @Description TODO
 * @Author gkz
 * @Date 2019/8/15 01:48
 * @Version 1.0
 **/
@Component
public class GithubProvider {

    public String getToken(AccessTokenDto accessTokenDto){

        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSONObject.toJSONString(accessTokenDto));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String str=response.body().string();
            return str.split("=")[1].split("&")[0];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public GithubUserDto getUser(String token){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.github.com/user?token="+token)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String string=response.body().string();
            GithubUserDto user=JSONObject.parseObject(string,GithubUserDto.class);
            return user;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}




