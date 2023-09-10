package com.blog.app.coments;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<PostComments , Long> {
}
