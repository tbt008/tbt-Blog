<template>
  <div class="head-nav">
    <!-- <div class="head-ion"> -->

    <!-- </div> -->
    <ul id="nav">
      <li ref="slide1" class="slide1"></li>
      <li ref="slide2" class="slide2"></li>
      <li ref="links" v-for="(link, index) in links" :key="index">
        <a @click="handleClick(index)" @mouseover="handleHover(index)" @mouseout="handleOut(index)"
          >{{ link.text }}
        </a>
      </li>
    </ul>
  </div>

  <audio
    @timeupdate="timeUpdate"
    ref="audio"
    id="ado"
    :src="src"
    :controls="controls"
    :loop="loop"
    :volume="volume"
  ></audio>
</template>

<script>
export default {
  data() {
    return {
      links: [
        { path: '/', text: '主页', left: 0 },
        { path: '/blog', text: '博客', left: 136 },
        { path: '/photo', text: '照片集', left: 272 },
        { path: '/music/discover', text: '点歌台', left: 426 },
        { path: '/message', text: '留言板', left: 580 },
        { path: '/aboutMe', text: '关于我', left: 734 }
      ],
      src: new URL('@/audio/贝加尔湖畔.mp3', import.meta.url).href,
      controls: false,
      loop: true,
      volume: 1
    }
  },
  mounted() {
    const linksList = this.$refs.links
    const domWidth = linksList[0].getBoundingClientRect().width

    // 根据路径获取光标初始位置
    var slide_left = 0
    // alert(window.location.pathname)
    var path = window.location.pathname
    path = path.split('/')
    // alert(path[1])
    path = '/' + path[1]
    for (var i = 0; i < linksList.length; i++) {
      if (this.links[i].path == path) {
        slide_left = this.links[i].left
      }
    }
    // console.log(slide_left)
    this.$refs.slide1.style.left = slide_left + 'px'
    this.$refs.slide1.style.width = domWidth + 'px'
  },
  methods: {
    // 时长进度条
    timeUpdate() {
      const audio = document.getElementById('ado')
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
    handleClick(index) {
      const linksList = this.$refs.links
      const domLeft = linksList[0].getBoundingClientRect().left
      const now = linksList[index].getBoundingClientRect()
      this.$refs.slide1.style.opacity = 1
      // localStorage.setItem('slide_left', now.left - domLeft)
      this.$refs.slide1.style.left = now.left - domLeft + 'px'
      this.$refs.slide1.style.width = now.width + 'px'

      //    路由跳转
      this.$router.push(this.links[index])
    },
    handleHover(index) {
      const linksList = this.$refs.links
      const domLeft = linksList[0].getBoundingClientRect().left
      const now = linksList[index].getBoundingClientRect()
      this.$refs.slide2.style.opacity = 1
      this.$refs.slide2.style.left = now.left - domLeft + 'px'
      this.$refs.slide2.style.width = now.width + 'px'
      this.$refs.slide2.classList.add('squeeze')
    },
    handleOut() {
      this.$refs.slide2.style.opacity = 0
      this.$refs.slide2.classList.remove('squeeze')
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
.head-ion {
  height: 100%;
  width: 30px;
  justify-content: center;
  align-items: center;
}
@media only screen and (max-width: 414px) {
  .head-nav {
    display: none;
  }
}
@media only screen and (min-width: 414px) {
  .head-nav {
    /* 优先级 */
    z-index: 99;
    display: flex;
  }

  #nav {
    /* width: auto; */
    width: 900px;
    margin: auto;
    z-index: 98;
    position: relative;
    border: none;
    border-radius: 10em;
    display: flex;
    list-style: none;
    background: #f5f5f5;
    box-shadow: 5px 10px 10px #00000033;
    padding: 10px;
  }

  #nav li a {
    position: relative;
    padding: 15px 50px;
    font: 500 18px '优设标题黑';
    border: none;
    outline: none;
    color: rgb(70, 100, 180);
    display: inline-block;
    text-decoration: none;
    z-index: 3;
  }
  .slide1,
  .slide2 {
    position: absolute;
    display: inline-block;
    height: 60px;
    border-radius: 10em;
    transition: all 0.6s cubic-bezier(0.23, 1, 0.32, 1.05);
  }

  .slide1 {
    background-color: rgb(170, 190, 255);
    z-index: 2;
  }

  .slide2 {
    opacity: 0;
    background-color: rgba(170, 190, 255, 0.5);
    z-index: 1;
    box-shadow: 0 0 20px #ffffffaa inset;
  }

  .squeeze {
    transform: scale(0.9);
  }
}
</style>
