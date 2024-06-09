<template>
  <div class="banner">
    <div class="infomation">
      <!-- <h4>M♭</h4> -->
      <p>
        <!-- &nbsp;&nbsp;&nbsp;&nbsp;M♭是TV动画《路人女主的养成方法》03话14:51时的插曲，同时也是加藤惠的角色歌，收录在同名角色歌专辑中（冴えない彼女の育てかたキャラクターイメージソング加藤恵）。由其声优：安野希世乃演唱。 -->
      </p>
      <div class="btn_listen btn_listen_1">
        <span>点击试听</span>
      </div>
      <div class="btn_listen btn_listen_2">
        <span>点击收藏</span>
      </div>
    </div>
    <img src="@/images/加藤惠.jpg" alt="" />
  </div>
  <!-- 小圆点 -->
  <div class="dot">
    <ul class="dots">
      <li></li>
      <li></li>
      <li></li>
      <li></li>
      <li></li>
      <li></li>
      <li></li>
      <li></li>
      <li></li>
      <li></li>
    </ul>
  </div>
  <div class="recm_list">
    <div class="recm_word">推荐歌曲<i class="iconfont icon-jiantou-xiangyou"></i></div>
    <ul>
      <li @click="changeMusic(index)" v-for="(music, index) in musicList" :key="index">
        <img :src="music.url" alt="" />
        <span>{{ music.name }}<br />{{ music.user }}</span>
      </li>
    </ul>
  </div>
</template>
<script>
export default {
  data() {
    return {
      musicList: [
        {
          url: 'https://tbt-blog.oss-cn-beijing.aliyuncs.com/%E8%B4%9D%E5%8A%A0%E5%B0%94%E6%B9%96%E7%95%94.jpg',
          name: '贝加尔湖畔',
          user: '李健'
        },
        {
          url: 'https://tbt-blog.oss-cn-beijing.aliyuncs.com/%E8%B5%B7%E9%A3%8E%E4%BA%86.jpg',
          name: '起风了',
          user: '买辣椒也用券'
        },
        {
          url: 'https://tbt-blog.oss-cn-beijing.aliyuncs.com/%E8%BF%BD%E6%A2%A6%E8%B5%A4%E5%AD%90%E5%BF%83.jpg',
          name: '追梦赤子心',
          user: 'GALA'
        },
        {
          url: 'https://tbt-blog.oss-cn-beijing.aliyuncs.com/PLANET.jpg',
          name: 'PLANET',
          user: 'ラムジ'
        }
      ]
    }
  },
  methods: {
    changeMusic(index) {
      this.$emit('changeMusic', index)
    }
  }
}
</script>
<style>
@import '@/css/main.css';
</style>
