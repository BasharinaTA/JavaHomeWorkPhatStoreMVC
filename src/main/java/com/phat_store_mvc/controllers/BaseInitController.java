package com.phat_store_mvc.controllers;

import com.phat_store_mvc.services.BaseInitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/generate")
@AllArgsConstructor
public class BaseInitController {
    private BaseInitService baseInitService;

    @GetMapping("/")
    public String baseInit() {
        baseInitService.brandInit();
        baseInitService.categoryInit();
        baseInitService.itemInit();
        baseInitService.check();
        return "redirect:/";
    }
}
