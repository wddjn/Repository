<script setup>
import { ref, onMounted } from 'vue'
import request from '@/utils/request'

// 后端返回的是 { id: xxx, username: "张三" } 格式
const nameList = ref([])
const inputName = ref('')

// 从后端加载列表
const loadNames = async () => {
  const data = await request.get('/name')
  nameList.value = data
}

// 添加（调用后端）
function addName() {
  if (!inputName.value.trim()) {
    alert('请输入名字')
    return
  }
  request.post('/name', {
    username: inputName.value.trim()
  }).then(() => {
    inputName.value = ''
    loadNames()
  })
}

// 删除
function removeName(item) {
  request.delete(`/name/${item.id}`).then(() => {
    loadNames()
  })
}

// 修改
function editName(item) {
  const newName = prompt('修改名字', item.username)
  if (newName?.trim()) {
    item.username = newName.trim()
    request.put(`/name/${item.id}`, item).then(() => {
      loadNames()
    })
  }
}

// 清空全部
function clearAll() {
  if (confirm('确定清空？')) {
    nameList.value.forEach(item => {
      request.delete(`/name/${item.id}`)
    })
    nameList.value = []
  }
}

// 页面加载自动获取数据
onMounted(() => {
  loadNames()
})
</script>

<template>
  <div class="name-box">
    <h2>名字清单管理</h2>
      <div class="input-row">
      <button @click="addName">添加</button>
      <button @click="clearAll">清空</button>
    </div>

    <div class="input-row">
      <input v-model="inputName" placeholder="请输入名字" @keyup.enter="addName">
    </div>

    <div class="list-box">
      <!-- 注意：这里从 index 改成了 item -->
      <div class="item" v-for="(item, i) in nameList" :key="item.id">
        第 {{ i+1 }} 名：{{ item.username }}
        <div>
          <button class="edit" @click="editName(item)">编辑</button>
          <button @click="removeName(item)">删除</button>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.name-box {width:450px;margin:40px auto}
.input-row {display:flex;gap:8px;margin-bottom:20px}
input {flex:1;padding:6px 10px}
button {padding:6px 12px;background:#456789;color:white;border:none;border-radius:4px;margin-left:4px}
.addName {flex:1;background:#42b983;color:white}
.clearAll {flex:1;background:#999;color:white}
.item {padding:10px;background:#f5f5f5;margin:6px 0;border-radius:4px;display:flex;justify-content:space-between}
.edit {background:#3b82f6}
</style>