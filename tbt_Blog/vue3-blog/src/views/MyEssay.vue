<template>
  <div class="essay-main">
    <div class="essays">
      <div v-for="(essay, index) in essayList" :key="index" class="essay">
        <div class="content">
          <div v-html="essay.content"></div>
        </div>
      </div>
    </div>
  </div>
  <BlogFooter></BlogFooter>
</template>

<script>
import axios from 'axios'
import BlogFooter from '@/components/BlogFooter.vue'
export default {
  data() {
    return {
      emojiShow: false,
      essayList: [],
      username: '',
      essay: '',
      ossKey: 'https://tbt-blog.oss-cn-beijing.aliyuncs.com/',
      emoji: [
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
    }
  },
  created() {
    this.getAll()
  },
  methods: {
    getAll() {
      axios.get('http://localhost:9090/user/essay/get/all').then((res) => {
        this.essayList = res.data.data
        var pattern = /\:\:\([\u4e00-\u9fa5]+\)\:/g
        var pattern2 = /\:\:\([\u4e00-\u9fa5]+\)\:/
        for (var i = 0; i < this.essayList.length; i++) {
          var cont = this.essayList[i].essay
          var content = cont.match(pattern)
          console.log(cont)
          if (content) {
            for (var k = 0; k < content.length; k++) {
              for (var j = 0; j < this.emoji.length; j++) {
                if ('::(' + this.emoji[j].title + '):' == content[k]) {
                  var src = this.ossKey + this.emoji[j].src
                  break
                }
              }
              var imgText =
                `<img  src="` +
                src +
                `" style="height: 2.5rem;
  width: 2.5rem;" class="essay-img" />`
              cont = cont.replace(pattern2, imgText)
            }
          }
          console.log(cont)
          this.essayList[i].essay = cont
        }
      })
    },
    addEmoji(id) {
      this.essay += '::(' + this.emoji[id].title + '):'
    }
  },
  components: {
    BlogFooter
  }
}
</script>

<style scoped>
@media only screen and (min-width: 414px) {
  .essay-main {
    border-radius: 25px;
    height: auto;
    display: flex;
    border: 40px;
    justify-content: center;
    align-items: center;
  }

  .essay {
    width: 100%;
    margin: 10px;
    padding: 10px;
    margin: 70px 0;
    border-radius: 10px;
    color: #000000;
    background-color: aliceblue;
    box-sizing: border-box;
  }
  .essays .content {
    font-size: 15px;
    margin: 15px;

    width: 80%;
  }
}
</style>
