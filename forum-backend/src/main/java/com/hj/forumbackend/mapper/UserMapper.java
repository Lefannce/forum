package com.hj.forumbackend.mapper;

import com.hj.forumbackend.entity.ForumUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from forum_user where username = #{text} or email = #{text}")
    ForumUser findUserByNameOrEmail(String text);
}
