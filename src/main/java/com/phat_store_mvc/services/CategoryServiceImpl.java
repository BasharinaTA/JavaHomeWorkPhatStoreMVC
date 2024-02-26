package com.phat_store_mvc.services;

import com.phat_store_mvc.model.Category;
import com.phat_store_mvc.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
       return categoryRepository.findAll();
    }
}
