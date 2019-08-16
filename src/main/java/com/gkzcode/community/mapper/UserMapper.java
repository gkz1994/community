package com.gkzcode.community.mapper;

import com.gkzcode.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    @Insert("insert into user(ACCOUNT_ID,name,token,GMT_CREATE,GMT_MODIFIED)values(${accountId,name,token,gmtCreate,gmtModified})")
    void insert(User user);
}
