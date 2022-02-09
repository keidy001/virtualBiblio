package com.virtualbiblio.virtualbiblio.controller;

import com.virtualbiblio.virtualbiblio.model.Category;
import com.virtualbiblio.virtualbiblio.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/category/")

public class CategoryController {
    @Autowired
    CategoryService categoryService;
@PostMapping("ajout")
    public String ajoutCategory(@RequestBody Category category) {
        return categoryService.ajoutCategory(category);
    }
    @GetMapping("list")
    public List<Category> allCategory() {
        return categoryService.allCategory();
    }
    @PutMapping("update/{id}")
    public Category updateCategory(@RequestBody Category category, @PathVariable("id") Long id) {
        return categoryService.updateCategory(category, id);
    }
    @GetMapping("affiche/{id}")
    public Category categoryParId(@PathVariable("id") Long id) {
        return categoryService.categoryParId(id);
    }
    @DeleteMapping("delete")
    public Void deleteCategory(Long id) {
        return categoryService.deleteCategory(id);
    }
    @GetMapping("disable")
    public Category disable(@RequestBody Category category, @PathVariable Long id) {
        return categoryService.disable(category, id);
    }
    @PutMapping("restore")
    public Category restore(Category category, Long id) {
        return categoryService.restore(category, id);
    }
}
