package com.gkzcode.community.dto;

import lombok.Data;

/**
 * @ClassName AccessTokenDto
 * @Description TODO
 * @Author gkz
 * @Date 2019/8/15 02:07
 * @Version 1.0
 **/
@Data
public class AccessTokenDto {

    private String client_id;

    private String client_secret;

    private String code;

    private String redirect_uri;

    private String state;

}
