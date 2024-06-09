<template>
  <div class="content" v-if="id">
    <div class="content-top">
      <div class="title">
        {{ article.title }}
      </div>
      <div class="user">
        <h6>作者 : {{ article.createUser }}</h6>
        <h6>发布时间 : {{ article.createTime }}</h6>
      </div>
    </div>
    <div class="content-main">
      <div class="content-left">
        <!-- 整个用户信息区 -->

        <div class="div-border">
          <div class="card">
            <!-- 用户的头像 -->
            <div class="img">
              <img src="https://tbt-blog.oss-cn-beijing.aliyuncs.com/ion.jpg" loading="eager" />
            </div>

            <h3>金屋藏小猪</h3>
            <!-- gitee地址 -->

            <a href="https://github.com/dashboard">github地址</a>

            <div class="counter">
              <span>文章</span>
              <span>分类</span>
            </div>
            <div class="counter">
              <!-- 两篇文章,一个分类 -->
              <span>x</span>
              <span>y</span>
            </div>
          </div>
        </div>

        <el-affix :offset="60">
          <div v-if="catalog.length != 0" class="catalogue-border">
            <el-anchor :offset="70" style="width: 220px" class="catalogue" id="catalogue">
              <div v-if="catalog.length != 0" ref="catalogue">
                <h3 class="catalogue-title">目录</h3>
                <el-scrollbar height="600px">
                  <div v-for="(item, index) in catalog" :key="index">
                    <el-anchor-link :href="'#' + item.id">
                      {{ item.title }}
                    </el-anchor-link>
                  </div>
                </el-scrollbar>
              </div>
            </el-anchor>
          </div>
        </el-affix>
      </div>

      <div class="content-right-main">
        <div ref="contentRight" class="content-right">
          <div
            id="articleRef"
            ref="articleRef"
            v-higelight
            v-html="article.content"
            class="right-content"
          ></div>
        </div>
        <div class="comment-form">
          <div class="form-top">
            <el-input v-model="myQQ" style="width: 240px" placeholder="请输入QQ" />
            <el-input v-model="myUrl" style="width: 240px" placeholder="请输入你的网站(选填)" />
            <el-input v-model="myEmail" style="width: 240px" placeholder="请输入你的邮箱(选填)" />
          </div>
          <div class="form-bottom">
            <el-input
              v-model="myContent"
              style="width: 100%; margin-bottom: 20px"
              :rows="2"
              type="textarea"
              placeholder="我不服！"
            />
          </div>
          <el-button
            style="position: relative; left: 0%"
            type="primary"
            plain
            @click="emojiShow = !emojiShow"
          >
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
              ></path></svg
          ></el-button>
          <el-button
            @click="addComment()"
            style="position: relative; left: 85%"
            type="primary"
            plain
            >发射</el-button
          >

          <div :class="emojiShow == true ? 'emoji-main' : 'emoji-main-hide'">
            <el-scrollbar height="200px">
              <div
                class="emoji-box"
                oncontextmenu="return false"
                oncopy="return false"
                onselectstart="return false"
              >
                <div class="emoji-body" v-for="(emo, index) in emoji" :key="index">
                  <img :src="ossKey + emo.src" class="emoji" @click="addEmoji(index)" />
                </div>
              </div>
            </el-scrollbar>
          </div>
        </div>
        <div class="comment-body">
          <div v-for="(comment, index) in commentList" :key="index" class="comment">
            <div class="comment-info">
              <div class="info-left">
                <div class="block">
                  <img v-if="comment.img" :src="comment.img" class="qqImg" />
                  <img
                    v-if="!comment.img"
                    src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"
                    class="qqImg"
                  />
                  <name>{{ comment.name }}</name>
                </div>
              </div>
              <div class="info-right">
                <span>发布于:{{ comment.createTime }}</span>
              </div>
            </div>
            <div class="comment-content">
              <div v-html="comment.content"></div>
            </div>
            <div @click="showTwoComment(comment.id)" class="addComment">回复</div>
            <div
              :class="
                formShow == commentList[index].id ? 'comment-form-main' : 'comment-form-main-hide'
              "
            >
              <div class="comment-form">
                <div class="form-top">
                  <el-input v-model="myQQ" style="width: 240px" placeholder="请输入QQ" />
                  <el-input
                    v-model="myUrl"
                    style="width: 240px"
                    placeholder="请输入你的网站(选填)"
                  />
                  <el-input
                    v-model="myEmail"
                    style="width: 240px"
                    placeholder="请输入你的邮箱(选填)"
                  />
                </div>
                <div class="form-bottom">
                  <el-input
                    v-model="myContent"
                    style="width: 100%; margin-bottom: 20px"
                    :rows="2"
                    type="textarea"
                    placeholder="我不服！"
                  />
                </div>
                <el-button
                  style="position: relative; left: 0%"
                  type="primary"
                  plain
                  @click="emojiShow = !emojiShow"
                >
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
                    ></path></svg
                ></el-button>
                <el-button
                  @click="addTwoComment(comment.id)"
                  style="position: relative; left: 85%"
                  type="primary"
                  plain
                  >发射</el-button
                >

                <div :class="emojiShow == true ? 'emoji-main' : 'emoji-main-hide'">
                  <el-scrollbar height="200px">
                    <div
                      class="emoji-box"
                      oncontextmenu="return false"
                      oncopy="return false"
                      onselectstart="return false"
                    >
                      <div class="emoji-body" v-for="(emo, index) in emoji" :key="index">
                        <img :src="ossKey + emo.src" class="emoji" @click="addEmoji(index)" />
                      </div>
                    </div>
                  </el-scrollbar>
                </div>
              </div>
            </div>
            <div class="twoComment" v-for="(Two, indexTwo) in twoList[index]" :key="indexTwo">
              <div class="comment-info">
                <div class="info-left">
                  <div class="block">
                    <img v-if="Two.img" :src="Two.img" class="qqImg" />
                    <img
                      v-if="!Two.img"
                      src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"
                      class="qqImg"
                    />
                    <name>{{ Two.name }} </name>
                    <div class="huifu">回复</div>
                    <name> {{ Two.targetName }}</name>
                  </div>
                </div>
                <div class="info-right">
                  <span>发布于:{{ Two.createTime }}</span>
                </div>
              </div>
              <div class="comment-content">
                <div v-html="Two.content"></div>
              </div>
              <div @click="showTwoComment(Two.id)" class="addComment">回复</div>
              <div :class="formShow == Two.id ? 'comment-form-main' : 'comment-form-main-hide'">
                <div class="comment-form">
                  <div class="form-top">
                    <el-input v-model="myQQ" style="width: 240px" placeholder="请输入QQ" />
                    <el-input
                      v-model="myUrl"
                      style="width: 240px"
                      placeholder="请输入你的网站(选填)"
                    />
                    <el-input
                      v-model="myEmail"
                      style="width: 240px"
                      placeholder="请输入你的邮箱(选填)"
                    />
                  </div>
                  <div class="form-bottom">
                    <el-input
                      v-model="myContent"
                      style="width: 100%; margin-bottom: 20px"
                      :rows="2"
                      type="textarea"
                      placeholder="我不服！"
                    />
                  </div>
                  <el-button
                    style="position: relative; left: 0%"
                    type="primary"
                    plain
                    @click="emojiShow = !emojiShow"
                  >
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
                      ></path></svg
                  ></el-button>
                  <el-button
                    @click="addTwoComment(Two.id)"
                    style="position: relative; left: 85%"
                    type="primary"
                    plain
                    >发射</el-button
                  >

                  <div :class="emojiShow == true ? 'emoji-main' : 'emoji-main-hide'">
                    <el-scrollbar height="200px">
                      <div
                        class="emoji-box"
                        oncontextmenu="return false"
                        oncopy="return false"
                        onselectstart="return false"
                      >
                        <div class="emoji-body" v-for="(emo, index) in emoji" :key="index">
                          <img :src="ossKey + emo.src" class="emoji" @click="addEmoji(index)" />
                        </div>
                      </div>
                    </el-scrollbar>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <el-backtop :right="100" :bottom="100" />
</template>
<script setup lang="ts">
import 'highlight.js/styles/an-old-hope.css'
import 'highlight.js/lib/common'
import hljs from 'highlight.js'
import axios from 'axios'
import { useRouter } from 'vue-router'
import { ref, nextTick } from 'vue'
import { marked } from 'marked'
import { ElMessage } from 'element-plus'
const vHigelight = {
  mounted(el: any) {
    let blocks = el.querySelectorAll('pre code')
    blocks.forEach((block: HTMLElement) => {
      block.setAttribute('style', 'margin-top: 8px;')
      hljs.highlightElement(block)
    })
  }
}
const myQQ = ref()
const myUrl = ref()
const myEmail = ref()
const myContent = ref('')
let catalog: any = ref([])
const article = ref()
const router = useRouter()
const articleRef = ref()
const id = router.currentRoute.value.query.id
var emojiShow = ref(false)
var formShow = ref(-1)
const commentList = ref()
var twoList = ref([])
const source = 1
getComment()
function getComment() {
  twoList = ref([])
  // 获取到一级评论
  axios.get(`http://localhost:9090/user/comment/getOne/${source}/${id}`).then((res) => {
    commentList.value = res.data.data
    //替换

    var pattern = /\:\:\([\u4e00-\u9fa5]+\)\:/g
    var pattern2 = /\:\:\([\u4e00-\u9fa5]+\)\:/
    for (var i = 0; i < commentList.value.length; i++) {
      var cont = commentList.value[i].content
      var content = cont.match(pattern)

      if (content) {
        for (var k = 0; k < content.length; k++) {
          for (var j = 0; j < emoji.length; j++) {
            if ('::(' + emoji[j].title + '):' == content[k]) {
              var src = ossKey + emoji[j].src
              break
            }
          }
          var imgText =
            `<img  src="` +
            src +
            `" style="height: 2.5rem;
width: 2.5rem;" class="message-img" />`
          cont = cont.replace(pattern2, imgText)
        }
      }

      commentList.value[i].content = cont
    }
    nextTick(async () => {
      // 获取到二级评论
      for (var i = 0; i < commentList.value.length; i++) {
        var twoCommentList = []
        var whileIdList = []
        whileIdList.push(commentList.value[i].id)
        while (whileIdList[0] != null) {
          var whileId = whileIdList[0]
          await axios
            .get(`http://localhost:9090/user/comment/getTwo/${whileId}`)
            .then((res) => {
              for (var j = 0; j < res.data.data.length; j++) {
                twoCommentList.push(res.data.data[j])
                whileIdList.push(res.data.data[j].id)
              }
            })
          whileIdList.shift()
        }
        //替换
        for (var v = 0; v < twoCommentList.length; v++) {
          var cont = twoCommentList[v].content
          var content = cont.match(pattern)

          if (content) {
            for (var k = 0; k < content.length; k++) {
              for (var j = 0; j < emoji.length; j++) {
                if ('::(' + emoji[j].title + '):' == content[k]) {
                  var src = ossKey + emoji[j].src
                  break
                }
              }
              var imgText =
                `<img  src="` +
                src +
                `" style="height: 2.5rem;
width: 2.5rem;" class="message-img" />`
              cont = cont.replace(pattern2, imgText)
            }
          }

          twoCommentList[v].content = cont
        }
        twoList.value.push(twoCommentList)
      }
    })
  })
}
axios.get(`http://localhost:9090/user/article/${id}`).then((data) => {
  article.value = data.data.data
  article.value.content = marked(article.value.content || '')
  nextTick(() => {
    const nodes = ['H1', 'H2', 'H3', 'H4', 'H5', 'H6']
    articleRef.value.childNodes.forEach((e: any, index: number) => {
      if (nodes.includes(e.nodeName)) {
        const id = 'header-' + index
        e.setAttribute('id', id)
        catalog.value.push({
          id: id,
          title: e.innerHTML,
          level: Number(e.nodeName.substring(1, 2)),
          nodeName: e.nodeName
        })
      }
    })
  })
})
function addComment() {
  if (myContent.value == '') {
    ElMessage.error('请输入内容')

    return
  }
  if (myQQ.value == '') {
    ElMessage.error('请输入QQ号')

    return
  }
  let qqImg = '无法显示'
  let qqName = '无法显示'
  axios.get(`https://api.usuuu.com/qq/${myQQ.value}`).then((res) => {
    if (res.data.data.code == '400' || res.data.data.code == '500') {
      ElMessage.error('QQ号不存在')
      return
    }
    qqName = res.data.data.name
    qqImg = ` http://q2.qlogo.cn/headimg_dl?dst_uin=${myQQ.value}&spec=100`
    axios
      .post('http://localhost:9090/user/comment/addOne', {
        source: 1,
        sourceId: id,
        img: qqImg,
        name: qqName,
        qq: myQQ.value,
        email: myEmail.value,
        url: myUrl.value,
        content: myContent.value
      })
      .then(() => {
        getComment()
      })
  })
}
function addTwoComment(indexId) {
  if (myContent.value == '') {
    ElMessage.error('请输入内容')

    return
  }
  if (myQQ.value == '') {
    ElMessage.error('请输入QQ号')

    return
  }
  let qqImg = '无法显示'
  let qqName = '无法显示'
  axios.get(`https://api.usuuu.com/qq/${myQQ.value}`).then((res) => {
    if (res.data.data.code == '400' || res.data.data.code == '500') {
      ElMessage.error('QQ号不存在')
      return
    }
    qqName = res.data.data.name
    qqImg = ` http://q2.qlogo.cn/headimg_dl?dst_uin=${myQQ.value}&spec=100`
    axios
      .post('http://localhost:9090/user/comment/addTwo', {
        source: 1,
        targetId: indexId,
        img: qqImg,
        name: qqName,
        qq: myQQ.value,
        email: myEmail.value,
        url: myUrl.value,
        content: myContent.value
      })
      .then(() => {
        getComment()
      })
  })
}
function showTwoComment(index) {
  if (formShow.value == index) {
    formShow.value = -1
  } else {
    formShow.value = index
  }
}
function addEmoji(id) {
  myContent.value += '::(' + emoji[id].title + '):'
}

const ossKey = 'https://tbt-blog.oss-cn-beijing.aliyuncs.com/'
const emoji = [
  { src: 'emoji/zhenbang.png', title: '真棒' },
  { src: 'emoji/yiwen.png', title: '疑问' },
  { src: 'emoji/tushe.png', title: '吐舌' },
  { src: 'emoji/weixiao.png', title: '微笑' },
  { src: 'emoji/xiaolian.png', title: '笑脸' },
  { src: 'emoji/nianyu%403x.png', title: '鲶鱼' },
  { src: 'emoji/yinxian.png', title: '阴笑' },
  { src: 'emoji/xiaochou%403x.png', title: '小丑' },
  { src: 'emoji/nu.png', title: '怒' },
  { src: 'emoji/wuzuixiao.png', title: '捂嘴笑' },
  { src: 'emoji/waizui%403x.png', title: '歪嘴' },
  { src: 'emoji/suanshuang.png', title: '酸爽' },
  { src: 'emoji/shengli.png', title: '胜利' },
  { src: 'emoji/ruo.png', title: '弱' },
  { src: 'emoji/pen.png', title: '喷' },
  { src: 'emoji/ok.png', title: 'OK' },
  { src: 'emoji/nidongde.png', title: '你懂的' },
  { src: 'emoji/meigui.png', title: '玫瑰' },
  { src: 'emoji/lei.png', title: '累' },
  { src: 'emoji/lazhu.png', title: '蜡烛' },
  { src: 'emoji/kuanghan.png', title: '狂汗' },
  { src: 'emoji/ku.png', title: '酷' },
  { src: 'emoji/jingku.png', title: '惊哭' },
  { src: 'emoji/huaxin.png', title: '花心' },
  { src: 'emoji/huaji.png', title: '滑稽' },
  { src: 'emoji/horse@3x.png', title: '马' },
  { src: 'emoji/heixian.png', title: '黑线' },
  { src: 'emoji/hehe.png', title: '呵呵' },
  { src: 'emoji/han.png', title: '汗' },
  { src: 'emoji/guai.png', title: '乖' },
  { src: 'emoji/eagle@3x.png', title: '歪头' },
  { src: 'emoji/damuzhi.png', title: '大拇指' },
  { src: 'emoji/bulls@3x.png', title: '牛' },
  { src: 'emoji/bugaoxing.png', title: '不高兴' },
  { src: 'emoji/bishi.png', title: '鄙视' },
  { src: 'emoji/aixin.png', title: '爱心' },
  { src: 'emoji/aa.png', title: '惊讶' },
  { src: 'emoji/86@3x.png', title: '无语' },
  { src: 'emoji/27@3x.png', title: '捂嘴哭' },
  { src: 'emoji/1f60c.png', title: '乖' },
  { src: 'emoji/dogtushe.png', title: '狗吐舌' },
  { src: 'emoji/heito.png', title: '黑头' },
  { src: 'emoji/hejiu.png', title: '喝酒' },
  { src: 'emoji/huanhu.png', title: '欢呼' },
  { src: 'emoji/lvmaozi.png', title: '绿帽子' },
  { src: 'emoji/tiaopi.png', title: '调皮' },
  { src: 'emoji/tu.png', title: '吐' },
  { src: 'emoji/weiweiyixiao.png', title: '微微一笑' },
  { src: 'emoji/yi (2).png', title: '咦' },
  { src: 'emoji/yi.png', title: '哇' },
  { src: 'emoji/hot_face.gif', title: '发烧' }
]
</script>
<style scoped>
@import '@/css/detail.css';
</style>
<style>
.content-right-main {
  display: block;
  width: 100%;
  height: 100%;
}

p {
  font-size: 1.1rem;
  color: #34495e;
  font-family:
    -apple-system,
    BlinkMacSystemFont,
    Segoe UI,
    Roboto,
    Oxygen-Sans,
    Ubuntu,
    Cantarell,
    Helvetica Neue,
    sans-serif;
  margin-bottom: 26px;
  line-height: 2.6rem !important;
  letter-spacing: 0.2px;
  text-indent: 2rem;
}
code {
  font-size: 17px;
  border-radius: 15px;
}
</style>
<style>
.addComment {
  position: relative;
  right: 0px;
  left: 90%;
  height: 2rem;

  background: linear-gradient(135deg, #002ef9 0%, #f700ff 100%);
  -webkit-background-clip: text; /*将设置的背景颜色限制在文字中*/
  -webkit-text-fill-color: transparent; /*给文字设置成透明*/
  font-size: 20px;
  font-family: Microsoft Yahei;
}
.block {
  display: flex;
}
.twoComment {
  margin-left: 30px;
}
.form-top {
  display: flex;
  justify-content: space-around;
  margin-bottom: 30px;
}
.comment-form {
  height: auto;
  width: 90%;
  /* display: block; */
  margin: 10px;
  padding: 30px;
  border-radius: 25px;
  background-color: #ffffff;
}
.comment-body {
  height: auto;
  width: 90%;
  display: block;
  margin: 10px;
  padding: 30px;
  border-radius: 25px;
  background-image: linear-gradient(90deg, #3a9dff 0%, #c48ef7 100%);
}
.qqImg {
  height: 3rem;
  border-radius: 50%;
  margin-right: 10px;
}
name {
  height: 3rem;
  line-height: 3rem;
  background: linear-gradient(135deg, #002ef9 0%, #f700ff 100%);
  -webkit-background-clip: text; /*将设置的背景颜色限制在文字中*/
  -webkit-text-fill-color: transparent; /*给文字设置成透明*/
  font-size: 20px;

  font-family: Microsoft Yahei;
}
.huifu {
  margin-left: 10px;
  margin-right: 10px;
  height: 3rem;
  color: #002ef9;
  line-height: 3rem;
}
.comment {
  width: 100%;
  /* margin: 10px; */
  margin-bottom: 10px;
  padding: 10px;
  display: block;
  background-image: linear-gradient(90deg, #8ec5fc 0%, #e0c3fc 100%);
  border-radius: 10px;
  box-shadow: 0 10px 20px #00000026;
  text-shadow: 0px 0px 20px #ffffff;
  color: #fff;
  box-sizing: border-box;
}

.comment-info {
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
.comment .comment-content {
  font-size: 20px;
  margin: 15px;
  word-wrap: break-word;
  width: 80%;
}
</style>
<style>
.emoji:hover {
  height: 35px;
  width: 35px;
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
.emoji-box {
  display: flex;

  flex-wrap: wrap;
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
</style>
<style>
.comment-form-main-hide {
  max-height: 0;

  background-color: rgb(255, 255, 255);
  flex-wrap: wrap;
  border-radius: 15px;
  overflow: hidden;
  transition: max-height 0.5s;
}
.comment-form-main {
  transition: max-height 0.5s;
  max-height: 500px;

  background-color: rgb(255, 255, 255);
  flex-wrap: wrap;
  border-radius: 15px;
  overflow: hidden;
  width: auto;
  height: auto;
}
</style>
