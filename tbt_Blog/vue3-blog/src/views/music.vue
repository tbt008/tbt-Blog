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
          <li class="active"><span>个性推荐</span></li>
          <li><span>专属定制</span></li>
          <li><span>歌单</span></li>
          <li><span>排行榜</span></li>
          <li><span>歌手</span></li>
          <li><span>最新音乐</span></li>
        </ul>
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
          <li><i @click="prev(this.index)" class="iconfont icon-shangyishoushangyige"></i></li>
          <!-- 暂停按钮 -->
          <li @click="on_off">
            <i
              v-bind:class="{ 'icon-bofang': isbofang, 'icon-zanting': iszanting }"
              class="iconfont _audio"
            ></i>
            <audio
              @timeupdate="timeUpdate"
              ref="audio"
              id="ado"
              :src="src"
              :controls="controls"
              :loop="loop"
              :volume="volume"
            ></audio>
          </li>
          <!-- 下一首 -->
          <li><i @click="next(this.index)" class="iconfont icon-xiayigexiayishou"></i></li>
          <!-- 歌词 -->
          <li><i class="iconfont icon-geciweidianji"></i></li>
        </ul>
        <!-- 进度条 -->
        <div class="progress">
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
</template>

<script>
export default {
  data() {
    return {
      src: new URL('@/audio/贝加尔湖畔.mp3', import.meta.url).href,
      controls: false,
      loop: true,
      volume: 1,
      index: 0,
      value: 100,
      iszanting: false,
      isbofang: true,
      user: '李健',
      name: '贝加尔湖畔',
      imgUrl:
        'https://tbt-blog.oss-cn-beijing.aliyuncs.com/%E8%B4%9D%E5%8A%A0%E5%B0%94%E6%B9%96%E7%95%94.jpg',
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
    //  播放开始与暂停以及相关的图标字体修改
    on_off() {
      const audio = this.$refs.audio
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

    //   // 格式化时间格式

    prev(index) {
      this.iszanting = true
      this.isbofang = false
      if (index == 1) {
        this.$refs.audio.src = new URL('@/audio/贝加尔湖畔.mp3', import.meta.url).href
        this.name = '贝加尔湖畔'
        this.user = '李健'
        this.imgUrl =
          'https://tbt-blog.oss-cn-beijing.aliyuncs.com/%E8%B4%9D%E5%8A%A0%E5%B0%94%E6%B9%96%E7%95%94.jpg'
      } else if (index == 2) {
        this.$refs.audio.src = new URL('@/audio/起风了.mp3', import.meta.url).href
        this.name = '起风了'
        this.user = '买辣椒也用券'
        this.imgUrl = 'https://tbt-blog.oss-cn-beijing.aliyuncs.com/%E8%B5%B7%E9%A3%8E%E4%BA%86.jpg'
      } else if (index == 3) {
        this.$refs.audio.src = new URL('@/audio/追梦赤子心.mp3', import.meta.url).href
        this.name = '追梦赤子心'
        this.user = 'GALA'
        this.imgUrl =
          'https://tbt-blog.oss-cn-beijing.aliyuncs.com/%E8%BF%BD%E6%A2%A6%E8%B5%A4%E5%AD%90%E5%BF%83.jpg'
      }

      this.$refs.audio.play()
    },
    next(index) {
      this.iszanting = true
      this.isbofang = false
      if (index == 0) {
        this.$refs.audio.src = new URL('@/audio/起风了.mp3', import.meta.url).href
        this.name = '起风了'
        this.user = '买辣椒也用券'
        this.imgUrl = 'https://tbt-blog.oss-cn-beijing.aliyuncs.com/%E8%B5%B7%E9%A3%8E%E4%BA%86.jpg'
      } else if (index == 1) {
        this.$refs.audio.src = new URL('@/audio/追梦赤子心.mp3', import.meta.url).href
        this.name = '追梦赤子心'
        this.user = 'GALA'
        this.imgUrl =
          'https://tbt-blog.oss-cn-beijing.aliyuncs.com/%E8%BF%BD%E6%A2%A6%E8%B5%A4%E5%AD%90%E5%BF%83.jpg'
      } else if (index == 2) {
        this.$refs.audio.src = new URL('@/audio/PLANET.mp3', import.meta.url).href
        this.name = 'PLANET'
        this.user = 'ラムジ'
        this.imgUrl = 'https://tbt-blog.oss-cn-beijing.aliyuncs.com/PLANET.jpg'
      }
      this.$refs.audio.play()
    },
    changeMusic(index) {
      this.iszanting = true
      this.isbofang = false
      this.index = index
      if (index == 0) {
        this.$refs.audio.src = new URL('@/audio/贝加尔湖畔.mp3', import.meta.url).href
        this.name = '贝加尔湖畔'
        this.user = '李健'
        this.imgUrl =
          'https://tbt-blog.oss-cn-beijing.aliyuncs.com/%E8%B4%9D%E5%8A%A0%E5%B0%94%E6%B9%96%E7%95%94.jpg'
      } else if (index == 1) {
        this.$refs.audio.src = new URL('@/audio/起风了.mp3', import.meta.url).href
        this.name = '起风了'
        this.user = '买辣椒也用券'
        this.imgUrl = 'https://tbt-blog.oss-cn-beijing.aliyuncs.com/%E8%B5%B7%E9%A3%8E%E4%BA%86.jpg'
      } else if (index == 2) {
        this.$refs.audio.src = new URL('@/audio/追梦赤子心.mp3', import.meta.url).href
        this.name = '追梦赤子心'
        this.user = 'GALA'
        this.imgUrl =
          'https://tbt-blog.oss-cn-beijing.aliyuncs.com/%E8%BF%BD%E6%A2%A6%E8%B5%A4%E5%AD%90%E5%BF%83.jpg'
      } else if (index == 3) {
        this.$refs.audio.src = new URL('@/audio/PLANET.mp3', import.meta.url).href
        this.name = 'PLANET'
        this.user = 'ラムジ'
        this.imgUrl = 'https://tbt-blog.oss-cn-beijing.aliyuncs.com/PLANET.jpg'
      }

      this.$refs.audio.play()
    },
    // 时长进度条
    timeUpdate() {
      const audio = this.$refs.audio
      // 时长进度条
      const slide = document.querySelector('.slide')
      const fill = document.querySelector('.fill')
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
      const audio = this.$refs.audio
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
    }
  },
  watch: {
    // 如果 `question` 发生改变，这个函数就会运行
    value: function (newvalue, oldvalue) {
      const audio = (this.volume = this.value / 100)
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

// const items = document.querySelectorAll('.navigation li')
// function setActive() {
//   items.forEach((items) => {
//     items.classList.remove('active')
//   })
//   this.classList.add('active')
//   current_tag.innerText = this.innerText
// }

// items.forEach((items) => {
//   items.addEventListener('click', setActive)
// })
</script>
<style scoped>
@import '@/css/font_footer.css';
@import '@/css/font_header.css';
@import '@/css/font_leftBox.css';
@import '@/css/main.css';
</style>
