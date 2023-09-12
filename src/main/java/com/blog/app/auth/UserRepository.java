package com.blog.app.auth;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByName(String name);

    Boolean existsByEmail(String email);

    User findByEmail(String email);
}
