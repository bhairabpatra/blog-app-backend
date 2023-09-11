package com.blog.app.auth;

import com.blog.app.exception.NotFoundException;
import com.blog.app.post.Post;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public User getUser(String email) {
         User user = userRepository.findByEmail(email);
        return user;
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> newUser = userRepository.findById(id);
        if (!newUser.isPresent()) {
            throw new NotFoundException("User not found for the provided ID : "+id);
        }
        return  newUser.get();
    }

    @Override
    public List<User> getUsers() {
        List<User> newUser = userRepository.findAll();
        if(newUser.isEmpty()){
            throw new NotFoundException("User Not Found");
        }
        return userRepository.findAll();
    }

    @Override
    public User editUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
