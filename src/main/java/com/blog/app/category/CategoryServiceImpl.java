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


//        System.out.println(isCatExist);
//        if (isCatExist) {
//            return categoryRepository.save(postCategory);
//        } else {
//            System.out.println("Category already exist");
//            return null;
//        }

    }


    @Override
    public String deleteCategory(Long id) {

        if (categoryRepository.findById(id).isPresent()) {
            categoryRepository.deleteById(id);
            return "post Deleted successfully";
        } else {
            return "no such post Deleted successfully";
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
