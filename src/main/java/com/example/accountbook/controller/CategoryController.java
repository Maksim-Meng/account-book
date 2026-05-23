package com.example.accountbook.controller;

import com.example.accountbook.entity.Category;
import com.example.accountbook.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/{type}")
    @ResponseBody
    public List<Category> getCategories(@PathVariable Integer type) {
        return type == 1 ? categoryService.getIncomeCategories() : categoryService.getExpenseCategories();
    }
}