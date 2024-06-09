<template>
  <div :class="emojiShow == true ? 'emoji-main' : 'emoji-main-hide'">
    <el-scrollbar height="200">
      <div
        class="emoji-box"
        oncontextmenu="return false"
        oncopy="return false"
        onselectstart="return false"
      >
        <div class="emoji-body" v-for="(emo, index) in this.emoji" :key="index">
          <img :src="this.ossKey + emo.src" class="emoji" @click="addEmoji(index)" />
        </div>
      </div>
    </el-scrollbar>
  </div>
</template>
<script>
export default {
  props: {
    emojiShow: {
      type: Boolean
    },
    content: String
  },
  data() {
    return {
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
  methods: {
    addEmoji(id) {
      var emojiStr = '::(' + this.emoji[id].title + '):'
      this.$emit('getSonContent', emojiStr)
    },
    translate(messageList) {
      var pattern = /\:\:\([\u4e00-\u9fa5]+\)\:/g
      var pattern2 = /\:\:\([\u4e00-\u9fa5]+\)\:/
      for (var i = 0; i < messageList.length; i++) {
        var cont = messageList[i].message
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
  width: 2.5rem;" class="message-img" />`
            cont = cont.replace(pattern2, imgText)
          }
        }
        messageList[i].message = cont
      }
      return messageList
    }
  }
}
</script>

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
