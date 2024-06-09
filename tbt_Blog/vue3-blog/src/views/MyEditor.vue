<template>
  <div class="addBlog">
    <!-- 发表文章表单 -->
    <el-form ref="formRef" label-width="100px">
      <el-form-item label="文章标题" prop="title">
        <el-input placeholder="请输入标题" v-model="title"></el-input>
      </el-form-item>

      <el-form-item label="文章描述">
        <el-input
          v-model="description"
          style="width: 100%"
          :rows="2"
          type="textarea"
          placeholder="Please input"
        />
      </el-form-item>
      <el-form-item label="文章标签">
        <el-tag
          v-for="tag in dynamicTags"
          :key="tag"
          closable
          :disable-transitions="false"
          @close="handleClose(tag)"
        >
          {{ tag }}
        </el-tag>
        <el-input
          v-if="inputVisible"
          ref="InputRef"
          v-model="inputValue"
          class="w-20"
          size="small"
          @keyup.enter="handleInputConfirm"
          @blur="handleInputConfirm"
        />
        <el-button v-else class="button-new-tag" size="small" @click="showInput">
          + New Tag
        </el-button>
      </el-form-item>
      <el-form-item label="文章分类">
        <el-select v-model="type" :placeholder="type" style="width: 240px">
          <el-option v-for="item in options" :key="item.id" :label="item.name" :value="item.id"
        /></el-select>
      </el-form-item>

      <el-form-item label="文章封面">
        <el-upload
          class="avatar-uploader"
          action="http://localhost:9090/file/addFile"
          :show-file-list="false"
          :before-upload="beforeAvatarUpload"
          :on-change="onSelectFile"
          :on-success="uploadSuccess"
          name="file"
        >
          <img v-if="coverImg" :src="coverImg" class="avatar" />
          <el-icon v-else class="avatar-uploader-icon"><Plus /></el-icon>
        </el-upload>
      </el-form-item>
      <el-form-item label="文章内容" prop="content">
        <el-button @click="isMarkdown = !isMarkdown">切换</el-button>
        <mavon-editor
          v-if="isMarkdown"
          style="height: 500px"
          ref="mavonEditorRef"
          v-model="valueHtml"
          :ishljs="true"
          @imgAdd="imgAdd"
          @change="changeData"
        />
        <div v-if="!isMarkdown" style="border: 1px solid #ccc">
          <Toolbar
            style="border-bottom: 1px solid #ccc"
            :editor="editorRef"
            :defaultConfig="toolbarConfig"
            :mode="mode"
          />
          <Editor
            style="height: 500px; overflow-y: hidden"
            v-model="valueHtml"
            :defaultConfig="editorConfig"
            :mode="mode"
            @onCreated="handleCreated"
          />
        </div>
      </el-form-item>
      <el-form-item>
        <el-button @click="primary" type="primary">发布</el-button>
        <el-button @click="cancel" type="cancel">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script lang="ts" setup>
import { ref } from 'vue'
import axios from 'axios'
import { ElMessage } from 'element-plus'
import { Plus } from '@element-plus/icons-vue'
import type { UploadProps } from 'element-plus'
import '@vueup/vue-quill/dist/vue-quill.snow.css'
import { useRouter } from 'vue-router'
import { onBeforeUnmount, shallowRef, onMounted } from 'vue'
import '@wangeditor/editor/dist/css/style.css' // 引入 css
import { Editor, Toolbar } from '@wangeditor/editor-for-vue'
const router = useRouter()
const coverImg = ref('')
const fileUrl = ref('')
const type = ref(0)
const onSelectFile = (uploadFile) => {
  coverImg.value = URL.createObjectURL(uploadFile.raw)
}

const title = ref('')
const isMarkdown = ref(true)
const description = ref('')
const blogId = ref('')
const editorRef = shallowRef()
const valueHtml = ref('<p>hello</p>')
import 'highlight.js/styles/stackoverflow-light.css'
import 'highlight.js/lib/common'
import hljs from 'highlight.js'
// wangditor
//定义指令，自动使用highlight.js渲染所有<pre><dode>代码块
const vHigelight = {
  mounted(el: any) {
    let blocks = el.querySelectorAll('pre code')
    blocks.forEach((block: HTMLElement) => {
      block.setAttribute('style', 'margin-top: 8px;')
      hljs.highlightBlock(block)
    })
  }
}
const editorConfig = {
  MENU_CONF: {}
}
editorConfig.MENU_CONF['codeSelectLang'] = {
  // 代码语言
  codeLangs: [
    { text: 'CSS', value: 'css' },
    { text: 'HTML', value: 'html' },
    { text: 'XML', value: 'xml' }
    // 其他
  ]
}
editorConfig.MENU_CONF['uploadImage'] = {
  async customUpload(file, insertFn) {
    const data = new FormData()
    data.append('file', file)

    axios.post('http://localhost:9090/file/addFile', data).then((res) => {
      const url = res.data
      const alt = '图片无法显示'
      const href = url
      insertFn(url, alt, href)
    })
  }
}
// 自定义校验视频
function customCheckVideoFn(src, poster) {
  // JS 语法
  if (!src) {
    return
  }
  if (src.indexOf('http') !== 0) {
    return '视频地址必须以 http/https 开头'
  }
  return true
}

// 自定义转换视频
function customParseVideoSrc(src: string): string {
  // TS 语法
  // function customParseVideoSrc(src) {               // JS 语法
  if (src.includes('.bilibili.com')) {
    // 转换 bilibili url 为 iframe （仅作为示例，不保证代码正确和完整）

    return `<iframe src="${src}" scrolling="no" border="0" frameborder="no" framespacing="0" allowfullscreen="true"> </iframe>`
  }
  return src
}

editorConfig.MENU_CONF['insertVideo'] = {
  onInsertedVideo(videoNode: VideoElement | null) {
    // TS 语法
    // onInsertedVideo(videoNode) {                    // JS 语法
    if (videoNode == null) return

    const { src } = videoNode
    console.log('inserted video', src)
  },
  checkVideo: customCheckVideoFn, // 也支持 async 函数
  parseVideoSrc: customParseVideoSrc // 也支持 async 函数
}
editorConfig.MENU_CONF['uploadVideo'] = {
  async customUpload(file, insertFn) {
    const data = new FormData()
    data.append('file', file)

    axios.post('http://localhost:9090/file/addFile', data).then((res) => {
      const url = res.data
      insertFn(url, poster)
    })
  }
}
onBeforeUnmount(() => {
  const editor = editorRef.value
  if (editor == null) return
  editor.destroy()
})

const handleCreated = (editor) => {
  editorRef.value = editor // 记录 editor 实例，重要！
}
function uploadSuccess(res) {
  // alert(res)
  fileUrl.value = res
}

// 分类
var options = ref('')
// onMounted(() => {

onMounted(() => {
  // 查询所有分类
  axios.get(`http://localhost:9090/type/getAll`).then((res) => {
    options.value = res.data.data
    // 回显
    if (router.currentRoute.value.query.id) {
      const id = router.currentRoute.value.query.id
      axios.get(`http://localhost:9090/user/article/${id}`).then((res) => {
        title.value = res.data.data.title
        description.value = res.data.data.description
        valueHtml.value = res.data.data.content
        fileUrl.value = res.data.data.coverImg
        coverImg.value = res.data.data.coverImg
        dynamicTags.value = res.data.data.LabelList
        for (var i = 0; i < options.value.length; i++) {
          if (res.data.data.type == options.value[i].name) {
            type.value = options.value[i].id
            break
          }
        }
      })
    }
  })
})
// })
const mavonEditorRef = ref()

const imgAdd = (pos: any, $file: any) => {
  const formData = new FormData()
  formData.append('file', $file)
  axios.post('http://localhost:9090/file/addFile', formData).then((res) => {
    const url = res.data
    // pos = 1
    mavonEditorRef.value.$img2Url(pos, url)
  })
}

const dynamicTags = ref([])
onBeforeUnmount(() => {
  const editor = editorRef.value
  if (editor == null) return
  editor.destroy()
})

function primary() {
  if (title.value == '') {
    alert('请输入标题')
    return
  }
  if (valueHtml.value == '') {
    alert('请输入内容')
    return
  }
  if (description.value == '') {
    alert('请输入描述')
    return
  }
  if (type.value == '') {
    alert('请添加类型')
    return
  }
  if (coverImg.value == '') {
    alert('请添加封面')
    return
  }
  if (router.currentRoute.value.query.id) {
    const id = router.currentRoute.value.query.id
    const data = new FormData()
    data.append('id', id)
    data.append('title', title.value)
    data.append('description', description.value)
    data.append('content', valueHtml.value)
    data.append('coverImg', fileUrl.value)
    data.append('type', type.value)
    data.append('label', dynamicTags.value)
    axios.post('http://localhost:9090/admin/article/update', data)
    router.push({ path: '/manage' })
  } else {
    const data = new FormData()
    data.append('title', title.value)
    data.append('description', description.value)
    data.append('content', valueHtml.value)
    data.append('coverImg', fileUrl.value)
    data.append('label', dynamicTags.value)
    data.append('type', type.value)
    axios.post('http://localhost:9090/admin/article/upload', data)
    router.push({ path: '/manage' })
  }
}
function cancel() {
  router.push({ path: '/manage' })
}
// function changeData(value, render) {
//   // value中是文本值,render是渲染出的html文本
//   // valueHtml.value = render;
//   // console.log(render)
// }
</script>

<style scoped>
.avatar-uploader .avatar {
  width: 178px;
  height: 178px;
  display: block;
}
.editor {
  width: 100%;
}
</style>

<style>
.ql-editor {
  height: 300px;
}
.addBlog {
  background-color: aliceblue;
  margin: auto;
  width: 70%;
  border-radius: 15px;
  padding: 50px;
}
.avatar-uploader .el-upload {
  border: 1px dashed var(--el-border-color);
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition: var(--el-transition-duration-fast);
}

.avatar-uploader .el-upload:hover {
  border-color: var(--el-color-primary);
}

.el-icon.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  text-align: center;
}
</style>
