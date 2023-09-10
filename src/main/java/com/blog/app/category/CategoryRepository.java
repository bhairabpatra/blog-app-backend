package com.blog.app.category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<PostCategory, Long> {

//    boolean existsByName(String categoryName);
}
