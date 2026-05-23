package com.example.accountbook.mapper;

import com.example.accountbook.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
public interface RecordMapper {
    // 添加记录
    int insert(Record record);
    // 删除记录
    int deleteById(Integer id);
    // 修改记录
    int update(Record record);
    // 根据ID查询记录
    Record selectById(Integer id);
    // 按月份查询所有记录（格式：2026-05）
    List<Record> selectByMonth(@Param("month") String month);
    // 月度统计：总收入、总支出
    Map<String, BigDecimal> selectMonthTotal(@Param("month") String month);
    // 分类统计：按分类统计该月收支
    List<Map<String, Object>> selectCategoryStats(@Param("month") String month);
}