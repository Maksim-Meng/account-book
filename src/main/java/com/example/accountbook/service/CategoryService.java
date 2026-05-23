package com.example.accountbook.service;

import com.example.accountbook.entity.Category;
import com.example.accountbook.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> getIncomeCategories() {
        return categoryMapper.selectByType(1);
    }

    public List<Category> getExpenseCategories() {
        return categoryMapper.selectByType(2);
    }
}