package com.example.accountbook.entity;

public class Category {
    private Integer id;
    private String name;
    private Integer type; // 1-收入 2-支出

    // 右键→Generate→Getter和Setter→全选生成
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getType() { return type; }
    public void setType(Integer type) { this.type = type; }
}