<template>
  <div class="musicList">
    <el-scrollbar height="500px">
      <div class="top-title">
        <span class="title">序号</span>
        <span class="title">歌名</span>
        <span class="title">歌手</span>
      </div>
      <div @dblclick="play(music)" class="music" v-for="music in musicList" :key="music.id">
        <span class="music-example">{{ music.id }}</span>
        <span class="music-example">{{ music.name }}</span>
        <span class="music-example">{{ music.user }}</span>
        <i @click="play(music)" class="iconfont icon-add"></i>
      </div>
    </el-scrollbar>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data() {
    return {
      musicList: []
    }
  },
  methods: {
    play(music) {
      this.$emit('play', music)
    }
  },
  mounted() {
    // .get('http://localhost:9090/music/get')
    const res = axios.get('http://localhost:9090/music/get').then((res) => {
      // console.log(res.data.data)
      this.musicList = res.data.data
    })
  }
}
</script>

<style>
@media only screen and (max-width: 374px) {
  .musicList {
    display: block;
    height: 500px;
  }
  .title {
    display: block;
    width: 50%;
    color: aliceblue;
    font-size: small;
  }
  .music-example {
    display: block;
    width: 50%;
    font-size: 15px;
    margin-right: 10px;
    width: 5em; /*保证文字不会被半汉字截断,显示10个文字  */
    overflow: hidden; /*超出长度的文字隐藏*/
    text-overflow: ellipsis; /*文字隐藏以后添加省略号*/
    white-space: nowrap; /*强制不换行*/
    color: rgb(202, 202, 202);
  }
  .top-title {
    display: flex;
    /* justify-content: space-around; */
  }
  .icon-add:before {
    content: '\e612';
  }
  .iconfont {
    font-family: 'iconfont' !important;
    font-size: 20px;
    color: aliceblue;
    font-style: normal;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
  }
  i:hover {
    color: rgb(24, 24, 24);
  }
  .music {
    display: flex;
    height: 50px;
    line-height: 50px;
    padding-left: 10px;
    padding-right: 10px;
    /* background-color: rgb(67, 67, 67); */
    /* justify-content: space-around; */
  }
  .music:hover {
    /* background-color: rgb(113, 113, 113); */
    background-color: rgb(162, 160, 160, 0.5);
  }
}

@media only screen and (min-width: 414px) {
  .musicList {
    display: block;
    height: 500px;
  }
  .title {
    display: block;
    width: 50%;
    color: aliceblue;
    font-size: small;
  }
  .music-example {
    display: block;
    width: 50%;
    color: rgb(202, 202, 202);
    /* text-align: center; */
  }
  .top-title {
    display: flex;
    /* justify-content: space-around; */
  }
  .icon-add:before {
    content: '\e612';
  }
  .iconfont {
    font-family: 'iconfont' !important;
    font-size: 25px;
    color: aliceblue;
    font-style: normal;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
  }
  i:hover {
    color: rgb(24, 24, 24);
  }
  .music {
    display: flex;
    height: 50px;
    line-height: 50px;
    padding-left: 10px;
    padding-right: 10px;
    /* background-color: rgb(67, 67, 67); */
    /* justify-content: space-around; */
  }
  .music:hover {
    /* background-color: rgb(113, 113, 113); */
    background-color: rgb(162, 160, 160, 0.5);
  }
}
</style>
