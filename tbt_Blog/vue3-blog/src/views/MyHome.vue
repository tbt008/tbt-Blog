<template>
  <div class="main-home">
    <div class="main-show">
      <div id="main-top">
        <div class="main-top-mid">
          <div class="font-title-1">Hi!</div>
          <div class="font-title-2">I'm Tan.</div>
          <div class="font-title-3">A Java Developer</div>
          <div class="main-top">
            <div class="tit"><span>金屋藏小猪</span></div>
          </div>
        </div>
      </div>

      <div class="main-img">
        <img src="@/views/img/ion.jpg" id="main-img" />
      </div>
    </div>
    <div class="main-mid">
      <div class="bounce down" @click="startRead">
        <i class="el-icon-arrow-down" style="color: white"></i>
      </div>
    </div>

    <div class="blog-top home-blog" id="blog-top">
      <img src="./img/img.png" class="blog-top-left" />
      <div class="blog-top-right"></div>
    </div>
    <div class="new-blog-main">
      <div class="border">
        <!-- 推荐文章 -->
        <h1>推荐文章</h1>

        <h1 class="text-color">Recommended article</h1>
      </div>
      <div class="blog-below home-blog">
        <img src="./img/img.png" class="blog-below-top" />
        <div class="blog-below-below"></div>
      </div>
      <div class="blog-below home-blog">
        <img src="./img/img.png" class="blog-below-top" />
        <div class="blog-below-below"></div>
      </div>
    </div>
  </div>
  <BlogFooter></BlogFooter>
</template>

<script>
import BlogFooter from '@/components/BlogFooter.vue'
export default {
  name: 'word-cloud',

 
  methods: {
    startRead() {
      //  平滑移动
      document.getElementById('blog-top').scrollIntoView({ behavior: 'smooth' })
    }
  },
  components: {
    BlogFooter
  }
}
</script>
<style>
img {
  user-select: none;
}
@media only screen and (max-width: 414px) {
  * {
    margin: 0;
    padding: 0;
  }
  .main-mid {


    z-index: 10;
    position: fixed;
    left: 50%;
    bottom: 10px;
    user-select: none;
  }
  .font-title-1 {
    font-size: 2rem;
    user-select: none;
    color: #28f357;
  }
  .font-title-2 {
    font-size: 2rem;
    color: #00fce7;

    user-select: none;
  }
  .font-title-3 {
    font-size: 1rem;
    user-select: none;
    padding-bottom: 20px;
  }
  .main-top-mid {
    height: 10rem;
    width: 10rem;
    display: block;
    user-select: none;
  }
  #main-img {
    user-select: none;
    border-radius: 50%;
    width: 5rem;

    transition: all 0.6s;
    display: flex;
    margin: auto;
  }
  #main-img:hover {
    transform: rotate(60deg);
  }
  .main-show {
    height: 10rem;
    /* display: -webkit-flex; */
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .main-img {
    user-select: none;
    display: flex;
    border-radius: 50%;
    width: 5.5rem;
    height: 5.5rem;
    background-size: 100% 100%;
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: cover;
    background: linear-gradient(to left top, rgb(1, 50, 248), rgb(246, 18, 136));
  }
  .home-blog {
    box-shadow: 5px 10px 10px #00000033;
    transition: transform 0.2s;
  }

  .text-color {
    background: linear-gradient(
      to right,
      #d111ee,
      #2435e9
    ); /*设置渐变的方向从左到右 颜色从ff0000到ffff00*/
    -webkit-background-clip: text; /*将设置的背景颜色限制在文字中*/
    -webkit-text-fill-color: transparent; /*给文字设置成透明*/
    margin: auto;
    font-family: STSong;
  }
  .new-blog-main {
    display: block;
    width: 100%;
  }
  .blog-below:hover {
    transform: scale(1.03);
  }
  .blog-top:hover {
    transform: scale(1.03);
  }
  .blog-below {
    display: block;
    width: 95%;
    height: 10rem;
    margin: auto;
    margin-top: 1rem;
    overflow: hidden;
    border-radius: 15px;
    background-color: #ffffff;
  }

  .border {
    display: none;
  }
  .blog-below-top {
    user-select: none;
    -webkit-mask-image: -webkit-linear-gradient(right, rgba(0, 0, 0, 0) 5%, rgba(0, 0, 0, 1) 30%);
    order: 1px solid red;
    width: 60%;
    object-fit: cover;
    height: 100%;
  }
  .blog-below-below {
    width: 40%;
    height: 100%;
  }
  .blog-top {
    display: flex;
    width: 95%;
    margin: auto;
    height: 10rem;
    overflow: hidden;
    background-color: rgb(255, 255, 255);
    border-radius: 15px;
  }
  .blog-top-left {
    user-select: none;
    -webkit-mask-image: -webkit-linear-gradient(right, rgba(0, 0, 0, 0) 5%, rgba(0, 0, 0, 1) 30%);
    order: 1px solid red;
    width: 60%;
    object-fit: cover;
    height: 100%;
  }
  .blog-top-right {
    width: 40%;
    height: 100%;
  }

  body {
    display: block;

    height: 100%;

    background: linear-gradient(to right bottom, rgb(1, 137, 248), rgb(239, 52, 211));
    background-size: 100% 100%;
    background-repeat: no-repeat;
    border-radius: 25px;
    background-attachment: fixed;
    background-size: cover;
  }
  .main-top {
    display: none;
    position: relative;
    top: 180px;
    width: 95%;

    height: 150px;
    border: solid 10px #fff;
    box-shadow: 0 0 70px rgb(190, 40, 210);
    /* display: flex; */
    justify-content: center;
    align-items: center;
    /* 设置鼠标移上去时变成小手形状 */
    cursor: pointer;
  }
  .main-top::after {
    content: '';
    position: absolute;
    width: 100%;
    height: 150px;
    box-shadow: 0 0 5px rgba(190, 40, 210);
    background-color: rgba(100, 30, 225, 0.4);
  }
  .main-top:hover {
    animation: a 1.5s;
  }
}

@media only screen and (min-width: 414px) {
  .main-mid {
    /* position: relative; */

    z-index: 10;
    position: fixed;
    left: 50%;
    bottom: 10px;
    user-select: none;
  }
  .font-title-1 {
    font-size: 80px;
    user-select: none;
    color: #28f357;
  }
  .font-title-2 {
    font-size: 80px;
    color: #00fce7;

    user-select: none;
  }
  .font-title-3 {
    font-size: 40px;
    user-select: none;
    padding-bottom: 20px;
  }
  .main-top-mid {
    display: block;
    user-select: none;
  }
  #main-img {
    border-radius: 50%;
    width: 250px;

    user-select: none;

    transition: all 0.6s;
    display: block;
    margin: auto;
  }
  #main-img:hover {
    transform: rotate(60deg);
  }
  .main-show {
    height: 100vh;
    display: -webkit-flex;
    justify-content: center;
    align-items: center;
  }
  .main-img {
    user-select: none;
    display: flex;
    border-radius: 50%;
    width: 260px;
    height: 260px;
    background-size: 100% 100%;
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: cover;
    /* background-color: #2435e9; */
    background: linear-gradient(to left top, rgb(1, 50, 248), rgb(246, 18, 136));
    /* background: linear-gradient(to left, #2247eb, #eb1b14) 1; */
  }
  .home-blog {
    box-shadow: 5px 10px 10px #00000033;
    transition: transform 0.2s;
  }

  .text-color {
    background: linear-gradient(
      to right,
      #d111ee,
      #2435e9
    ); /*设置渐变的方向从左到右 颜色从ff0000到ffff00*/
    -webkit-background-clip: text; /*将设置的背景颜色限制在文字中*/
    -webkit-text-fill-color: transparent; /*给文字设置成透明*/
    margin: auto;
    font-family: STSong;
  }
  .new-blog-main {
    display: flex;
    margin-top: 30px;
    justify-content: space-around;
  }
  .blog-below:hover {
    transform: scale(1.03);
  }
  .blog-top:hover {
    transform: scale(1.03);
  }
  .blog-below {
    display: block;
    width: 35%;
    height: 350px;
    overflow: hidden;
    border-radius: 15px;
    background-color: #ffffff;
  }

  .border {
    display: block;
    width: 20%;
    height: 350px;
    border-radius: 15px;
    background: linear-gradient(to right bottom, rgb(189, 219, 238), rgb(230, 182, 226));
    border: 5px solid;
    border-image: linear-gradient(to left, #2247eb, #eb1b14) 1;
  }
  .blog-below-top {
    -webkit-mask-image: -webkit-linear-gradient(bottom, rgba(0, 0, 0, 0) 5%, rgba(0, 0, 0, 1) 30%);
    order: 1px solid red;
    object-fit: cover;
    width: 100%;
    height: 50%;
  }
  .blog-below-below {
    width: 100%;
    height: 50%;
    background-color: rgb(255, 255, 255);
  }
  .blog-top {
    display: flex;
    width: 97%;
    margin: auto;
    height: 400px;
    overflow: hidden;
    background-color: rgb(255, 255, 255);
    border-radius: 15px;
  }
  .blog-top-left {
    -webkit-mask-image: -webkit-linear-gradient(right, rgba(0, 0, 0, 0) 5%, rgba(0, 0, 0, 1) 30%);
    order: 1px solid red;
    width: 60%;
    object-fit: cover;
    height: 100%;
  }
  .blog-top-right {
    width: 40%;
    height: 100%;
  }
  body {
    display: block;
    background: linear-gradient(to right bottom, rgb(1, 137, 248), rgb(239, 52, 211));
    /* background: url('./img/home.png'); */
    /* background: url('./img/sb2.jpg'); */
    /* background: url('./img/home.png'); */
    background-size: 100% 100%;
    background-repeat: no-repeat;
    border-radius: 25px;
    background-attachment: fixed;
    background-size: cover;
  }
  #main-top {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%;
    padding-right: 20%;
  }
  .main-top {
    position: relative;

    width: 400px;

    height: 100px;
    border: solid 10px #fff;
    box-shadow: 0 0 70px rgb(190, 40, 210);
    display: flex;
    justify-content: center;
    align-items: center;
    /* 设置鼠标移上去时变成小手形状 */
    cursor: pointer;
  }
  .main-top::after {
    content: '';
    position: absolute;
    /* width: 800px; */
    width: 400px;
    /* height: 120px; */
    height: 100px;
    box-shadow: 0 0 5px rgba(190, 40, 210);
    background-color: rgba(100, 30, 225, 0.4);
  }
  .main-top:hover {
    animation: a 1.5s;
  }
  @keyframes main-top {
    0%,
    34%,
    68%,
    100% {
      border: solid 10px #fff;
      box-shadow: 0 0 70px rgb(190, 40, 210);
    }
    17%,
    51%,
    85% {
      border: solid 10px rgba(255, 0, 0, 0.5);
      box-shadow: 0 0 90px rgba(255, 0, 0, 0.8);
    }
  }
  .tit,
  .tit::before {
    z-index: 999;
    color: #fff;
    position: absolute;
    font-size: 65px;
    font-weight: 900;
    /* 设置字体间距 */
    letter-spacing: 12px;
  }
  .tit::before {
    content: '金屋藏小猪';
    text-shadow:
      -5px -5px 0px rgb(211, 250, 9),
      5px 5px 0px rgb(25, 10, 240);
    /* 使用缩放的方式创建可见显示取余，括号里的四个值分别是top，right，bottom，left */
    clip-path: inset(100% 0px 0px 0px);
  }
  .main-top:hover .tit::before {
    /* steps设置逐帧动画，值越小越卡顿 */
    animation: move 1.25s steps(2);
  }
  /* 这是制造混乱的位置和高宽，可以自行改变，随机的 */
  @keyframes move {
    0% {
      clip-path: inset(80% 0px 0px 0px);
      transform: translate(-20px, -10px);
    }
    10% {
      clip-path: inset(10% 0px 85% 0px);
      transform: translate(10px, 10px);
    }
    20% {
      clip-path: inset(80% 0px 0px 0px);
      transform: translate(-10px, 10px);
    }
    30% {
      clip-path: inset(10% 0px 85% 0px);
      transform: translate(0px, 5px);
    }
    40% {
      clip-path: inset(50% 0px 30% 0px);
      transform: translate(-5px, 0px);
    }
    50% {
      clip-path: inset(10% 0px 30% 0px);
      transform: translate(5px, 0px);
    }
    60% {
      clip-path: inset(40% 0px 30% 0px);
      transform: translate(5px, 10px);
    }
    70% {
      clip-path: inset(50% 0px 30% 0px);
      transform: translate(-10px, 10px);
    }
    80% {
      clip-path: inset(80% 0px 5% 0px);
      transform: translate(20px, -10px);
    }
    90% {
      clip-path: inset(80% 0px 0px 0px);
      transform: translate(-10px, 0px);
    }
    100% {
      clip-path: inset(80% 0px 0px 0px);
      transform: translate(0px, 0px);
    }
  }
  .down {
    animation: bounce 2s infinite;
    animation-duration: 3s;
    font-size: 25px;
    position: absolute;
    bottom: 5px;
    left: 50%;
    transform: translateX(-50%);
    display: flex;
    justify-content: center;
    align-items: center;
    width: 50px;
    height: 50px;
    border-radius: 50%;
    border: 2px solid #fff;
  }

  .down:hover {
    animation: none;
    cursor: pointer;
    box-shadow: 0 0 20px 0 white;
    transition: all 0.2s;
  }
  @keyframes bounce {
    0%,
    20%,
    50%,
    80%,
    100% {
      transform: translate(-50%, 0);
    }
    40% {
      transform: translate(-50%, -30px);
    }
    60% {
      transform: translate(-50%, -15px);
    }
  }
  .main-home {
    height: auto;
    width: 90%;
    margin: auto;

    display: block;
  }
}
</style>
