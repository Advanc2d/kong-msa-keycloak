/* src/views/board/BoardWrite.vue */
<template>
  <div class="board-detail">
    <div class="common-left">
      <h2 class="fontColor">
        게시글 등록
      </h2>
    </div>
    <div class="board-contents">
      <input type="text" v-model="title" class="w3-input w3-border" placeholder="제목을 입력해주세요.">
      <input style="margin-top: 10px;" type="text" v-model="author" class="w3-input w3-border" placeholder="작성자를 입력해주세요." v-if="idx === undefined">
    </div>
    <div class="board-contents">
      <textarea id="" cols="30" rows="10" v-model="contents" class="w3-input w3-border" style="resize: none;">
      </textarea>
    </div>
    <div class="common-buttons">
      <button type="button" class="w3-button w3-round w3-blue-gray" v-on:click="fnSave" v-if="buttonKind == 1">등록</button>&nbsp;
      <button type="button" class="w3-button w3-round w3-blue-gray" v-on:click="fnSave" v-if="buttonKind == 2">수정</button>&nbsp;
      <button type="button" class="w3-button w3-round w3-gray" v-on:click="fnList">목록</button>
    </div>
  </div>
</template>

<script>
export default {
  data() { //변수생성
    return {
      requestBody: this.$route.query,
      idx: this.$route.query.idx,
      title: '',
      author: '',
      contents: '',
      createdAt: '',
      buttonKind: 1
    }
  },
  mounted() {
    // 먼저 실행하는 부분
    this.fnGetView()
  },
  methods: {
    // idx가 넘어왔을 경우 수정, 아닐 경우 생성
    fnGetView() {
        // buttonKind로 수정일 때와 생성일 때 버튼 글을 다르게 만들었다.
        this.buttonKind = 1;
        console.log(this.idx)
      if (this.idx !== undefined) {
        this.buttonKind = 2;
        this.$axios.get(this.$serverUrl + '/board/' + this.idx, {
          params: this.requestBody
        }).then((res) => {
          this.title = res.data.title       // 데이터를 받아와서 input v-model에 데이터를 넣어줌
          this.author = res.data.author
          this.contents = res.data.contents
          this.createdAt = res.data.createdAt
        }).catch((err) => {
          console.log(err)
        })
      }
    },
    // 게시물 목록으로 돌아가는 메서드
    fnList() {
      delete this.requestBody.idx
      this.$router.push({
        path: './list',
        query: this.requestBody
      })
    },
    // 글이 저장되고 해당 글로 이동하도록 하는 메서드
    fnView(idx) {
      this.requestBody.idx = idx
      this.$router.push({
        path: './detail',
        query: this.requestBody
      })
    },
    // 글 등록 DB에 저장
    fnSave() {
        if(this.title === "" || this.contents === "" || this.author === ""){
            if(this.title === ""){
                alert("제목을 입력하여주세요.")
                return
            } else if(this.author === ""){
                alert("작성자를 입력하여주세요.")
                return
            } else if(this.contents === ""){
                alert("내용을 입력하여주세요.")
                return
            } 
        }
      // input란이 비어있는지 확인


      let apiUrl = this.$serverUrl + '/board'
      
      this.form = {
        "idx": this.idx,
        "title": this.title,
        "contents": this.contents,
        "author": this.author
      }

      // axios를 통해 spring boot에 this.form 데이터를 보냄
      if (this.idx === undefined) {
        //INSERT
        this.$axios.post(apiUrl, this.form)
        .then((res) => {
          alert('글이 등록되었습니다.')
          this.fnView(res.data.idx)
        }).catch((err) => {
          if (err.message.indexOf('Network Error') > -1) {
            alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
          }
        })
      } else {
        //UPDATE
        this.$axios.patch(apiUrl, this.form)
        .then((res) => {
          alert('글이 수정되었습니다.')
          this.fnView(res.data.idx)
        }).catch((err) => {
          if (err.message.indexOf('Network Error') > -1) {
            alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
          }
        })
      }
    }
  }
}
</script>
<style scoped>
.fontColor{
    color: #42b983;
}
.common-left {
    padding: 8px;
    text-align: left;
}
</style>