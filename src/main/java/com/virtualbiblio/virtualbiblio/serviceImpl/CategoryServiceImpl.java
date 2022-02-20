package com.virtualbiblio.virtualbiblio.serviceImpl;

import com.virtualbiblio.virtualbiblio.model.Category;
import com.virtualbiblio.virtualbiblio.repository.CategoryRepository;
import com.virtualbiblio.virtualbiblio.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public String ajoutCategory(Category category) {
         categoryRepository.save(category);
        return "ok";
    }

    @Override
    public List<Category> allCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Category category, Long id) {

        Category updateCategry = categoryRepository.findById(id).get();

        updateCategry.setCategory(updateCategry.getCategory());
        updateCategry.setDescription(updateCategry.getDescription());
        return categoryRepository.save(updateCategry);
    }

    @Override
    public Category categoryParId(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Void deleteCategory(Long id) {
        return null;
    }

    @Override
    public Category disable(Long id) {
        Category disable = categoryRepository.findById(id).get();
        disable.setDeleted(true);
        return categoryRepository.save(disable);
    }

    @Override
    public Category restore(Long id) {
        Category restore = categoryRepository.findById(id).get();
        restore.setDeleted(false);
        return categoryRepository.save(restore);
    }
}
