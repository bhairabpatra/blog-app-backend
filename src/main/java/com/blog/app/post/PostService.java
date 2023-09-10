package com.blog.app.post;

import java.util.List;

public interface PostService {
    public Post createPost(Post post);

    public Post updatePost(Post post);

    public List<Post> getPosts();

    public Post singlePost(Long id);

    public void deletePost(Long id);
}
