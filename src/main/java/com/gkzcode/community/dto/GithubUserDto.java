package com.gkzcode.community.dto;

/**
 * @ClassName GithubUserDto
 * @Description TODO
 * @Author gkz
 * @Date 2019/8/15 02:25
 * @Version 1.0
 **/
public class GithubUserDto {

    private String name;

    private Long id;

    private String bio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
