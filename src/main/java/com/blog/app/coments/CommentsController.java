package com.blog.app.coments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/comment")
@CrossOrigin("*")
public class CommentsController {

    @Autowired
    private CommentService commentService;
    @PostMapping("create")
    public ResponseEntity<PostComments> createComments(@RequestBody PostComments comments){
        PostComments newComments = commentService.createComment(comments);
        return  new ResponseEntity<>(newComments, HttpStatus.CREATED);

    }
}
