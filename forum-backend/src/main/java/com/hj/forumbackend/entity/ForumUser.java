package com.hj.forumbackend.entity;

import lombok.Data;

@Data
public class ForumUser {
    int id;
    String username;
    String password;
    String email;

}
