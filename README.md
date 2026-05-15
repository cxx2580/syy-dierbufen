# 简易ERP系统

## 项目概述

基于 **Spring Boot + Vue + MyBatis** 的前后端分离 ERP 系统，涵盖企业进销存核心业务流程。

## 技术栈

### 后端
- Spring Boot 2.7.18
- MyBatis
- MySQL 8.0
- Druid 连接池
- Lombok
- Validation

### 前端
- Vue 2.6.14
- Element UI 2.15.14
- Vue Router
- Axios

## 项目结构

```
ERP_jianyixitong/
├── erp-backend/                     # 后端项目
│   ├── src/main/java/com/erp/
│   │   ├── ErpApplication.java      # 启动类
│   │   ├── common/                  # 公共类（Result、PageResult、异常处理）
│   │   ├── controller/              # 控制器层
│   │   ├── dto/                     # 数据传输对象
│   │   ├── entity/                  # 实体类
│   │   ├── mapper/                  # MyBatis Mapper 接口
│   │   └── service/                 # 服务层
│   ├── src/main/resources/
│   │   ├── application.yml          # 应用配置
│   │   ├── mapper/                  # MyBatis XML 映射
│   │   ├── schema.sql               # 数据库建表脚本
│   │   └── data.sql                 # 测试数据
│   └── pom.xml
└── erp-frontend/                    # 前端项目
    ├── public/index.html
    ├── src/
    │   ├── main.js                  # 入口文件
    │   ├── App.vue                  # 主布局（含侧边栏导航）
    │   ├── router/index.js          # 路由配置
    │   └── views/                   # 页面组件
    │       ├── Customer.vue         # 客户管理
    │       ├── Product.vue          # 产品管理
    │       ├── SalesOrder.vue       # 销售订单
    │       ├── Production.vue       # 生产管理
    │       ├── Supplier.vue         # 供应商管理
    │       └── PurchaseOrder.vue    # 采购订单
    └── package.json
```

## 快速开始

### 1. 数据库准备

```bash
mysql -u root -p < erp-backend/src/main/resources/schema.sql
mysql -u root -p < erp-backend/src/main/resources/data.sql
```

### 2. 配置数据库连接

修改 `erp-backend/src/main/resources/application.yml`：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/erp_db?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false
    username: root    # 改为你的 MySQL 用户名
    password: 1234    # 改为你的 MySQL 密码
```

### 3. 启动后端

```bash
cd erp-backend
mvn spring-boot:run
```

后端运行在 http://localhost:8080

### 4. 启动前端

```bash
cd erp-frontend
npm install
npm run serve
```

前端运行在 http://localhost:8081

## 功能模块

### 实验一：销售管理模块
- 客户管理（新增/编辑/删除/搜索）
- 产品管理（新增/编辑/删除/搜索）
- 销售订单管理（订单 + 多产品明细，支持查看/编辑/删除）
- 订单状态：待审核 → 已审核 → 已发货 → 已完成 → 已取消
- 库存联动：销售出库自动扣减库存

### 实验二：生产管理模块
- 生产订单管理（新增/编辑/删除/搜索）
- 关联产品，自动回填规格/单位/单价
- 生产状态：计划中 → 生产中 → 已完成 → 已取消
- 库存联动：生产完成自动增加库存

### 实验三：采购管理模块
- 供应商管理（新增/编辑/删除/搜索）
- 采购订单管理（订单 + 多产品明细，支持查看/编辑/删除）
- 订单状态：待审核 → 已审核 → 已入库 → 已完成 → 已取消
- 库存联动：采购入库自动增加库存，退库减少库存

### 后续规划
- 实验四：库存管理模块
- 实验五：ERP 系统整合

## API 接口

### 客户接口
| 方法 | 路径 | 说明 |
|------|------|------|
| GET | `/api/customer/list` | 客户列表（分页 + 搜索） |
| GET | `/api/customer/get/{id}` | 客户详情 |
| POST | `/api/customer/add` | 新增客户 |
| POST | `/api/customer/update` | 更新客户 |
| DELETE | `/api/customer/delete/{id}` | 删除客户 |

### 产品接口
| 方法 | 路径 | 说明 |
|------|------|------|
| GET | `/api/product/list` | 产品列表（分页 + 搜索） |
| GET | `/api/product/get/{id}` | 产品详情 |
| POST | `/api/product/add` | 新增产品 |
| POST | `/api/product/update` | 更新产品 |
| DELETE | `/api/product/delete/{id}` | 删除产品 |

### 销售订单接口
| 方法 | 路径 | 说明 |
|------|------|------|
| GET | `/api/sales-order/list` | 订单列表（分页 + 搜索） |
| GET | `/api/sales-order/get/{id}` | 订单详情（含明细） |
| POST | `/api/sales-order/add` | 新增订单 |
| POST | `/api/sales-order/update` | 更新订单 |
| DELETE | `/api/sales-order/delete/{id}` | 删除订单 |

### 生产管理接口
| 方法 | 路径 | 说明 |
|------|------|------|
| GET | `/api/production-order/list` | 生产订单列表（分页 + 搜索） |
| GET | `/api/production-order/get/{id}` | 生产订单详情 |
| POST | `/api/production-order/add` | 新增生产订单 |
| POST | `/api/production-order/update` | 更新生产订单 |
| DELETE | `/api/production-order/delete/{id}` | 删除生产订单 |

### 供应商接口
| 方法 | 路径 | 说明 |
|------|------|------|
| GET | `/api/supplier/list` | 供应商列表（分页 + 搜索） |
| GET | `/api/supplier/get/{id}` | 供应商详情 |
| POST | `/api/supplier/add` | 新增供应商 |
| POST | `/api/supplier/update` | 更新供应商 |
| DELETE | `/api/supplier/delete/{id}` | 删除供应商 |

### 采购订单接口
| 方法 | 路径 | 说明 |
|------|------|------|
| GET | `/api/purchase-order/list` | 订单列表（分页 + 搜索） |
| GET | `/api/purchase-order/get/{id}` | 订单详情（含明细） |
| POST | `/api/purchase-order/add` | 新增订单 |
| POST | `/api/purchase-order/update` | 更新订单 |
| DELETE | `/api/purchase-order/delete/{id}` | 删除订单 |

## 数据库表

| 表名 | 说明 | 所属模块 |
|------|------|----------|
| `customer` | 客户 | 销售管理 |
| `product` | 产品 | 销售管理 |
| `sales_order` | 销售订单 | 销售管理 |
| `sales_order_item` | 销售订单明细 | 销售管理 |
| `production_order` | 生产订单 | 生产管理 |
| `supplier` | 供应商 | 采购管理 |
| `purchase_order` | 采购订单 | 采购管理 |
| `purchase_order_item` | 采购订单明细 | 采购管理 |

## 库存联动规则

| 模块 | 操作 | 库存变化 |
|------|------|----------|
| 销售订单 | 新增/编辑 | 扣减库存（出库） |
| 销售订单 | 删除 | 恢复库存（退货） |
| 生产订单 | 完成 | 增加库存（入库） |
| 生产订单 | 取消完成 | 减少库存 |
| 采购订单 | 新增/编辑 | 增加库存（入库） |
| 采购订单 | 删除 | 减少库存（退库） |

## 注意事项

1. 确保 MySQL 服务已启动
2. 确保数据库连接配置正确
3. 新模块的数据库表需要手动执行 DDL（或通过 schema.sql 初始化）
4. 先启动后端，再启动前端
5. 前端默认端口 8081，后端默认端口 8080
