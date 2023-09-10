package com.blog.app.auth;


import com.blog.app.payload.MessageResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("signUp")
    public ResponseEntity<?> signUp(@Valid @RequestBody User user) {

        if (userService.existsByName(user.getName())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!!"));
        } else if (userService.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already taken!"));
        }
        if (userService.isEnteredPasswordMatch(user.getPassword(), user.getConPassword())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Password not matched"));
        }
        userService.createUser(user);
        return new ResponseEntity<>(new MessageResponse("User registered successfully!"), HttpStatus.OK);

    }
}

//https://www.javaguides.net/2021/10/login-and-registration-rest-api-using-spring-boot-spring-security-hibernate-mysql-database.html
//https://www.bezkoder.com/spring-boot-login-example-mysql/