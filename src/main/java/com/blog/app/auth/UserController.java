package com.blog.app.auth;

import com.blog.app.payload.MessageResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("signUp")
    public ResponseEntity<?> signUp(@Valid @RequestBody User user) {

        if (userService.existsByName(user.getName())) {
            return ResponseEntity.badRequest().body(new MessageResponse("This user name is already in use. Please choose another.", "error"));
        } else if (userService.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("This email address is already in use. Please choose another.", "error"));
        }
        if (!(userService.isEnteredPasswordMatch(user.getPassword(), user.getConPassword()))) {
            return ResponseEntity.badRequest().body(new MessageResponse("Passwords do not match. Please ensure both passwords are the same", "error"));
        }
        user.setPassword(passwordEncoder.encode(user.getConPassword()));
        user.setConPassword(passwordEncoder.encode(user.getConPassword()));
        userService.createUser(user);
        return new ResponseEntity<>(new MessageResponse("Registration Successful! Welcome to Application Name!", "success"), HttpStatus.OK);

    }

    @PostMapping("signIn")
    public ResponseEntity<?> signIn(@RequestBody User user) {
        if (!(userService.existsByEmail(user.getEmail()))) {
            return ResponseEntity.badRequest().body(new MessageResponse("This email address is not registered. Please check your email or sign up for a new account", "error"));
        }
        User newUser = userService.getUser(user.getEmail());
        if (passwordEncoder.matches(user.getPassword(), newUser.getPassword())) {
            return new ResponseEntity<>(new MessageResponse("Login Successful! Welcome to Application Name!", "success"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageResponse("Login Failed. Please check your email and password and try again", "error"), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("getUser/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User newUser = userService.getUserById(id);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @GetMapping("getUsers")
    public ResponseEntity<List<User>> getUsers() {
        List<User> newUser = userService.getUsers();
        return ResponseEntity.status(HttpStatus.OK).body(newUser);
    }


    // Edit user details
    @PutMapping("update/{id}")
    public ResponseEntity<User> editUser(@PathVariable Long id, @RequestBody User user) {
        User oldUserDetails = userService.getUserById(id);
        oldUserDetails.setName(user.getName());
        oldUserDetails.setEmail(user.getEmail());
        oldUserDetails.setPhone(user.getPhone());
        User updatedUser = userService.editUser(oldUserDetails);
        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
    }

    // Delete user
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(new MessageResponse("User delete Successfully!", "success"), HttpStatus.OK);
    }

    // password reset
    @PutMapping("update-password/{email}")
    public ResponseEntity<?> updatePassword(@PathVariable String email, @RequestBody User user) {
        User existUser = userService.getUser(email);

        existUser.setPassword(user.getPassword());
        existUser.setConPassword(user.getConPassword());

        if (!(userService.isEnteredPasswordMatch(existUser.getPassword(), existUser.getConPassword()))) {
            return ResponseEntity.badRequest().body(new MessageResponse("Passwords do not match. Please ensure both passwords are the same", "error"));
        } else {
            existUser.setPassword(passwordEncoder.encode(existUser.getConPassword()));
            existUser.setConPassword(passwordEncoder.encode(existUser.getConPassword()));
            User updatePassword = userService.editUser(existUser);
            return ResponseEntity.badRequest().body(new MessageResponse("Passwords updated successfully", "success"));
        }
    }
}

//https://www.javaguides.net/2021/10/login-and-registration-rest-api-using-spring-boot-spring-security-hibernate-mysql-database.html
//https://www.bezkoder.com/spring-boot-login-example-mysql/