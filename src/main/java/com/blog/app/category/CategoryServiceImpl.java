package com.blog.app.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public PostCategory create(PostCategory postCategory) {
        return categoryRepository.save(postCategory);
    }


    @Override
    public String deleteCategory(Long id) {

        if (categoryRepository.findById(id).isPresent()) {
            categoryRepository.deleteById(id);
            return "post Deleted successfully";
        } else {
            return "No Such Post Found";
        }
    }

    @Override
    public List<PostCategory> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public PostCategory editCategory(PostCategory postCategory) {
        return categoryRepository.save(postCategory);
    }


}
