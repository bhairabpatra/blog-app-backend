package com.blog.app.auth;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;

    @NotEmpty(message = "This field cannot be empty")
    @Size(min = 2, message = "Please enter at least 2 characters for name")
    private String name;

    @Email(message = "Please enter a valid email address")
    @NotEmpty(message = "This field cannot be empty")
    private String email;

    @NotEmpty(message = "This field cannot be empty")
    @Size(min = 10, message = "Please enter at least 10 digit for phone number")
    private String phone;

    @NotEmpty(message = "Please enter at least 5 characters for password")
    private String password;

    @NotEmpty(message = "Please enter at least 5 characters for password")
    private String conPassword;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConPassword() {
        return conPassword;
    }

    public void setConPassword(String conPassword) {
        this.conPassword = conPassword;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User(Long id, String name, String email, String phone, String password, String conPassword, LocalDateTime createdAt, LocalDateTime updatedAt) {
        Id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.conPassword = conPassword;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public User() {
    }
}
