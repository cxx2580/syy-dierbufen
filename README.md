# 简易ERP系统 - 销售管理模块

## 项目概述

这是一个基于Spring Boot + Vue + MyBatis的简易ERP系统，包含销售管理模块。

## 技术栈

### 后端
- Spring Boot 2.7.18
- MyBatis
- MySQL
- Druid连接池
- Lombok

### 前端
- Vue 2.6.14
- Element UI 2.15.14
- Vue Router
- Axios

## 项目结构

```
syy/
├── erp-backend/          # 后端项目
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/erp/
│   │   │   │   ├── ErpApplication.java
│   │   │   │   ├── common/        # 公共类
│   │   │   │   ├── controller/    # 控制器
│   │   │   │   ├── dto/           # 数据传输对象
│   │   │   │   ├── entity/        # 实体类
│   │   │   │   ├── mapper/        # MyBatis Mapper
│   │   │   │   └── service/       # 服务层
│   │   │   └── resources/
│   │   │       ├── application.yml
│   │   │       ├── mapper/        # MyBatis XML映射文件
│   │   │       └── schema.sql     # 数据库初始化脚本
│   └── pom.xml
└── erp-frontend/         # 前端项目
    ├── public/
    │   └── index.html
    ├── src/
    │   ├── main.js
    │   ├── App.vue
    │   ├── router/
    │   └── views/        # 页面组件
    └── package.json
```

## 快速开始

### 1. 数据库准备

确保已安装MySQL 5.7+，然后执行以下步骤：

```bash
# 创建数据库和表
mysql -u root -p < erp-backend/src/main/resources/schema.sql
```

或者手动执行 [schema.sql](erp-backend/src/main/resources/schema.sql) 中的SQL语句。

### 2. 配置数据库连接

修改 [application.yml](erp-backend/src/main/resources/application.yml) 中的数据库配置：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/erp_db?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false
    username: root      # 修改为你的MySQL用户名
    password: root      # 修改为你的MySQL密码
```

### 3. 启动后端服务

```bash
cd erp-backend
mvn clean install
mvn spring-boot:run
```

后端服务将在 http://localhost:8080 启动。

### 4. 启动前端服务

```bash
cd erp-frontend
npm install
npm run serve
```

前端服务将在 http://localhost:8081 启动。

## 功能模块

### 1. 客户管理
- 新增客户
- 编辑客户
- 删除客户
- 搜索客户
- 查看客户列表

### 2. 产品管理
- 新增产品
- 编辑产品
- 删除产品
- 搜索产品
- 查看产品列表

### 3. 销售订单管理
- 新增订单（支持添加多个产品明细）
- 编辑订单
- 删除订单
- 查看订单详情
- 搜索订单
- 订单状态管理（待审核、已审核、已发货、已完成、已取消）

## 测试数据

系统已预置以下测试数据：

### 客户
- C001 - 北京科技有限公司
- C002 - 上海贸易公司
- C003 - 广州制造公司

### 产品
- P001 - 笔记本电脑
- P002 - 无线鼠标
- P003 - 机械键盘
- P004 - 显示器

## API接口

### 客户接口
- `GET /api/customer/list` - 获取客户列表
- `GET /api/customer/get/{id}` - 获取客户详情
- `POST /api/customer/add` - 新增客户
- `POST /api/customer/update` - 更新客户
- `DELETE /api/customer/delete/{id}` - 删除客户

### 产品接口
- `GET /api/product/list` - 获取产品列表
- `GET /api/product/get/{id}` - 获取产品详情
- `POST /api/product/add` - 新增产品
- `POST /api/product/update` - 更新产品
- `DELETE /api/product/delete/{id}` - 删除产品

### 销售订单接口
- `GET /api/sales-order/list` - 获取订单列表
- `GET /api/sales-order/get/{id}` - 获取订单详情
- `POST /api/sales-order/add` - 新增订单
- `POST /api/sales-order/update` - 更新订单
- `DELETE /api/sales-order/delete/{id}` - 删除订单

## 后续实验规划

- 实验二：生产管理模块
- 实验三：采购管理模块
- 实验四：库存管理模块
- 实验五：ERP系统整合

## 注意事项

1. 确保MySQL服务已启动
2. 确保数据库连接配置正确
3. 先启动后端服务，再启动前端服务
4. 如遇端口冲突，可修改相应配置
