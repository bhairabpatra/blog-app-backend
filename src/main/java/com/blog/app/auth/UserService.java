package com.blog.app.auth;

import com.blog.app.post.Post;

import java.util.Optional;

public interface UserService {

    public  User createUser(User user);
    public  User signIn(User user);

    Boolean existsByName(String userName);

    Boolean existsByEmail(String email);

    Boolean isEnteredPasswordMatch(String p1 , String p2);


    public User getUser(String email);
}
