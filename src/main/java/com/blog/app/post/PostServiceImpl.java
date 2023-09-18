package com.blog.app.post;
import com.blog.app.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> getPosts() {
        Optional<List<Post>> post = Optional.of(postRepository.findAll());
        if (!post.isPresent()) {
           throw new NotFoundException("Post not found");
        }
        return post.get();
    }

    @Override
    public Post singlePost(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if (!post.isPresent()) {
            throw new NotFoundException("Post not found for the provided ID : "+id);
        }
        return post.get();
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
