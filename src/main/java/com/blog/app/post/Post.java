package com.blog.app.post;

import com.blog.app.auth.User;
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
    private Long userId;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private String postCategory;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "comments_id")
    private List<PostComments> postComments = new ArrayList<>();

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


    public List<PostComments> getPostComments() {
        return postComments;
    }

    public void setPostComments(List<PostComments> postComments) {
        this.postComments = postComments;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPostCategory() {
        return postCategory;
    }

    public void setPostCategory(String postCategory) {
        this.postCategory = postCategory;
    }

    public Post(Long id, String postTitle, String sortDescription, String longDescription, String postImgUrl, Long postLike, Long userId, LocalDateTime createdAt, LocalDateTime updatedAt, String postCategory, List<PostComments> postComments) {
        Id = id;
        this.postTitle = postTitle;
        this.sortDescription = sortDescription;
        this.longDescription = longDescription;
        this.postImgUrl = postImgUrl;
        this.postLike = postLike;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.postCategory = postCategory;
        this.postComments = postComments;
    }

    public Post() {
    }
}
