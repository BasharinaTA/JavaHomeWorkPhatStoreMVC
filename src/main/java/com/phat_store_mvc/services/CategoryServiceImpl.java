package com.phat_store_mvc.services;

import com.phat_store_mvc.model.Category;
import com.phat_store_mvc.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllOrderById() {
//       return categoryRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return categoryRepository.findByOrderByIdAsc();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Integer id, String name) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isEmpty()) {
            throw new RuntimeException();
        }
        Category category = categoryOptional.get();
        category.setName(name);
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }
}
