<!-- MainHome.vue -->
<template>
  <div class="home">
    <HelloWorld msg="메인 화면입니다."/>
    <!-- msg를 하위 components인 HelloWorld로 내려서 사용할 수 있다. -->
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name:'MainHome',
  components: {
    HelloWorld
  }
}
</script>