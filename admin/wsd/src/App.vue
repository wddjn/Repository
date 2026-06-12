<script setup>
import { RouterView, RouterLink } from 'vue-router'
</script>

<template>
  <div class="app-container">
    <!-- 导航栏 -->
    <nav class="navbar">
      <RouterLink to="/" class="nav-link">首页</RouterLink>
      <RouterLink to="/about" class="nav-link">关于</RouterLink>
      <RouterLink to="/wsd" class="nav-link">增删改查</RouterLink>
      <RouterLink to="/wsdd" class="nav-link">自定义</RouterLink>
      <RouterLink to="/jipiaoyuding" class="nav-link">机票预定</RouterLink>
    </nav>

    <!-- 页面出口 -->
    <div class="page-content">
      <RouterView />
    </div>
  </div>
</template>

<style scoped>
.app-container {
  min-height: 100vh;
  background-color: #f5f7fa;
}

/* 导航栏整体 */
.navbar {
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #fff;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.08);
  padding: 12px 0;
  gap: 20px;
}

/* 导航链接默认样式 */
.nav-link {
  text-decoration: none;
  color: #333;
  font-size: 16px;
  padding: 8px 16px;
  border-radius: 6px;
  transition: all 0.3s ease;
}

/* hover 效果 */
.nav-link:hover {
  background-color: #eef2ff;
  color: #42b983;
}

/* 当前选中路由高亮（关键！统一绿色） */
.nav-link.router-link-exact-active {
  background-color: #42b983;
  color: #fff;
  font-weight: bold;
}

.page-content {
  padding: 30px;
}
</style>