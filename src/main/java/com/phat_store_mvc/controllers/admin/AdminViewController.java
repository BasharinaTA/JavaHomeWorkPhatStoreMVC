package com.phat_store_mvc.controllers.admin;

import com.phat_store_mvc.model.goods.Category;
import com.phat_store_mvc.services.category.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminViewController {
    private CategoryService categoryService;

    @GetMapping("/category")
    public String getCategories(Model model) {
        List<Category> categories = categoryService.getAllOrderById();
        model.addAttribute("category", new Category());
        model.addAttribute("categories", categories);
        return "/pages/admin/admin";
    }
}
