package com.blog.app.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
@CrossOrigin("*")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post newPost = postService.createPost(post);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Post>> getPosts() {
        List<Post> allPosts = postService.getPosts();
        return ResponseEntity.ok(allPosts);
    }

    @GetMapping("{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post post = postService.singlePost(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> getDelById(@PathVariable Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>("POST successfully deleted -> " + id, HttpStatus.NOT_FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<Post> createPost(@RequestBody Post post, @PathVariable Long id) {
        post.setId(id);
        Post newPost = postService.createPost(post);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Post>> getAllCat(@PathVariable String category) {
        System.out.println((category));
        List<Post> allCatItem = postService.findByPostCategory(category);
        return new ResponseEntity<>(allCatItem, HttpStatus.OK);
    }
}
