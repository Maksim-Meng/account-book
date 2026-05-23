# 个人记账本系统

基于Spring Boot+MyBatis开发的轻量级个人记账本系统，适合Java初学者学习和个人日常使用。

## 功能特点
- ✅ 收支记录的增删改查
- ✅ 预设常用收支分类
- ✅ 月度收支自动统计
- ✅ 分类占比统计
- ✅ 简洁美观的Bootstrap界面
- ✅ 无需额外配置，开箱即用

## 技术栈
- 后端：Java 17 + Spring Boot 3.2.5 + MyBatis 4.0.1
- 前端：Thymeleaf + Bootstrap 3.3.7 + jQuery
- 数据库：MySQL 8.0
- 构建工具：Maven

## 运行步骤
🚀 快速运行
环境要求
JDK 17 及以上
MySQL 8.0 及以上
Maven 3.6 及以上
步骤 1：克隆项目到本地
bash
运行
git clone https://github.com/Maksim-Meng/account-book.git
cd account-book
步骤 2：初始化数据库
打开 MySQL 客户端（Navicat、MySQL Workbench 或命令行），依次执行以下 SQL 语句：
sql
-- 创建数据库
CREATE DATABASE account_book CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 使用数据库
USE account_book;

-- 创建收支分类表
CREATE TABLE t_category (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    type TINYINT NOT NULL COMMENT '1-收入，2-支出'
);

-- 插入预设分类数据
INSERT INTO t_category (name, type) VALUES
('工资', 1), ('奖金', 1), ('红包', 1), ('兼职', 1), ('其他收入', 1),
('餐饮', 2), ('交通', 2), ('购物', 2), ('娱乐', 2), ('学习', 2), ('医疗', 2), ('其他支出', 2);

-- 创建收支记录表
CREATE TABLE t_record (
    id INT PRIMARY KEY AUTO_INCREMENT,
    amount DECIMAL(10,2) NOT NULL,
    category_id INT NOT NULL,
    record_date DATE NOT NULL,
    remark VARCHAR(200),
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES t_category(id)
);
步骤 3：修改数据库配置
打开 src/main/resources/application.properties 文件，修改为你自己的 MySQL 用户名和密码：
properties
# 数据库连接配置
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/account_book?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai
spring.datasource.username=你的MySQL用户名
spring.datasource.password=你的MySQL密码

# MyBatis配置
mybatis.type-aliases-package=com.example.accountbook.entity
mybatis.mapper-locations=classpath:mapper/*.xml

# 允许Bean定义覆盖（解决版本冲突）
spring.main.allow-bean-definition-overriding=true

# 服务器端口
server.port=8080
步骤 4：启动项目
用 IntelliJ IDEA 打开项目
等待 Maven 自动下载所有依赖
找到并运行启动类：com.example.accountbook.AccountBookApplication
看到控制台输出 Started AccountBookApplication 即启动成功
打开浏览器访问：http://localhost:8080*
