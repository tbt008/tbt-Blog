<template>
  <div class="container">
    <!-- 头部 -->
    <div class="header">
      <div class="logo">
        <img src="@/images/logo.png" alt="" />
        <span>TBT音乐</span>
      </div>

      <div class="middle">
        <i class="iconfont icon-jiantou-xiangzuo"></i>
        <i class="iconfont icon-jiantou-xiangyou"></i>
        <div class="search">
          <i class="iconfont icon-sousuo"></i>
          <input type="text" placeholder="搜索" />
        </div>
        <i class="iconfont icon-mic-on"></i>
      </div>

      <div class="other">
        <div class="userInfo">
          <img src="@/images/ion.jpg" alt="a" />
          <span>金屋藏小猪</span>
        </div>
        <ul>
          <li><i class="iconfont icon-zhuti"></i></li>
          <li><i class="iconfont icon-shezhi"></i></li>
          <li><i class="iconfont icon-xinfeng"></i></li>
          <li class="vertical_bar"></li>
          <li><i class="iconfont icon-MINIMIZE"></i></li>
          <li><i class="iconfont icon-zuixiaohua"></i></li>
          <li><i class="iconfont icon-zuidahua"></i></li>
          <li><i class="iconfont icon-guanbi"></i></li>
        </ul>
      </div>
    </div>

    <!-- 渐变线条 -->
    <div class="line"></div>

    <!-- 中间 -->
    <div class="main">
      <div class="left-box">
        <ul>
          <li><span>发现音乐</span></li>
          <li><span>播客</span></li>
          <li><span>视频</span></li>
          <li><span>关注</span></li>
          <li><span>直播</span></li>
          <li><span>私人FM</span></li>
        </ul>
        <div class="my_music">
          <span>我的音乐</span>
        </div>
        <ul class="mine">
          <li><i class="iconfont icon-bendixiazai"></i><span>本地与下载</span></li>
          <li><i class="iconfont icon-zuijinbofang"></i><span>最近播放</span></li>
          <li><i class="iconfont icon-yun"></i><span>我的音乐云盘</span></li>
          <li><i class="iconfont icon-boke1"></i><span>我的播客</span></li>
          <li><i class="iconfont icon-ego-favorite"></i><span>我的收藏</span></li>
        </ul>
        <div class="create_list">
          <span>
            创建的歌单
            <i class="iconfont icon-ico_arrowright"></i>
            <i class="iconfont icon-jia i_last"></i>
          </span>
        </div>
        <div class="create_list">
          <span>
            收藏的歌单
            <i class="iconfont icon-ico_arrowright"></i>
          </span>
        </div>
      </div>
      <div class="right-box">
        <ul class="navigation">
          <li @click="setActive(index)" v-for="(router, index) in routerList" :key="index">
            <span>{{ router.name }}</span>
          </li>
        </ul>
        <div class="main-router">
          <router-view ref="child" @play="play" @changeMusic="changeMusic"></router-view>
        </div>
      </div>
    </div>

    <!-- 底部 -->
    <div class="footer">
      <div class="ft_left">
        <img class="_img" :src="this.imgUrl" alt="" />
        <div class="songNameAndSinger">
          <span class="songName">{{ this.name }}<i class="iconfont icon-aixin"></i></span>
          <span class="singer">{{ this.user }}</span>
        </div>
      </div>

      <div class="ft_main">
        <!-- 播放栏工具 -->
        <ul class="tool_list">
          <li><i class="iconfont icon-lajitong"></i></li>
          <!-- 上一首 -->
          <li><i @click="prev()" class="iconfont icon-shangyishoushangyige"></i></li>
          <!-- 暂停按钮 -->
          <li @click="on_off">
            <i
              v-bind:class="{ 'icon-bofang': isbofang, 'icon-zanting': iszanting }"
              class="iconfont _audio"
            ></i>
            <!-- <audio
              @timeupdate="timeUpdate"
              ref="audio"
              id="ado"
              :src="src"
              :controls="controls"
              :loop="loop"
              :volume="volume"
            ></audio> -->
          </li>
          <!-- 下一首 -->
          <li><i @click="next()" class="iconfont icon-xiayigexiayishou"></i></li>
          <!-- 歌词 -->
          <li><i class="iconfont icon-geciweidianji"></i></li>
        </ul>
        <!-- 进度条 -->
        <div class="progress" @click="mouseClick">
          <div @touchstart="touchstart" @mousedown="mousedown" class="slide"></div>
          <div class="fill"></div>
          <!--歌曲当前时间与总时间  -->
          <span class="currentTime time">00:00</span>
          <span ref="duraTime" class="duraTime time">00:00</span>
        </div>
      </div>

      <ul class="ft_right">
        <li class="jigao">极高</li>
        <li class="iconfont icon-yinxiao"></li>
        <!-- 音量 -->
        <div style="display: flex; align-items: center">
          <el-popover placement="right" :width="5" :hide-after="100" trigger="click">
            <template #reference>
              <li class="iconfont icon-yinliangkai _voice"></li>
            </template>

            <el-slider v-model="value" vertical height="100px" />
          </el-popover>
        </div>

        <li class="iconfont icon-yiqipindan"></li>
        <li class="iconfont icon-24gl-playlistMusic"></li>
      </ul>
    </div>
  </div>
  <BlogFooter></BlogFooter>
</template>
<!-- this.$refs.audio.src = new URL('@/audio/起风了.mp3', import.meta.url).href -->
<script>
import axios from 'axios'
import BlogFooter from '@/components/BlogFooter.vue'
export default {
  data() {
    return {
      controls: false,
      loop: true,
      volume: 1,
      index: 0,
      value: 100,
      iszanting: false,
      isbofang: true,
      user: '李健',
      name: '贝加尔湖畔',
      src: new URL('@/audio/贝加尔湖畔.mp3', import.meta.url).href,
      imgUrl:
        'https://tbt-blog.oss-cn-beijing.aliyuncs.com/%E8%B4%9D%E5%8A%A0%E5%B0%94%E6%B9%96%E7%95%94.jpg',
      musicList: [],
      routerList: [
        { name: '个性推荐', url: '/music/discover' },
        { name: '专属定制', url: '/music/exclusive' },
        { name: '歌单', url: '/music/songList' },
        { name: '排行榜', url: '/music/topList' },
        { name: '歌手', url: '/music/singer' },
        { name: '最新音乐', url: '/music/newest' }
      ]
    }
  },
  methods: {
    //  播放开始与暂停以及相关的图标字体修改
    on_off() {
      const audio = document.getElementById('ado')
      // const audio = this.$refs.audio
      // console.log(audio)
      if (audio.paused) {
        audio.play()
        this.iszanting = true
        this.isbofang = false
      } else {
        audio.pause()
        this.isbofang = true
        this.iszanting = false
      }
    },

    play(music) {
      this.iszanting = true
      this.isbofang = false
      const audio = document.getElementById('ado')
      audio.src = music.src
      this.name = music.name
      this.user = music.user
      this.imgUrl = music.img
      localStorage.setItem('user', this.user)
      localStorage.setItem('name', this.name)
      localStorage.setItem('img', this.imgUrl)
      localStorage.setItem('src', audio.src)
      audio.play()
    },
    prev() {
      this.iszanting = true
      this.isbofang = false
      if (this.index > 0) {
        this.index = this.index - 1
        const music = this.musicList[this.index]
        const audio = document.getElementById('ado')
        audio.src = music.src
        this.name = music.name
        this.user = music.user
        this.imgUrl = music.img
        localStorage.setItem('user', this.user)
        localStorage.setItem('name', this.name)
        localStorage.setItem('img', this.imgUrl)
        localStorage.setItem('src', audio.src)
      }
      audio.play()
    },
    next() {
      this.iszanting = true
      this.isbofang = false
      const audio = document.getElementById('ado')
      if (this.index < this.musicList.length) {
        this.index = this.index + 1
        const music = this.musicList[this.index]
        audio.src = music.src
        this.name = music.name
        this.user = music.user
        this.imgUrl = music.img
        localStorage.setItem('user', this.user)
        localStorage.setItem('name', this.name)
        localStorage.setItem('img', this.imgUrl)
        localStorage.setItem('src', audio.src)
      }
      audio.play()
    },
    changeMusic(index) {
      this.iszanting = true
      this.isbofang = false
      this.index = index
      const audio = document.getElementById('ado')
      if (index == 0) {
        audio.src = new URL('@/audio/贝加尔湖畔.mp3', import.meta.url).href
        this.name = '贝加尔湖畔'
        this.user = '李健'
        this.imgUrl =
          'https://tbt-blog.oss-cn-beijing.aliyuncs.com/%E8%B4%9D%E5%8A%A0%E5%B0%94%E6%B9%96%E7%95%94.jpg'
        localStorage.setItem('user', this.user)
        localStorage.setItem('name', this.name)
        localStorage.setItem('img', this.imgUrl)
        localStorage.setItem('src', audio.src)
      } else if (index == 1) {
        audio.src = new URL('@/audio/起风了.mp3', import.meta.url).href
        this.name = '起风了'
        this.user = '买辣椒也用券'
        this.imgUrl = 'https://tbt-blog.oss-cn-beijing.aliyuncs.com/%E8%B5%B7%E9%A3%8E%E4%BA%86.jpg'
        localStorage.setItem('user', this.user)
        localStorage.setItem('name', this.name)
        localStorage.setItem('img', this.imgUrl)
        localStorage.setItem('src', audio.src)
      } else if (index == 2) {
        audio.src = new URL('@/audio/追梦赤子心.mp3', import.meta.url).href
        this.name = '追梦赤子心'
        this.user = 'GALA'
        this.imgUrl =
          'https://tbt-blog.oss-cn-beijing.aliyuncs.com/%E8%BF%BD%E6%A2%A6%E8%B5%A4%E5%AD%90%E5%BF%83.jpg'
        localStorage.setItem('user', this.user)
        localStorage.setItem('name', this.name)
        localStorage.setItem('img', this.imgUrl)
        localStorage.setItem('src', audio.src)
      } else if (index == 3) {
        audio.src = new URL('@/audio/PLANET.mp3', import.meta.url).href
        this.name = 'PLANET'
        this.user = 'ラムジ'
        this.imgUrl = 'https://tbt-blog.oss-cn-beijing.aliyuncs.com/PLANET.jpg'
        localStorage.setItem('user', this.user)
        localStorage.setItem('name', this.name)
        localStorage.setItem('img', this.imgUrl)
        localStorage.setItem('src', audio.src)
      }

      audio.play()
    },
    // 时长进度条
    timeUpdate() {
      const audio = document.getElementById('ado')
      // 时长进度条
      const slide = document.querySelector('.slide')
      const fill = document.querySelector('.fill')
      console.log(audio.currentTime)
      let l = (audio.currentTime / audio.duration) * 100
      slide.style.left = l + '%'
      fill.style.width = l + '%'
      if (audio.currentTime == 0) {
        slide.style.left = '0%'
      }
      const currentTime = document.querySelector('.currentTime')
      currentTime.innerHTML = transTime(parseInt(audio.currentTime))
      const duraTime = document.querySelector('.duraTime')
      duraTime.innerHTML = transTime(audio.duration)
    },
    mousedown(e) {
      const progress = document.querySelector('.progress')
      const slide = document.querySelector('.slide')
      const audio = document.getElementById('ado')
      let x = e.clientX - slide.offsetLeft

      ;(document.onmousemove = function (e) {
        let jlx = ((e.clientX - x) / progress.clientWidth) * 100
        if (jlx <= 100 && jlx >= 0) {
          slide.style.left = jlx + '%'
        }
        const time = (jlx / 100) * audio.duration
        audio.currentTime = time
      }),
        (document.onmouseup = function () {
          document.onmousemove = null
          document.onmouseup = null
        })
    },
    mouseClick(e) {
      const progress = document.querySelector('.progress')
      const slide = document.querySelector('.slide')
      const audio = document.getElementById('ado')
      let x = e.clientX - progress.getBoundingClientRect().left

      let jlx = (x / progress.clientWidth) * 100
      if (jlx <= 100 && jlx >= 0) {
        slide.style.left = jlx + '%'
      }
      const time = (jlx / 100) * audio.duration
      audio.currentTime = time
    },
    setActive(i) {
      // alert(i)
      const items = document.querySelectorAll('.navigation li')
      items.forEach((items) => {
        items.classList.remove('active')
      })
      items[i].classList.add('active')
      //  路由
      this.$router.push(this.routerList[i].url)
    }
  },
  watch: {
    // 如果 `question` 发生改变，这个函数就会运行

    value: function (newvalue, oldvalue) {
      const audio = document.getElementById('ado')
      audio.volume = this.value / 100

      const voice = document.querySelector('._voice')
      if (audio.volume > 0) {
        voice.classList.remove('icon-yinliangguanbi')
        voice.classList.add('icon-yinliangkai')
      } else {
        voice.classList.remove('icon-yinliangkai')
        voice.classList.add('icon-yinliangguanbi')
      }
    }
  },
  components: {
    BlogFooter
  },
  mounted() {
    const res = axios.get('http://localhost:9090/music/get').then((res) => {
      this.musicList = res.data.data
    })

    const items = document.querySelectorAll('.navigation li')
    items[0].classList.add('active')
    this.$router.push('/music/discover')
    // localStorage.setItem('slide_left', now.left - domLeft)
    const user = localStorage.getItem('user')
    const name = localStorage.getItem('name')
    const img = localStorage.getItem('img')
    const src = localStorage.getItem('src')
    const audio = document.getElementById('ado')
    if (user != null && name != null && img != null && src != null) {
      this.user = user
      this.name = name
      this.imgUrl = img
    }

    if (!audio.paused) {
      this.iszanting = true
      this.isbofang = false
    } else {
      this.iszanting = false
      this.isbofang = true
      if (src != null) {
        audio.src = src
      }
    }
  }
}
function transTime(time) {
  let duration = parseInt(time)
  let minute = parseInt(duration / 60)
  let sec = (duration % 60) + ''
  let isM0 = ':'
  if (minute == 0) {
    minute = '00'
  } else if (minute < 10) {
    minute = '0' + minute
  }
  if (sec.length == 1) {
    sec = '0' + sec
  }
  return minute + isM0 + sec
}
</script>
<style scoped>
@import '@/css/font_footer.css';
@import '@/css/font_header.css';
@import '@/css/font_leftBox.css';
@import '@/css/main.css';
</style>
