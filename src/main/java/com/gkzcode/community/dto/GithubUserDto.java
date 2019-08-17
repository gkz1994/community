package com.gkzcode.community.dto;

import lombok.Data;

/**
 * @ClassName GithubUserDto
 * @Description TODO
 * @Author gkz
 * @Date 2019/8/15 02:25
 * @Version 1.0
 **/
@Data
public class GithubUserDto {

    private String name;

    private Long id;

    private String bio;

    private String avatarUrl;
}
