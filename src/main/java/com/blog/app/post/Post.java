package com.blog.app.post;

import com.blog.app.category.PostCategory;
import com.blog.app.coments.PostComments;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@Data
@Entity
@Table(name = "post_table")
public class Post {

    @Id
    @GeneratedValue(generator = "post_id", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "post_id", sequenceName = "post_seq", initialValue = 1, allocationSize = 1)
    private Long Id;
    private String postTitle;
    private String sortDescription;
    private String longDescription;
    private String postImgUrl;
    private Long postLike;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private PostCategory postCategory;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "comments_id")
    private List<PostComments> postComments = new ArrayList<>();
//    private PostComments postComments;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getSortDescription() {
        return sortDescription;
    }

    public void setSortDescription(String sortDescription) {
        this.sortDescription = sortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getPostImgUrl() {
        return postImgUrl;
    }

    public void setPostImgUrl(String postImgUrl) {
        this.postImgUrl = postImgUrl;
    }

    public Long getPostLike() {
        return postLike;
    }

    public void setPostLike(Long postLike) {
        this.postLike = postLike;
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

    public PostCategory getPostCategory() {
        return postCategory;
    }

    public void setPostCategory(PostCategory postCategory) {
        this.postCategory = postCategory;
    }

    public List<PostComments> getPostComments() {
        return postComments;
    }

    public void setPostComments(List<PostComments> postComments) {
        this.postComments = postComments;
    }

    public Post(Long id, String postTitle, String sortDescription, String longDescription, String postImgUrl, Long postLike, LocalDateTime createdAt, LocalDateTime updatedAt, PostCategory postCategory, List<PostComments> postComments) {
        Id = id;
        this.postTitle = postTitle;
        this.sortDescription = sortDescription;
        this.longDescription = longDescription;
        this.postImgUrl = postImgUrl;
        this.postLike = postLike;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.postCategory = postCategory;
        this.postComments = postComments;
    }

    public Post() {
    }
}
