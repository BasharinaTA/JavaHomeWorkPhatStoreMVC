package com.phat_store_mvc.controllers;

import com.phat_store_mvc.model.Category;
import com.phat_store_mvc.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class ViewController {
    private CategoryService categoryService;

    @GetMapping("/")
    public String home(Model model) {
        List<String> categories = categoryService.getAll().stream().map(Category::getName).toList();
        model.addAttribute("categories", categories);
        return "pages/home";
    }

    @GetMapping("/category/{name}")
    public String category(Model model, @PathVariable String name) {
        model.addAttribute("category", name);
        return "pages/category";
    }
 }
