import axios from 'axios'

const request = axios.create({
  baseURL: 'http://localhost:9090', // 和 IDEA 里后端的端口一致！
  timeout: 10000
})

request.interceptors.response.use(res => res.data)

export default request