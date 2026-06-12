import axios from 'axios'

const request = axios.create({
  baseURL: 'http://localhost:9090', // 后端地址，必须和端口一致
  timeout: 10000
})

// 响应拦截器：直接返回 data，前端不用每次写 res.data
request.interceptors.response.use(
  res => res.data,
  err => {
    console.error('请求错误：', err)
    return Promise.reject(err)
  }
)

export default request