<!-- App.vue -->
<template>
  <MainHeader/> <!-- 헤더 컴포넌트 -->
  <router-view/>  <!-- 페이지 이동이 표시될 곳 -->
  <MainFooter/> <!-- 푸터 컴포넌트 -->
</template>

<script>
import MainHeader from '@/components/MainHeader'
import MainFooter from '@/components/MainFooter'
// header, footer를 import해서 사용

export default {
  name: 'App',
  components: {
    MainFooter,
    MainHeader
  }
// components를 vue에서 사용하기 위해 정의
}
</script>

<style>
html,body{padding:0; margin:0;}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin:0; padding:0;
}
</style>