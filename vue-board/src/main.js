/* src/main.js */
import '@/assets/common.css'
// common.css 파일을 읽을 수 있게 main.js에 import

import { createApp } from 'vue'
import App from './App.vue'
// import App from './App' 사용가능 .vue 생략가능 
import router from './router'
// router를 export한 것을 쓰기 위해 import
import axios from 'axios'
// 서버와 통신을 위한 axios import

const app = createApp(App)
app.config.globalProperties.$axios = axios; 
//전역변수로 설정 컴포넌트에서 this.$axios 호출할 수 있음
app.config.globalProperties.$serverUrl = '//localhost:7003' 
//backend server
app.use(router).mount('#app')
// App.vue를 정의한 후 그 안에서 router를 사용하겠다는 정의
