package com.phat_store_mvc.controllers;

import com.phat_store_mvc.dto.CategoryDTO;
import com.phat_store_mvc.dto.ItemMapDTO;
import com.phat_store_mvc.services.category.CategoryService;
import com.phat_store_mvc.services.item.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class ViewController {
    private CategoryService categoryService;
    private ItemService itemService;

    @GetMapping("/")
    public String home(Model model) {
        List<CategoryDTO> categories = new ArrayList<>() {{categoryService.getAllOrderById().forEach(category -> add(new CategoryDTO(category)));}};
        model.addAttribute("categories", categories);
        return "pages/ui/home";
    }

    @GetMapping("/admin")
    public String adminPortal() {
        return "/pages/admin/admin";
    }

    @GetMapping("/category/{id}")
    public String category(Model model, @PathVariable Integer id) {
        model.addAttribute("category", categoryService.getById(id).getName());
        model.addAttribute("items",  ItemMapDTO.fromEntityList(itemService.getAllByCategoryId(id)));
        return "/pages/ui/category";
    }
}
