import { createApp } from 'vue'
import App from './App.vue'

import router from './router'
// import axios from 'axios'
import 'bootstrap/dist/css/bootstrap.min.css'
// import 'bootstrap'
import './style.css'
// import * as echarts from 'echarts'


const app = createApp(App)
app.use(router)
// app.config.globalProperties.$echarts = echarts
app.mount('#app')


