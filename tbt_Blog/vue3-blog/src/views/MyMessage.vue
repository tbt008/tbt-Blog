<template>
  <div class="message-main">
    <div class="messages">
      <h1>
        留言板
        <h6>~留下独属于你的痕迹</h6>
      </h1>

      <div class="form">
        <svg
          t="1716118770370"
          class="icon"
          viewBox="0 0 1024 1024"
          version="1.1"
          xmlns="http://www.w3.org/2000/svg"
          p-id="10551"
          width="50"
          height="50"
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
          ></path></svg
        ><input type="text" v-model="username" placeholder="QQ号" />
        <textarea placeholder="留言内容" v-model="message"></textarea>

        <button class="emoji-button" @click="emojiShow = !emojiShow">
          <svg
            t="1716283029251"
            class="icon"
            viewBox="0 0 1024 1024"
            version="1.1"
            xmlns="http://www.w3.org/2000/svg"
            p-id="2631"
            width="30"
            height="30"
          >
            <path
              d="M872.802928 755.99406 872.864326 755.99406 872.864326 755.624646Z"
              fill="#272536"
              p-id="2632"
            ></path>
            <path
              d="M807.273469 216.727043c-162.808016-162.836669-427.736874-162.836669-590.544891 0-162.836669 162.806993-162.836669 427.736874 0 590.543867 162.808016 162.837692 427.737898 162.837692 590.544891 0C970.110137 644.462894 970.110137 379.534036 807.273469 216.727043M764.893242 764.92036c-139.444912 139.443889-366.370225 139.414213-505.798764 0-139.459239-139.473565-139.459239-366.354875 0-505.827417 139.428539-139.429563 366.354875-139.460262 505.798764 0C904.336108 398.521482 904.336108 625.476471 764.893242 764.92036"
              fill="#231F20"
              p-id="2633"
            ></path>
            <path
              d="M381.724423 468.02137c24.783453 0 44.953841-20.169365 44.953841-44.967144 0-24.828478-20.170388-45.027519-44.953841-45.027519-24.842805 0-45.013193 20.199041-45.013193 45.027519C336.71123 447.852004 356.881618 468.02137 381.724423 468.02137"
              fill="#231F20"
              p-id="2634"
            ></path>
            <path
              d="M640.680243 468.095048c24.812105 0 45.010123-20.213367 45.010123-45.01217 0-24.827455-20.198018-44.99682-45.010123-44.99682-24.785499 0-44.953841 20.169365-44.953841 44.99682C595.726401 447.88168 615.894743 468.095048 640.680243 468.095048"
              fill="#231F20"
              p-id="2635"
            ></path>
            <path
              d="M642.245901 619.058294l-2.453888 0.798179c-40.310078 18.248619-83.548858 27.5341-128.411625 27.5341-46.343491 0-90.173742-9.375531-130.305765-27.799136l-2.425236-0.741897c-1.508353-0.413416-3.548826-1.003863-6.092765-1.003863-14.757099 0-26.734898 11.977799-26.734898 26.675546 0 6.978948 3.282766 13.988596 8.695033 19.253506l-0.325411 1.62501 6.831592 3.076058c47.911196 21.679765 100.021018 33.095769 150.681838 33.095769 51.608402 0 102.180194-11.120268 150.978597-33.361829 8.575306-4.703115 13.928221-13.721513 13.928221-23.511483C676.611593 627.458615 661.027663 613.290941 642.245901 619.058294"
              fill="#231F20"
              p-id="2636"
            ></path>
          </svg>
        </button>

        <button @click="submit" id="submitBtn">留言</button>
      </div>

      <div ref="messageBoard" id="messageBoard">
        <emoji
          ref="emoji"
          :emojiShow="emojiShow"
          :message="message"
          @getSonContent="getSonContent"
        ></emoji>

        <div v-for="(Message, index) in messageList" :key="index" class="message">
          <div class="message-info">
            <div class="info-left">
              <div class="block">
                <img v-if="Message.img" :src="Message.img" class="qqImg" />
                <img
                  v-if="!Message.img"
                  src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png
"
                  class="qqImg"
                />
              </div>
              <name>{{ Message.name }}</name>
            </div>
            <div class="info-right">
              <span>发布于:{{ Message.createTime }}</span>
            </div>
          </div>
          <div class="content">
            <div v-html="Message.message"></div>
          </div>
        </div>
        <div class="loadPage" v-if="messageList.length >= 5 && !isBottom">
          <el-button type="primary" @click="changePage" class="select">加载更多</el-button>
        </div>
        <div class="isBottom" v-else></div>
      </div>
    </div>
  </div>
  <BlogFooter></BlogFooter>
</template>

<script>
import axios from 'axios'
import { ElMessage } from 'element-plus'
import BlogFooter from '@/components/BlogFooter.vue'
import emoji from '@/components/emoji.vue'
export default {
  data() {
    return {
      isBottom: false,
      index: 1,
      emojiShow: false,
      messageList: [],
      username: '',
      message: ''
    }
  },

  created() {
    this.getData()
  },
  methods: {
    changePage() {
      this.index += 1
      this.getData()
    },
    getSonContent(v) {
      this.message += v
    },
    getData() {
      axios
        .get(`http://localhost:9090/message/page?pageNo=${this.index}&pageSize=5`)
        .then((res) => {
          if (res.data.data.length == 0) {
            this.isBottom = true
          }
          if (this.index == 1) {
            this.messageList = res.data.data
          } else {
            this.messageList = this.messageList.concat(res.data.data)
          }
          console.log(this.messageList)
          this.messageList = this.$refs.emoji.translate(this.messageList)
        })
    },
    submit() {
      var username = this.username
      var message = this.message
      if (message == '') {
        ElMessage.error('请输入内容')

        return
      }
      if (username == '') {
        ElMessage.error('请输入QQ号')

        return
      }
      if (username.length < 9) {
        ElMessage.error('请输入正确的QQ号')
        return
      }
      if (username == '123456') {
        ElMessage.error('小黑子别来了')
        return
      }
      let qqImg = '无法显示'
      let qqName = '无法显示'
      axios.get(`https://api.usuuu.com/qq/${username}`).then((res) => {
        console.log(res.data.data.name)
        if (res.data.data.code == '400' || res.data.data.code == '500') {
          ElMessage.error('QQ号不存在')
          return
        }

        qqName = res.data.data.name
        qqImg = ` http://q2.qlogo.cn/headimg_dl?dst_uin=${username}&spec=100`
        axios
          .post('http://localhost:9090/message/add', {
            name: qqName,
            qq: username,
            img: qqImg,
            message: message
          })
          .then(() => {
            this.index = 1
            this.getData()
          })
      })
    }
  },
  components: {
    BlogFooter,
    emoji
  }
}
</script>

<style scoped>
.loadPage {
  display: flex;
}
.select {
  border: 0;
  margin: auto;
  color: rgb(252, 252, 252);
  background: linear-gradient(
    130deg,
    rgb(36, 198, 220),
    rgb(84, 51, 255) 41.07%,
    rgb(255, 0, 153) 76.05%
  );
}
.isBottom {
  display: block;
  height: 5px;
  user-select: none;
  background: linear-gradient(
    130deg,
    rgb(36, 198, 220),
    rgb(84, 51, 255) 41.07%,
    rgb(255, 0, 153) 76.05%
  );
}
@media only screen and (max-width: 414px) {
  .emoji-button {
    position: absolute;
    left: 0;
    bottom: 0;
    background-image: linear-gradient(90deg, #c587ff 0%, #69b3fc 100%);
    border: none;
    color: rgb(14, 0, 7);
    font-size: 17px;
    font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode',
      Geneva, Verdana, sans-serif;
    /* letter-spacing: 5px; */
    width: 80px;
    height: 50px;
    border-radius: 50px;
  }
  .emoji:hover {
    height: 2rem;
    width: 2rem;
  }
  .emoji-box {
    display: flex;

    flex-wrap: wrap;
  }
  .emoji-main-hide {
    max-height: 0;

    background-color: rgb(255, 255, 255);
    flex-wrap: wrap;
    border-radius: 15px;
    overflow: hidden;
    transition: max-height 0.5s;
  }

  .emoji-main {
    transition: max-height 0.5s;
    max-height: 300px;

    background-color: rgb(255, 255, 255);
    flex-wrap: wrap;
    border-radius: 15px;
    overflow: hidden;
    width: auto;
    height: auto;
  }
  .emoji {
    transform: translateY(10%);
    height: 1.5rem;
    width: 1.5rem;
  }
  .emoji-body {
    display: block;
    text-align: center;
    justify-content: center;
    align-items: center;
    background-color: rgb(247, 247, 247);
    margin: 5px;
    width: 2rem;
    height: 2rem;
  }
  .qqImg {
    height: 3rem;
    border-radius: 50%;
  }
  .messages {
    width: 100%;
    display: flex;
    margin: auto;
    flex-direction: column;
  }
  .message-main {
    background-size: 100% 100%;
    background-repeat: no-repeat;
    padding: 2rem;
    background: linear-gradient(
      to right bottom,
      rgba(255, 255, 255, 0.6),
      rgba(255, 255, 255, 0.3),
      rgba(255, 255, 255, 0.2)
    );
    background-color: rgba(255, 255, 255, 0.266);
    display: block;
    justify-content: center;
    align-items: center;
  }
  .form {
    display: flex;
    justify-content: center;
    position: relative;
    flex-direction: column;
    width: 100%;
    padding-bottom: 20px;
  }

  input:focus,
  textarea:focus {
    outline: none;
  }

  input,
  textarea {
    border: none;
    color: #000;
    margin-bottom: 40px;
    font: 200 20px '';
    border-radius: 10px;
    padding: 15px;
  }

  #username {
    height: 10px;
  }

  #message {
    height: 50px;
  }

  .messages h1 {
    width: 100%;
    text-align: left;
    margin-bottom: 70px;
    font-size: 30px;
    background-image: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    letter-spacing: 10px;
  }

  #submitBtn {
    position: absolute;
    right: 0;
    bottom: 0;
    background-image: linear-gradient(90deg, #c587ff 0%, #69b3fc 100%);
    border: none;
    font-size: 20px;
    letter-spacing: 5px;
    width: 80px;
    height: 50px;
    border-radius: 50px;
  }

  #messageBoard {
    width: 100%;
    text-align: left;
  }

  @keyframes messageFadeIn {
    to {
      opacity: 1;
    }
  }
  .message {
    width: 100%;
    margin: 10px;
    padding: 10px;
    opacity: 0;
    animation: messageFadeIn 0.5s ease forwards;
    background-image: linear-gradient(90deg, #8ec5fc 0%, #e0c3fc 100%);
    background-color: #fff;
    margin: 70px 0;
    border-radius: 10px;
    box-shadow: 0 10px 20px #00000026;
    text-shadow: 0px 0px 20px #ffffff;
    color: #fff;
    box-sizing: border-box;
  }

  .message-info {
    height: auto;
    display: flex;
  }
  .info-left {
    display: block;
    width: 50%;
  }
  .info-right {
    text-align: right;
    width: 50%;
  }
  .messages .content {
    font-size: 20px;
    margin: 15px;
    word-wrap: break-word;
    width: 80%;
  }
}
@media only screen and (min-width: 414px) {
  .emoji-button {
    position: absolute;
    left: 0;
    bottom: 0;
    background-image: linear-gradient(90deg, #c587ff 0%, #69b3fc 100%);
    border: none;
    color: rgb(14, 0, 7);
    font-size: 17px;
    font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode',
      Geneva, Verdana, sans-serif;
    /* letter-spacing: 5px; */
    width: 80px;
    height: 40px;
    border-radius: 50px;
  }
  .emoji:hover {
    height: 35px;
    width: 35px;
  }
  .emoji-main-hide {
    max-height: 0;
    /* display: flex; */
    background-color: rgb(255, 255, 255);
    flex-wrap: wrap;
    border-radius: 15px;
    overflow: hidden;
    transition: max-height 0.5s;
  }
  .emoji-box {
    display: flex;

    flex-wrap: wrap;
  }
  .emoji-main {
    /* display: flex; */

    transition: max-height 0.5s;
    max-height: 300px;

    background-color: rgb(255, 255, 255);
    flex-wrap: wrap;
    border-radius: 15px;
    overflow: hidden;
    width: auto;
    height: auto;
  }
  .emoji {
    transform: translateY(10%);
    height: 30px;
    width: 30px;
  }
  .emoji-body {
    display: block;
    text-align: center;
    justify-content: center;
    align-items: center;
    background-color: rgb(247, 247, 247);
    margin: 5px;
    width: 40px;
    height: 40px;
  }
  .qqImg {
    height: 3rem;
    border-radius: 50%;
  }
  .messages {
    margin-top: 100px;
    width: 40%;
    padding: 50px 100px;
    display: flex;
    margin: auto;
    justify-content: center;
    align-items: center;

    flex-direction: column;
    background: linear-gradient(
      to right bottom,
      rgba(255, 255, 255, 0.6),
      rgba(255, 255, 255, 0.3),
      rgba(255, 255, 255, 0.2)
    );
    background-color: rgba(255, 255, 255, 0.266);
    border-radius: 15px;
    box-shadow: 0 10px 50px #00000019;
  }

  .message-main {
    background-size: 100% 100%;
    background-repeat: no-repeat;
    border-radius: 25px;
    height: auto;
    display: block;
    border: 40px;
    justify-content: center;
    align-items: center;
  }

  .form {
    display: flex;
    justify-content: center;
    position: relative;
    flex-direction: column;
    width: 100%;
    padding-bottom: 20px;
  }

  input:focus,
  textarea:focus {
    outline: none;
  }

  input,
  textarea {
    border: none;
    color: #000;
    margin-bottom: 40px;
    font: 200 20px '';
    border-radius: 10px;
    padding: 15px;
  }
  name {
    background: linear-gradient(135deg, #002ef9 0%, #f700ff 100%);
    -webkit-background-clip: text; /*将设置的背景颜色限制在文字中*/
    -webkit-text-fill-color: transparent; /*给文字设置成透明*/

    font-size: 20px;
    font-family: Microsoft Yahei;
  }
  #message {
    height: 50px;
  }

  .messages h1 {
    width: 100%;
    text-align: left;
    margin-bottom: 70px;
    font-size: 30px;
    background-image: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    letter-spacing: 10px;
  }

  #submitBtn {
    position: absolute;
    right: 0;
    bottom: 0;
    background-image: linear-gradient(90deg, #c587ff 0%, #69b3fc 100%);
    border: none;
    color: rgb(14, 0, 7);
    font-size: 17px;
    font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode',
      Geneva, Verdana, sans-serif;
    letter-spacing: 5px;
    width: 80px;
    height: 40px;
    border-radius: 50px;
  }

  #messageBoard {
    width: 100%;
    text-align: left;
  }

  @keyframes messageFadeIn {
    to {
      opacity: 1;
    }
  }

  .message {
    width: 100%;
    margin: 10px;
    padding: 10px;
    opacity: 0;
    animation: messageFadeIn 0.5s ease forwards;
    background-image: linear-gradient(90deg, #8ec5fc 0%, #e0c3fc 100%);
    background-color: #fff;
    margin: 70px 0;
    border-radius: 10px;
    box-shadow: 0 10px 20px #00000026;
    text-shadow: 0px 0px 20px #ffffff;
    color: #fff;
    box-sizing: border-box;
  }

  .message-info {
    height: auto;
    display: flex;
  }
  .info-left {
    display: block;
    width: 50%;
  }
  .info-right {
    text-align: right;
    width: 50%;
  }
  .messages .content {
    font-size: 20px;
    margin: 15px;
    word-wrap: break-word;
    width: 80%;
  }
}
</style>
