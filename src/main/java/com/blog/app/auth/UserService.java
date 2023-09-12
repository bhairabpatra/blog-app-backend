package com.blog.app.auth;

import com.blog.app.post.Post;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    User signIn(User user);

    Boolean existsByName(String userName);

    Boolean existsByEmail(String email);

    Boolean isEnteredPasswordMatch(String p1, String p2);

    User getUser(String email);

    User getUserById(Long id);


    List<User> getUsers();

    // Edit user

    User editUser(User user);

    // Delete user

    void deleteUser(Long id);

}
