package com.example.accountbook.mapper;

import com.example.accountbook.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CategoryMapper {
    // 根据类型查询分类（1-收入 2-支出）
    List<Category> selectByType(Integer type);
    // 根据ID查询分类名称
    String selectNameById(Integer id);
}