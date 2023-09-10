package com.blog.app.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User signIn(User user) {
        return null;
    }

    @Override
    public Boolean existsByName(String userName) {
        return userRepository.existsByName(userName);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Boolean isEnteredPasswordMatch(String p1, String p2) {
        if (p1.equals(p2)) {
            return true;
        } else {
            return false;
        }
    }


//    @Override
//    public Boolean existsByEmail(String userEmail) {
//        return userRepository.existsByEmail(userEmail);
//    }
}
