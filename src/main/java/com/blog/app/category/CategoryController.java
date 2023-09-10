package com.blog.app.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("create")
    public ResponseEntity<PostCategory> createCategory(@RequestBody PostCategory postCategory) {

//        boolean isCatExist = categoryService.isExistsCategoryByName(postCategory.getPostCategory());
        System.out.println(postCategory.getPostCategory());
        PostCategory newCat = categoryService.create(postCategory);
        return new ResponseEntity<>(newCat, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<PostCategory>> getAllCategory() {
        List<PostCategory> allPost = categoryService.getAll();
        return new ResponseEntity<>(allPost, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<PostCategory> editCategory(@RequestBody PostCategory postCategory, @PathVariable Long id) {
        postCategory.setId(id);
        PostCategory updateCat = categoryService.editCategory(postCategory);
        return ResponseEntity.ok(updateCat);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable long id) {
        String deleteMsg = categoryService.deleteCategory(id);
        return new ResponseEntity<>(deleteMsg, HttpStatus.OK);
    }
}
