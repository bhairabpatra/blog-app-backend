package com.blog.app.category;

import java.util.List;

public interface CategoryService {
    public PostCategory create(PostCategory postCategory);

    public String deleteCategory(Long id);

    public List<PostCategory> getAll();

    public PostCategory editCategory(PostCategory postCategory);




}
