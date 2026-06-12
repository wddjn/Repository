<template>
  <div class="card">
    <h2 class="title">🏠 首页</h2>
    <p class="desc">欢迎来到 Vue3 + VueRouter 示例项目</p>

    <div class="feature-list">
      <div class="feature-item">
        <h4>📌 功能演示</h4>
        <p>路由切换、导航高亮、页面布局</p>
      </div>
      <div class="feature-item">
        <h4>🎨 样式统一</h4>
        <p>卡片、阴影、圆角、间距统一风格</p>
      </div>
    </div>
  </div>
</template>

<script setup></script>

<style scoped>
.card {
  background: #fff;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.08);
  padding: 30px;
  max-width: 600px;
  margin: 0 auto;
}

.title {
  font-size: 26px;
  color: #333;
  margin-bottom: 10px;
}

.desc {
  color: #666;
  margin-bottom: 24px;
}

.feature-list {
  display: flex;
  gap: 16px;
  flex-wrap: wrap;
}

.feature-item {
  flex: 1;
  min-width: 220px;
  background: #f9fafb;
  border-radius: 8px;
  padding: 16px;
}

.feature-item h4 {
  margin: 0 0 8px;
  color: #333;
}

.feature-item p {
  margin: 0;
  color: #555;
}
</style>