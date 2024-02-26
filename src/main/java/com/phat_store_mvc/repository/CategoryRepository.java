package com.phat_store_mvc.repository;

import com.phat_store_mvc.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
