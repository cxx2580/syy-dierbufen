# 快速启动指南

## 前置要求

- JDK 8+
- Maven 3.6+
- Node.js 14+
- MySQL 5.7+

## 快速启动步骤

### 第一步：初始化数据库

1. 启动MySQL服务
2. 使用MySQL客户端连接到数据库
3. 执行以下命令或直接运行 `erp-backend/src/main/resources/schema.sql` 文件：

```sql
-- 如果使用命令行
mysql -u root -p
-- 然后复制粘贴 schema.sql 的内容执行
```

### 第二步：配置后端

修改 `erp-backend/src/main/resources/application.yml` 中的数据库用户名和密码：

```yaml
spring:
  datasource:
    username: root      # 改成你的MySQL用户名
    password: your_password  # 改成你的MySQL密码
```

### 第三步：启动后端

打开终端1：

```bash
cd erp-backend
mvn spring-boot:run
```

等待看到 "Started ErpApplication" 表示启动成功，后端运行在 http://localhost:8080

### 第四步：启动前端

打开终端2：

```bash
cd erp-frontend
npm install
npm run serve
```

等待看到 "Compiled successfully" 表示启动成功，前端运行在 http://localhost:8081

### 第五步：访问系统

在浏览器中打开：http://localhost:8081

## 功能测试

### 1. 客户管理测试

- 点击左侧菜单"客户管理"
- 查看预置的3个客户
- 点击"新增客户"添加一个新客户
- 点击"编辑"修改客户信息
- 点击"删除"删除客户
- 使用搜索框搜索客户

### 2. 产品管理测试

- 点击左侧菜单"产品管理"
- 查看预置的4个产品
- 点击"新增产品"添加一个新产品
- 点击"编辑"修改产品信息
- 点击"删除"删除产品
- 使用搜索框搜索产品

### 3. 销售订单测试

- 点击左侧菜单"销售订单"
- 点击"新增订单"创建订单
  - 选择客户
  - 添加产品明细（点击"添加产品"）
  - 填写备注
  - 点击"确定"
- 点击"查看"查看订单详情
- 点击"编辑"修改订单
- 点击"删除"删除订单
- 使用搜索框搜索订单

## 常见问题

### Q: 后端启动报错"Communications link failure"
A: 检查MySQL服务是否启动，数据库连接配置是否正确

### Q: 前端启动报错"npm: command not found"
A: 请先安装Node.js

### Q: 前端页面显示空白
A: 确保后端服务已启动，检查浏览器控制台是否有错误信息

### Q: 端口被占用怎么办？
A: 
- 后端：修改 application.yml 中的 server.port
- 前端：使用 npm run serve -- --port 8082 启动

## 系统架构说明

### 后端架构
- Controller层：接收HTTP请求
- Service层：业务逻辑处理
- Mapper层：数据库操作
- Entity层：数据实体

### 前端架构
- Vue组件化开发
- Element UI组件库
- Axios进行HTTP通信
- Vue Router路由管理

## 数据库表结构

### customer（客户表）
- id: 客户ID（主键）
- customer_no: 客户编号
- customer_name: 客户名称
- contact: 联系人
- phone: 联系电话
- email: 邮箱
- address: 地址
- status: 状态

### product（产品表）
- id: 产品ID（主键）
- product_no: 产品编号
- product_name: 产品名称
- specification: 规格
- unit: 单位
- price: 单价
- stock: 库存
- status: 状态

### sales_order（销售订单表）
- id: 订单ID（主键）
- order_no: 订单编号
- customer_id: 客户ID
- customer_name: 客户名称
- total_amount: 总金额
- status: 订单状态
- remark: 备注

### sales_order_item（销售订单明细表）
- id: 明细ID（主键）
- order_id: 订单ID（外键）
- product_id: 产品ID
- product_name: 产品名称
- specification: 规格
- unit: 单位
- price: 单价
- quantity: 数量
- subtotal: 小计
