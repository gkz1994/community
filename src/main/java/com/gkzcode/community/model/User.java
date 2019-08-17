package com.gkzcode.community.model;

import lombok.Data;

/**
 * @ClassName User
 * @Description TODO
 * @Author gkz
 * @Date 2019/8/16 03:03
 * @Version 1.0
 **/
@Data
public class User {

    private Integer id;

    private String accountId;

    private String name;

    private String token;

    private Long gmtCreate;

    private Long gmtModified;

    private String avatarUrl;


}
