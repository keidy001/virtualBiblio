package com.virtualbiblio.virtualbiblio.controller;

import com.virtualbiblio.virtualbiblio.model.Category;
import com.virtualbiblio.virtualbiblio.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/category")

public class CategoryController {
    @Autowired
    CategoryService categoryService;
@PostMapping("/ajouter")
    public String ajoutCategory(@RequestBody Category category) {
        return categoryService.ajoutCategory(category);
    }
    @GetMapping("/lister")
    public List<Category> allCategory() {
        return categoryService.allCategory();
    }
    @PutMapping("/modifier/{id}")
    public Category updateCategory(@RequestBody Category category, @PathVariable("id") Long id) {
        return categoryService.updateCategory(category, id);
    }
    @GetMapping("/afficher/{id}")
    public Category categoryParId(@PathVariable("id") Long id) {
        return categoryService.categoryParId(id);
    }
    @DeleteMapping("/supprimer")
    public Void deleteCategory(Long id) {
        return categoryService.deleteCategory(id);
    }
    @PutMapping("/disable/{id}")
    public Category disable(@PathVariable Long id) {
        return categoryService.disable(id);
    }
    @PutMapping("/restore/{id}")
    public Category restore(@PathVariable("id") Long id) {
        return categoryService.restore(id);
    }
}
