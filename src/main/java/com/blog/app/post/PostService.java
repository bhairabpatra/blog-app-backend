package com.blog.app.post;

import java.util.List;

public interface PostService {
    public Post createPost(Post post);

    public Post updatePost(Post post);

    public List<Post> getPosts();

    public Post singlePost(Long id);

    void deletePost(Long id);

    List<Post> findByPostCategory(String catName);
}
