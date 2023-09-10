package com.blog.app.coments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentsRepository commentsRepository;
    @Override
    public PostComments createComment(PostComments comments) {
        return commentsRepository.save(comments);
    }
}
