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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
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

}
