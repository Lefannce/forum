package com.hj.forumbackend.service;

import com.hj.forumbackend.entity.ForumUser;
import com.hj.forumbackend.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizeService implements UserDetailsService {
    @Resource
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null)
            throw new UsernameNotFoundException("用户名不为空");

        ForumUser userByNameOrEmail = userMapper.findUserByNameOrEmail(username);
        if (userByNameOrEmail == null)
            throw new UsernameNotFoundException("用户名或密码错误");
        return User
                .withUsername(userByNameOrEmail.getUsername())
                .password(userByNameOrEmail.getPassword())
                .roles("user")
                .build();
    }
}
