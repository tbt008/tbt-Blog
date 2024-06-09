<template>
  <div class="show-main">
    <div class="tbt">
      <div class="main_left">
        <div class="myPhoto current">
          <a
            v-bind:class="{
              show: isClick == -1
            }"
            @click="setActiveItem(0)"
          >
            <img src="./img/ion.jpg" alt="" class="touxiang" />
            <h3>金屋藏小猪</h3>
            <p>我常站在天花板上思考人生。</p>
          </a>
        </div>
        <div class="tag" v-for="(list, index) in lists" :key="index">
          <div
            class="tag-a"
            v-bind:class="{
              show: index == isClick ? true : false
            }"
            ref="list"
            @click="setActiveItem(index + 1)"
          >
            {{ list.text }}
          </div>
        </div>
      </div>
      <div class="main_right">
        <el-carousel
          ref="carousel"
          :trigger="click"
          height="600px"
          direction="vertical"
          :autoplay="false"
          indicator-position="none"
        >
          <el-carousel-item class="content" v-for="(show, index) in shows" :key="show.id">
            <img :src="show.src" alt="" class="tupian" v-if="index != 4" />
            <div v-html="show.content" v-if="index != 4"></div>
            <div v-if="index == 4" class="friends">
              <!-- <el-scrollbar height="400px"> -->
              <div
                class="friend"
                v-for="friend in friends"
                :key="friend.id"
                @click="djFriend(friend.url)"
              >
                <img class="friend_img" :src="friend.img" />
                <div class="introduce">
                  <div class="friend-title">{{ friend.name }}</div>
                  <div class="friend-description">{{ friend.description }}</div>
                </div>
              </div>
              <!-- </el-scrollbar> -->
            </div>
            <div v-if="index == 0" class="into">
            </div>
            <div v-if="index == 5" class="content-QQ">
              <el-popover placement="top" :width="225" trigger="hover">
                <template #reference>
                  <svg
                    t="1716118770370"
                    class="icon"
                    viewBox="0 0 1024 1024"
                    version="1.1"
                    xmlns="http://www.w3.org/2000/svg"
                    p-id="10551"
                    width="40"
                    height="40"
                  >
                    <path
                      d="M619.486 921.312c-40.947 0-76.776 0-102.368 5.118-30.71-5.118-66.539-5.118-107.486-5.118-112.605 0-214.973 46.066-214.973 76.776s87.013 25.592 199.618 25.592c46.065 0 87.013-5.118 122.841-15.355 35.83 5.118 76.776 10.237 117.724 10.237 112.604 0 199.617 5.118 199.617-25.592s-102.368-71.658-214.973-71.658z"
                      fill="#EFAB1B"
                      p-id="10552"
                    ></path>
                    <path
                      d="M906.117 609.09c-20.474-56.303-46.066-117.724-71.658-174.026v-40.947C834.46 174.026 721.854 0 512 0S189.54 174.026 189.54 394.117v40.947c-25.591 56.302-51.183 117.723-71.657 174.026-46.065 122.841-46.065 230.328-30.71 240.564 10.237 5.119 51.184-35.828 92.131-102.368C204.896 900.838 312.382 1023.68 512 1023.68s307.104-117.723 332.696-281.512c35.829 66.54 76.776 107.486 87.013 102.368 20.473-5.118 15.355-117.723-25.592-235.446z"
                      fill="#040000"
                      p-id="10553"
                    ></path>
                    <path
                      d="M430.106 127.96c-30.71 0-56.303 35.829-56.303 81.894 0 46.066 25.592 81.895 56.303 81.895 30.71 0 56.302-35.829 56.302-81.895 0-46.065-25.592-81.894-56.302-81.894z m174.025 0c-30.71 0-56.302 35.829-56.302 76.776 0 46.066 25.592 81.894 56.302 81.894s56.303-35.828 56.303-76.776c0-46.065-25.592-81.894-56.303-81.894z m117.723 358.288c-61.42 10.237-133.078 15.355-204.736 15.355s-143.315-5.118-204.736-15.355c-40.947 51.184-46.065 127.96-46.065 209.854 0 153.552 87.013 281.512 250.801 281.512S767.92 849.654 767.92 696.102c0-81.894-5.118-158.67-46.066-209.854z"
                      fill="#FFFFFF"
                      p-id="10554"
                    ></path>
                    <path
                      d="M517.118 317.34c-107.486 0-199.617 20.474-199.617 40.948 0 15.355 117.723 66.54 199.617 66.54s199.618-51.185 199.618-66.54c-5.118-20.474-92.131-40.947-199.618-40.947z"
                      fill="#EFAB1B"
                      p-id="10555"
                    ></path>
                    <path
                      d="M829.34 429.946c-81.894 25.592-194.498 40.947-317.34 40.947-127.96 0-240.565-15.355-317.34-40.947-15.356 35.828-30.711 76.776-46.066 112.604 51.184 15.356 102.368 30.71 163.788 40.948V731.93s40.948 10.237 81.895 10.237c30.71 0 56.302-5.118 56.302-5.118V598.853H512c138.197 0 266.157-20.474 368.525-51.184-15.355-40.947-30.71-76.776-51.184-117.723z"
                      fill="#DB2920"
                      p-id="10556"
                    ></path>
                    <path
                      d="M450.58 184.262c-15.356 0-25.593 15.356-25.593 30.71s10.237 30.711 25.592 30.711 25.592-15.355 25.592-30.71c-5.118-15.355-15.355-30.71-25.592-30.71z m179.143 20.474s-10.237-10.237-35.829-10.237c-25.592 5.119-35.828 15.355-35.828 20.474 0 0-5.119 10.237 0 15.355 5.118 5.118 10.236-5.118 10.236-5.118s10.237-15.356 25.592-15.356 25.592 5.119 25.592 5.119 5.119 5.118 10.237 0 0-10.237 0-10.237z"
                      fill="#040000"
                      p-id="10557"
                    ></path>
                  </svg>
                </template>
                <img
                  style="width: 200px"
                  src="https://tbt-blog.oss-cn-beijing.aliyuncs.com/qq.png"
                />
              </el-popover>
              <el-popover placement="top" :width="225" trigger="hover">
                <template #reference>
                  <svg
                    t="1716118628735"
                    class="icon"
                    viewBox="0 0 1024 1024"
                    version="1.1"
                    xmlns="http://www.w3.org/2000/svg"
                    p-id="5954"
                    width="40"
                    height="40"
                  >
                    <path
                      d="M1010.8 628c0-141.2-141.3-256.2-299.9-256.2-168 0-300.3 115.1-300.3 256.2 0 141.4 132.3 256.2 300.3 256.2 35.2 0 70.7-8.9 106-17.7l96.8 53-26.6-88.2c70.9-53.2 123.7-123.7 123.7-203.3zM618 588.8c-22.1 0-40-17.9-40-40s17.9-40 40-40 40 17.9 40 40c0 22-17.9 40-40 40z m194.3-0.3c-22.1 0-40-17.9-40-40s17.9-40 40-40 40 17.9 40 40-17.9 40-40 40z"
                      fill="#00C800"
                      p-id="5955"
                    ></path>
                    <path
                      d="M366.3 106.9c-194.1 0-353.1 132.3-353.1 300.3 0 97 52.9 176.6 141.3 238.4l-35.3 106.2 123.4-61.9c44.2 8.7 79.6 17.7 123.7 17.7 11.1 0 22.1-0.5 33-1.4-6.9-23.6-10.9-48.3-10.9-74 0-154.3 132.5-279.5 300.2-279.5 11.5 0 22.8 0.8 34 2.1C692 212.6 539.9 106.9 366.3 106.9zM247.7 349.2c-26.5 0-48-21.5-48-48s21.5-48 48-48 48 21.5 48 48-21.5 48-48 48z m246.6 0c-26.5 0-48-21.5-48-48s21.5-48 48-48 48 21.5 48 48-21.5 48-48 48z"
                      fill="#00C800"
                      p-id="5956"
                    ></path>
                  </svg>
                </template>
                <img
                  style="width: 200px"
                  src="https://tbt-blog.oss-cn-beijing.aliyuncs.com/wechat.png"
                />
              </el-popover>
            </div>
          </el-carousel-item>
        </el-carousel>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import img1 from './img/about (1).jpg'
import img2 from './img/about (2).jpg'
import img3 from './img/about (3).jpg'
import img4 from './img/about (4).jpg'
import img5 from './img/about (5).jpg'
import img6 from './img/about (6).jpg'
export default {
  data() {
    return {
      lists: [
        { text: '资料' },
        { text: '技能' },
        { text: '作品' },
        { text: '友链' },
        { text: '联系' },
        { text: '更多' }
      ],
      shows: [
        {
          src: img5,
          content: ``
        },
        {
          src: img6,

          content: `<p>学历：莆田学院22级软件工程学生</p>
            <p>未来职业：一名专注后端Java工程师</p>
            <p>沉淀：提高技术水平，好好学英语！</p>
            <p>逐梦：争取在大二下学期暑假能找到一个实习！</p>`
        },

        {
          src: img1,

          content: `<p>java,ssm,springboot,redis,mysql,linux,前端 都会一点点.....</p>`
        },
        {
          src: img2,

          content: `  <p>她笑的很甜，像春日里的阳光</p>`
        },
        {
          src: img3,

          content: ``
        },
        {
          src: img4,

          content: ``
        },
        {
          src: img5,

          content: `

            <p>敬请期待吧</p>
            <p>你我顶峰相见！</p>`
        }
      ],
      input: '',
      initialIndex: 0,
      isClick: -1,
      friends: []
    }
  },
  methods: {
    djFriend(url) {
      window.open(url)
    },
    setActiveItem(index) {
      this.isClick = index - 1
      this.$refs.carousel.setActiveItem(index)
    },
    debounce(next, prev, delay) {
      let timer = null //借助闭包
      return function (e) {
        let direction = e.deltaY > 0 ? 'down' : 'up'
        // alert(direction)
        if (timer) {
          clearTimeout(timer)
        }
        if (direction == 'down' && e.deltaY >= 125) {
          // alert(direction)
          timer = setTimeout(next, delay)
        }
        if (direction == 'up' && e.deltaY <= -125) {
          // alert(direction)
          timer = setTimeout(prev, delay)
        }
      }
    },
    next() {
      if (this.isClick == 5) {
        this.isClick = -1
      } else {
        this.isClick = this.isClick + 1
      }
      this.setActiveItem(this.isClick + 1)
      // this.$refs.carousel.next()
    },
    prev() {
      if (this.isClick == -1) {
        this.isClick = 5
      } else {
        this.isClick = this.isClick - 1
      }
      this.setActiveItem(this.isClick + 1)
      // this.$refs.carousel.prev()
    },

    handleScroll(event) {
      let direction = event.deltaY > 0 ? 'down' : 'up'
      if (direction == 'down' && event.deltaY >= 125) {
        this.$refs.carousel.next()
      }
      if (direction == 'up' && event.deltaY <= -125) {
        this.$refs.carousel.prev()
      }
    }
  },
  mounted() {
    //监听鼠标滚动事件
    window.addEventListener('mousewheel', this.debounce(this.next, this.prev, 300))

    // 查询友链
    axios.get(`http://localhost:9090/friend/getAll`).then((res) => {
      this.friends = res.data.data
    })
  },
  unmounted() {
    window.removeEventListener('mousewheel', this.debounce(this.next, this.prev, 300), false)
  }
}
</script>

<style scoped>
.icon {
  margin: 10px;
  padding: 10px;
  background-color: aliceblue;
  border-radius: 50%;
}
@media only screen and (max-width: 414px) {
  .friends {
    display: flex;
    flex-wrap: wrap;
    width: 100%;
    height: 100%;
  }

  .friend {
    display: flex;
    width: 90%;
    border-radius: 15px;
    margin: 20px;

    background-color: rgb(206, 248, 248);
    height: 100px;
    align-items: center;
  }
  .friend_img {
    display: block;
    border-radius: 15px;
    height: 4rem;
    width: 4rem;
    margin-left: 10px;
    margin-right: 10px;
    padding: 0;
  }
  .friend-title {
    text-align: left;
    font-family: Georgia, serif;
    font-size: 20px;
    color: rgb(249, 4, 4);
  }
  .friend-description {
    text-align: left;

    font-size: 13px;
    width: 15em; /*保证文字不会被半汉字截断,显示10个文字*/
    overflow: hidden;
    /* 超出省略号表示 */
    text-overflow: ellipsis;
    display: -webkit-box;
    /* 垂直对齐 */
    -webkit-box-orient: vertical;
    /* 最多3行 */
    -webkit-line-clamp: 3;
  }
  .content-QQ {
    display: flex;
  }
  .into {
    display: block;
  }
  .show-main {
    display: flex;
    width: 100%;
    height: 100%;
  }
  .tbt {
    display: block;
    width: 100%;
    height: 100%;
    border-radius: 5px;
  }
  .tbt .main_left {
    display: flex;
    position: fixed;
    z-index: 99;
    top: 0;
    justify-content: center;
    align-items: center;
    width: 100%;
    background-color: rgb(255, 255, 255);
    border-radius: 5px;
  }
  .tbt.main_left div {
    width: 100%;
    display: block;
    flex: 1;
    text-align: center;
    transition: 0.5s ease-in-out;
  }
  .tbt .myPhoto {
    flex: 3;
    width: 10%;
    padding: 5px auto;
    text-align: center;
  }
  .tbt .myPhoto a {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 100%;
    height: 100%;
    line-height: 100%;
    color: #426696;
    font-size: 10px;
  }
  .tbt .myPhoto img {
    width: 50px;
    height: 50px;
    border-radius: 100%;
    margin: 10px auto;
  }
  .tbt .myPhoto p {
    margin: 10px auto;
  }
  .tbt .main_left div div {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 20%;
    height: 100%;
    line-height: 100%;
    margin: auto;
    color: #426696;
    font-size: 20px;
  }
  .tbt .main_left div:hover {
    background-color: rgba(255, 255, 255);
    border-radius: 5px;
  }
  .tbt .main_left .show {
    background-color: rgba(255, 255, 255);
    border-radius: 5px;
  }
  .tbt .main_left div:hover div {
    color: #000;
  }
  .tag-a {
    user-select: none;
    display: flex;
  }
  .tag {
    display: block;
    height: 100%;
    width: 10%;
  }
  /* ------------------------------------------------------ */
  .tbt .main_right {
    height: 600px;
    width: 100%;
    overflow: hidden;
  }
  .tbt .content {
    margin-top: 6rem;
    float: right;
    width: 100%;
    height: 600px;
    background-color: rgba(255, 255, 255, 0.3);
    border-radius: 5px;
    display: flex;
    flex-direction: column;
    align-items: center;
    text-align: center;
  }
  .tbt .hidden {
    display: none;
  }
  .tbt .content .tupian {
    width: 100%;
    height: auto;
    border-radius: 15px;
    margin: 40px auto;
  }
  .tbt .content p {
    color: #426696;
    font-size: 16px;
    font-weight: 700;
    margin: 20px auto 0;
  }
  .tbt .main_right div:nth-child(1) p {
    color: #426696;
    font-size: 10px;
    font-weight: 700;
    margin: 20px auto 0;
  }
  .tbt .current {
    background-color: rgba(255, 255, 255, 0.7);
    border-radius: 5px;
    /* 添加过度效果 */
    transition: all 0.5s;
  }
  .tbt .hidden_contact {
    display: block;
  }
}
@media only screen and (min-width: 414px) {
  .friends {
    display: flex;
    flex-wrap: wrap;
    width: 100%;
    height: 100%;
  }

  .friend {
    display: flex;
    width: 45%;
    border-radius: 15px;
    margin: 20px;
    background-color: rgb(189, 248, 248);
    height: 100px;
    /* margin: auto; */
    /* justify-content: center; */
    align-items: center;
  }
  .friend_img {
    border-radius: 15px;
    height: 80px;
    width: 80px;
    margin-left: 10px;
    margin-right: 10px;
    padding: 0;
  }
  .friend-title {
    text-align: left;
    font-family: Georgia, serif;
    font-size: 20px;
    color: rgb(249, 4, 4);
  }
  .friend-description {
    text-align: left;

    font-size: 13px;
    width: 15em; /*保证文字不会被半汉字截断,显示10个文字*/
    overflow: hidden;
    /* 超出省略号表示 */
    text-overflow: ellipsis;
    display: -webkit-box;
    /* 垂直对齐 */
    -webkit-box-orient: vertical;
    /* 最多3行 */
    -webkit-line-clamp: 3;
  }
  .content-QQ {
    display: block;
  }
  .into {
    display: block;
  }
  .show-main {
    display: flex;
    /* justify-content: space-around; */
    width: 100%;
    height: auto;
    padding-left: 10%;
    padding-right: 10%;
  }
  .tbt {
    display: flex;
    width: 80%;

    height: auto;

    border-radius: 25px;
    /* background-image: linear-gradient(45deg, rgba(163, 255, 231, 0.6), rgba(255, 193, 179, 0.6)); */
    position: absolute;
    top: 55%;
    left: 50%;
    transform: translate(-50%, -50%);
    margin: 0 auto;
    overflow: hidden;
    backdrop-filter: blur(0.2rem);
  }
  .tbt .main_left {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    flex: 3;
    height: 600px;
    background-color: rgba(255, 255, 255, 0.5);
    border-radius: 25px;
  }
  .tbt.main_left div {
    width: 100%;
    flex: 1;
    text-align: center;
    transition: 0.5s ease-in-out;
  }
  .tbt .myPhoto {
    flex: 3;
    width: 100%;
    padding: 15px auto;
    text-align: center;
  }
  .tbt .myPhoto a {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 100%;
    height: 100%;
    line-height: 100%;
    color: #426696;
    font-size: 16px;
  }
  .tbt .myPhoto img {
    width: 100px;
    height: 100px;
    border-radius: 100%;
    margin: 10px auto;
  }
  .tbt .myPhoto p {
    margin: 10px auto;
  }
  .tbt .main_left div div {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
    height: 100%;
    line-height: 100%;
    color: #426696;
    font-size: 16px;
    font-weight: 700;
  }
  .tbt .main_left div:hover {
    background-color: rgba(255, 255, 255);
    border-radius: 25px;
  }
  .tbt .main_left .show {
    background-color: rgba(255, 255, 255);
    border-radius: 25px;
  }
  .tbt .main_left div:hover div {
    color: #000;
  }
  .tag-a {
    display: flex;
    background-color: rgba(255, 255, 255, 0.4);
    width: 100%;
  }
  .tag {
    display: block;
    height: 10%;
    width: 100%;
  }
  /* ------------------------------------------------------ */
  .tbt .main_right {
    flex: 7;
    height: 600px;
    background-color: rgba(255, 255, 255, 0);
    border-radius: 0 25px 25px 0;
    overflow: hidden;
  }
  .tbt .content {
    float: right;
    width: 98%;
    height: 600px;
    background-color: rgba(255, 255, 255, 0.3);
    border-radius: 25px;
    display: flex;
    flex-direction: column;
    align-items: center;
    text-align: center;
  }
  .tbt .hidden {
    display: none;
  }
  .tbt .content .tupian {
    width: 640px;
    height: 360px;
    border-radius: 25px;
    margin: 40px auto;
  }
  .tbt .content p {
    color: #426696;
    font-size: 16px;
    font-weight: 700;
    margin: 20px auto 0;
  }
  .tbt .main_right div:nth-child(1) p {
    color: #fafafa;
    font-size: 16px;
    font-weight: 700;
    margin: 20px auto 0;
  }
  .tbt .current {
    background-color: rgba(255, 255, 255, 0.7);
    border-radius: 25px;
    /* 添加过度效果 */
    transition: all 0.5s;
  }
  .tbt .hidden_contact {
    display: block;
  }
}
</style>
