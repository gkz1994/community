package com.gkzcode.community.model;

import lombok.Data;

/**
 * @ClassName Question
 * @Description TODO
 * @Author gkz
 * @Date 2019/8/17 17:31
 * @Version 1.0
 **/
@Data
public class Question {

    private Integer id;

    private String title;

    private String description;

    private String tag;

    private Long gmtCreate;

    private long gmtModified;

    private Integer creator;

    private Integer viewCount;

    private Integer commentCount;

    private Integer likeCount;

}
