<template>
  <div id="app">
    <el-container>
      <el-header style="background-color: #409EFF; color: white;">
        <h1 style="margin: 0; line-height: 60px;">简易ERP系统</h1>
      </el-header>
      <el-container>
        <el-aside width="200px" style="background-color: #f5f7fa;">
          <el-menu
            :default-active="$route.path"
            router
            background-color="#f5f7fa"
            text-color="#333"
            active-text-color="#409EFF">
            <el-menu-item index="/customer">
              <i class="el-icon-user"></i>
              <span>客户管理</span>
            </el-menu-item>
            <el-menu-item index="/product">
              <i class="el-icon-goods"></i>
              <span>产品管理</span>
            </el-menu-item>
            <el-menu-item index="/sales-order">
              <i class="el-icon-document"></i>
              <span>销售订单</span>
            </el-menu-item>
            <el-menu-item index="/production">
              <i class="el-icon-s-operation"></i>
              <span>生产管理</span>
            </el-menu-item>
          </el-menu>
        </el-aside>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
#app {
  font-family: 'Microsoft YaHei', Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  height: 100vh;
}
.el-header {
  padding: 0 20px;
}
.el-main {
  padding: 20px;
}
</style>
