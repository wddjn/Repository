<script setup>
import { ref, onMounted } from 'vue'
import request from '@/utils/request'

const flightList = ref([])
const newFlight = ref({ start: '', end: '', time: '', price: '' })

// 从后端加载航班列表
const loadFlightList = async () => {
  flightList.value = await request.get('/flight')
}

// 添加（接口）
function addFlight() {
  if (!newFlight.value.start || !newFlight.value.end) {
    alert('请填写完整信息')
    return
  }
  request.post('/flight', newFlight.value).then(() => {
    newFlight.value = { start: '', end: '', time: '', price: '' }
    loadFlightList()
  })
}

// 删除（接口）
function deleteFlight(id) {
  request.delete(`/flight/${id}`).then(() => {
    loadFlightList()
  })
}

// 修改（接口）
function editFlight(item) {
  const s = prompt('出发地', item.start)
  const e = prompt('目的地', item.end)
  const t = prompt('时间', item.time)
  const p = prompt('价格', item.price)
  if (s && e) {
    item.start = s
    item.end = e
    item.time = t
    item.price = p
    request.put(`/flight/${item.id}`, item).then(() => {
      loadFlightList()
    })
  }
}

// 清空所有
function clearAll() {
  if (confirm('确定清空所有航班？')) {
    flightList.value.forEach(item => {
      request.delete(`/flight/${item.id}`)
    })
    flightList.value = []
  }
}

// 页面加载自动获取数据
onMounted(() => {
  loadFlightList()
})
</script>

<template>
  <div class="card">
    <h2 class="title">✈️ 机票预订系统</h2>
    <p class="subtitle">新增 / 删除 / 修改 / 保存</p>
    <div class="form-box">
      <button class="add-btn" @click="addFlight">添加</button>
      <button class="clear-btn" @click="clearAll">清空</button>
    </div>

    <div class="form-box">
      <input v-model="newFlight.start" placeholder="出发地" />
      <input v-model="newFlight.end" placeholder="目的地" />
      <input v-model="newFlight.time" placeholder="起飞时间" />
      <input v-model="newFlight.price" placeholder="价格" />
    </div>

    <div class="list">
      <div class="item" v-for="item in flightList" :key="item.id">
        <div class="info">
          <span>{{ item.start }} → {{ item.end }}</span>
          <span>时间：{{ item.time }}</span>
          <span class="price">¥{{ item.price }}</span>
        </div>
        <div>
          <button class="edit-btn" @click="editFlight(item)">编辑</button>
          <button class="del-btn" @click="deleteFlight(item.id)">删除</button>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.card {max-width:700px;margin:0 auto;background:#fff;border-radius:16px;padding:35px;box-shadow:0 8px 24px rgba(0,0,0,0.08)}
.title {font-size:26px;text-align:center;margin:0 0 6px}
.subtitle {text-align:center;color:#666;margin-bottom:30px}
.form-box {display: grid;grid-template-columns: 1fr 1fr;gap: 10px;margin-bottom: 30px;}
.form-box input {flex:1;min-width:120px;padding:12px 14px;border:1px solid #eee;border-radius:8px}
.add-btn {flex:1;background:#42b983;color:white;border:none;padding:12px;border-radius:8px;cursor:pointer}
.clear-btn {flex:1;background:#999;color:white;border:none;padding:12px;border-radius:8px;cursor:pointer}
.list {display:flex;flex-direction:column;gap:10px}
.item {display:flex;justify-content:space-between;align-items:center;padding:16px;background:#f9fafb;border-radius:10px}
.info {display:flex;flex-direction:column;gap:4px}
.price {color:#ef4444;font-weight:bold}
.del-btn {padding:8px 12px;background:#ef4444;color:white;border:none;border-radius:6px;margin-left:4px}
.edit-btn {padding:8px 12px;background:#3b82f6;color:white;border:none;border-radius:6px}
</style>