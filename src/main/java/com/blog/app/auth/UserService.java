package com.blog.app.auth;

import com.blog.app.post.Post;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public  User createUser(User user);
    public  User signIn(User user);

    Boolean existsByName(String userName);

    Boolean existsByEmail(String email);

    Boolean isEnteredPasswordMatch(String p1 , String p2);

    public User getUser(String email);

    public User getUserById (Long id);


    public List<User> getUsers();

    // Edit user

    public User editUser(User user);

    // Delete user

    public  void deleteUser(Long id);

    // password reset

}
