<script setup>
import { ref, onMounted } from 'vue'
// 引入 axios 请求工具
import request from '@/utils/request'

// 数据列表（从后端拿，不是本地存储）
const todoList = ref([])
const newTodo = ref('')

// ========== 从后端加载所有待办 ==========
const getTodoList = async () => {
  todoList.value = await request.get('/todo')
}

// ========== 添加 ==========
function addTodo() {
  if (!newTodo.value.trim()) {
    alert('请输入内容！')
    return
  }
  // 调用后端新增接口
  request.post('/todo', {
    text: newTodo.value,
    done: false
  }).then(() => {
    newTodo.value = ''
    getTodoList() // 刷新列表
  })
}

// ========== 删除 ==========
function deleteTodo(id) {
  request.delete(`/todo/${id}`).then(() => {
    getTodoList() // 刷新列表
  })
}

// ========== 修改内容 ==========
function editTodo(item) {
  const t = prompt('修改内容', item.text)
  if (t?.trim()) {
    item.text = t.trim()
    request.put(`/todo/${item.id}`, item).then(() => {
      getTodoList()
    })
  }
}

// ========== 切换完成状态 ==========
function toggleDone(item) {
  item.done = !item.done
  request.put(`/todo/${item.id}`, item)
}

// ========== 清空所有 ==========
function clearAll() {
  if (confirm('确定清空所有？')) {
    // 逐条删除（简单版）
    todoList.value.forEach(item => {
      request.delete(`/todo/${item.id}`)
    })
    todoList.value = []
  }
}

// 页面加载时自动从后端获取数据
onMounted(() => {
  getTodoList()
})
</script>

<template>
  <div class="card">
    <h2 class="title">📝 待办事项管理</h2>
    <p class="subtitle">实现增删改查 & 状态管理</p>
   <div class="input-group">
      <button class="btn add" @click="addTodo">添加</button>
      <button class="btn clear" @click="clearAll">清空</button>
    </div>
    <div class="input-group">
      <input v-model="newTodo" placeholder="请输入待办内容" @keyup.enter="addTodo" />
    </div>

    <div class="list">
      <div class="item" v-for="item in todoList" :key="item.id">
        <span :class="{ done: item.done }" @click="toggleDone(item)">{{ item.text }}</span>
        <div class="btns">
          <button class="btn edit" @click="editTodo(item)">修改</button>
          <button class="btn del" @click="deleteTodo(item.id)">删除</button>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.card {max-width:600px;margin:0 auto;background:#fff;border-radius:16px;padding:35px;box-shadow:0 8px 24px rgba(0,0,0,0.08)}
.title {font-size:26px;color:#222;margin:0 0 6px;text-align:center}
.subtitle {text-align:center;color:#666;margin-bottom:30px}
.input-group {display:flex;gap:10px;margin-bottom:30px}
input {flex:1;padding:12px 16px;border:1px solid #eee;border-radius:8px;font-size:15px;outline:none}
input:focus {border-color:#42b983}
.btn {padding:12px 18px;border:none;border-radius:8px;cursor:pointer}
.btn.add {flex:1;background:#42b983;color:white}
.btn.clear {flex:1;background:#999;color:white}
.btn.edit {background:#3b82f6;color:white}
.btn.del {background:#ef4444;color:white}
.list {display:flex;flex-direction:column;gap:10px}
.item {display:flex;justify-content:space-between;align-items:center;padding:14px;background:#f9fafb;border-radius:10px}
.btns {display:flex;gap:8px}
.done {text-decoration:line-through;color:#999}
</style>