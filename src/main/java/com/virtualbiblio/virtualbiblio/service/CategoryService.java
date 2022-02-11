package com.virtualbiblio.virtualbiblio.service;

import com.virtualbiblio.virtualbiblio.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    String ajoutCategory(Category category);
    List<Category> allCategory();
    Category updateCategory(Category category, Long id);
    Category categoryParId(Long id);
    Void deleteCategory(Long id);
    Category disable(Long id);
    Category restore(Long id);
}
