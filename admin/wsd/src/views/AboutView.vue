<template>
  <div class="card">
    <h2 class="title">ℹ️ 关于</h2>
    <p class="desc">这是一个用于学习 Vue3 + VueRouter 的基础项目</p>

    <div class="info-box">
      <p><strong>技术栈：</strong>Vue3、Vite、VueRouter</p>
      <p><strong>UI风格：</strong>简约现代、卡片化、响应式</p>
      <p><strong>说明：</strong>所有页面样式统一，导航高亮正常</p>
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

.info-box {
  background: #f9fafb;
  border-radius: 8px;
  padding: 20px;
}

.info-box p {
  margin: 8px 0;
  color: #444;
}
</style>