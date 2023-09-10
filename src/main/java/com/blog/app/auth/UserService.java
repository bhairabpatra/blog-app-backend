package com.blog.app.auth;

public interface UserService {

    public  User createUser(User user);
    public  User signIn(User user);

    Boolean existsByName(String userName);

    Boolean existsByEmail(String email);

    Boolean isEnteredPasswordMatch(String p1 , String p2);
}
