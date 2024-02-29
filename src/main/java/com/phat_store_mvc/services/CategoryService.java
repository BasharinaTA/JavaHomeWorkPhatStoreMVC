package com.phat_store_mvc.services;

import com.phat_store_mvc.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllOrderById();

    Category save(Category category);

    Category update(Integer id, String name);

    void delete(Integer id);
}
