package com.example.accountbook.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Record {
    private Integer id;
    private BigDecimal amount;
    private Integer categoryId;
    // 把Date改成LocalDate
    private LocalDate recordDate;
    private String remark;
    // 把Date改成LocalDateTime
    private LocalDateTime createTime;
    // 额外字段：用于显示分类名称
    private String categoryName;
    // 额外字段：用于显示分类类型
    private Integer categoryType;

    // 右键→Generate→Getter和Setter→全选重新生成所有getter和setter
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }
    public LocalDate getRecordDate() { return recordDate; }
    public void setRecordDate(LocalDate recordDate) { this.recordDate = recordDate; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
    public LocalDateTime getCreateTime() { return createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }
    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public Integer getCategoryType() { return categoryType; }
    public void setCategoryType(Integer categoryType) { this.categoryType = categoryType; }
}