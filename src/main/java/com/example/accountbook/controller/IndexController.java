package com.example.accountbook.controller;

import com.example.accountbook.entity.Record;
import com.example.accountbook.service.CategoryService;
import com.example.accountbook.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    private RecordService recordService;
    @Autowired
    private CategoryService categoryService;

    // 默认跳转到当月统计页
    @GetMapping("/")
    public String index(Model model, @RequestParam(required = false) String month) {
        // 如果没传月份，默认当前月
        if (month == null || month.isEmpty()) {
            month = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));
        }
        // 月度统计
        Map<String, BigDecimal> total = recordService.getMonthTotal(month);
        BigDecimal totalIncome = total.get("totalIncome");
        BigDecimal totalExpense = total.get("totalExpense");
        BigDecimal balance = totalIncome.subtract(totalExpense);
        // 分类统计（添加占比计算）
        List<Map<String, Object>> categoryStats = recordService.getCategoryStats(month);
        for (Map<String, Object> stat : categoryStats) {
            BigDecimal amount = (BigDecimal) stat.get("totalAmount");
            Integer type = (Integer) stat.get("categoryType");
            BigDecimal totalAmount = type == 1 ? totalIncome : totalExpense;
            String percentage = "0.0%";
            if (totalAmount.compareTo(BigDecimal.ZERO) > 0) {
                BigDecimal ratio = amount.divide(totalAmount, 3, java.math.RoundingMode.HALF_UP)
                        .multiply(new BigDecimal(100));
                percentage = String.format("%.1f%%", ratio);
            }
            stat.put("percentage", percentage);
        }
        // 记录列表
        List<Record> records = recordService.getRecordsByMonth(month);

        model.addAttribute("month", month);
        model.addAttribute("totalIncome", totalIncome);
        model.addAttribute("totalExpense", totalExpense);
        model.addAttribute("balance", balance);
        model.addAttribute("categoryStats", categoryStats);
        model.addAttribute("records", records);
        model.addAttribute("incomeCategories", categoryService.getIncomeCategories());
        model.addAttribute("expenseCategories", categoryService.getExpenseCategories());

        return "index";
    }

    // 添加记录接口
    @PostMapping("/record/add")
    @ResponseBody
    public String addRecord(Record record) {
        recordService.addRecord(record);
        return "success";
    }

    // 删除记录接口
    @GetMapping("/record/delete/{id}")
    @ResponseBody
    public String deleteRecord(@PathVariable Integer id) {
        recordService.deleteRecord(id);
        return "success";
    }

    // 获取单条记录接口（用于修改）
    @GetMapping("/record/get/{id}")
    @ResponseBody
    public Record getRecord(@PathVariable Integer id) {
        return recordService.getRecordById(id);
    }

    // 修改记录接口
    @PostMapping("/record/update")
    @ResponseBody
    public String updateRecord(Record record) {
        recordService.updateRecord(record);
        return "success";
    }
}