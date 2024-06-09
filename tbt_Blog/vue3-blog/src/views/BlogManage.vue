<template>
  <div class="manage-body">
    <div id="main">
      <div id="click-section">
        <div id="drawerboxes">
          <div class="drawerbox active">
            <button class="drawer-btn active" @click="slideTo(1)">
              文章管理<span class="drawer-head">1</span>
            </button>
          </div>
          <div class="drawerbox">
            <button class="drawer-btn" @click="slideTo(2)">
              分类管理<span class="drawer-head">2</span>
            </button>
          </div>
          <div class="drawerbox">
            <button class="drawer-btn" @click="slideTo(3)">
              图片管理<span class="drawer-head">3</span>
            </button>
          </div>
          <div class="drawerbox">
            <button class="drawer-btn" @click="slideTo(4)">
              留言管理<span class="drawer-head">4</span>
            </button>
          </div>
        </div>
      </div>
      <div id="slide-section">
        <div id="slide-bar">
          <div id="bar"></div>
        </div>
        <div id="card-section">
          <div id="card1" class="manage-card">
            <div class="BlogManage">
              <el-button type="primary" @click="addBlog">发布文章</el-button>
              <el-scrollbar height="600px">
                <el-table :data="articleList" style="width: 100%">
                  <el-table-column label="文章标题" width="200">
                    <template #default="{ row }">
                      <el-link type="primary" :underline="false">{{ row.title }}</el-link>
                    </template>
                  </el-table-column>
                  <el-table-column label="作者" prop="createUser"></el-table-column>
                  <el-table-column label="发表时间" prop="createTime"> </el-table-column>
                  <el-table-column label="分类" prop="type"></el-table-column>
                  <el-table-column label="标签" prop="labelList.length"></el-table-column>
                  <el-table-column label="操作" width="150">
                    <template #default="{ row }">
                      <el-button
                        :icon="Edit"
                        circle
                        plain
                        type="primary"
                        @click="onEditArticle(row)"
                      >
                      </el-button>
                      <el-button type="primary" circle plain @click="onHideArticle(row)"
                        ><el-icon><TurnOff /></el-icon>
                      </el-button>
                      <el-button
                        :icon="Delete"
                        circle
                        plain
                        type="danger"
                        @click="onDeleteArticle(row)"
                      ></el-button>
                    </template>
                  </el-table-column>
                  <template #empty>
                    <el-empty description="没有数据" />
                  </template>
                </el-table>
              </el-scrollbar>
              <!-- 分页
              <el-pagination
                layout="prev, pager, next"
                :total="50"
                :page-size="10"
                @change="changePage"
                v-model:current-page="currentPage"
              /> -->
            </div>
          </div>
          <div id="card2" class="manage-card">
            <div class="TypeManage">
              <el-input v-model="input" style="width: 240px" placeholder="Please input" />

              <el-button type="primary" @click="addType">新增分类</el-button>
              <el-table :data="typeList" style="width: 100%">
                <el-table-column label="分类名" prop="name"></el-table-column>
                <el-table-column label="操作" width="100">
                  <template #default="{ row }">
                    <el-button :icon="Edit" circle plain type="primary" @click="onEditType(row)">
                    </el-button>
                    <el-button
                      :icon="Delete"
                      circle
                      plain
                      type="danger"
                      @click="onDeleteType(row)"
                    ></el-button>
                  </template>
                </el-table-column>
                <template #empty>
                  <el-empty description="没有数据" />
                </template>
              </el-table>
            </div>
          </div>
          <div id="card3" class="manage-card">
            <el-upload
              v-model:file-list="fileList"
              action="http://localhost:9090/file/addFile"
              list-type="picture-card"
              :on-preview="handlePictureCardPreview"
              :on-remove="handleRemove"
            >
              <el-icon><Plus /></el-icon>
            </el-upload>

            <el-dialog v-model="dialogVisible">
              <img w-full :src="dialogImageUrl" alt="Preview Image" />
            </el-dialog>
            <textarea placeholder="说说内容" v-model="essay"></textarea>
            <el-button @click="addEssay">添加</el-button>
          </div>
          <div id="card4" class="manage-card">
            <div class="TypeManage">
              <el-table :data="messageList" style="width: 100%">
                <el-table-column label="留言者" prop="name"></el-table-column>
                <el-table-column label="留言内容" prop="message"></el-table-column>
                <el-table-column label="操作" width="100">
                  <template #default="{ row }">
                    <el-button
                      :icon="Delete"
                      circle
                      plain
                      type="danger"
                      @click="onDeleteMessage(row)"
                    ></el-button>
                  </template>
                </el-table-column>
                <template #empty>
                  <el-empty description="没有数据" />
                </template>
              </el-table>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { Delete, Edit } from '@element-plus/icons-vue'
import { ref } from 'vue'
import axios from 'axios'
import { useRouter } from 'vue-router'
import { ElMessage, ElMessageBox } from 'element-plus'
const router = useRouter()

const params = ref({
  cate_id: '',
  state: ''
})
const currentPage = ref(1)
var articleList = ref('')
var typeList = ref('')
var messageList = ref('')
var essay = ref('')
const input = ref('')
const create = () => {
  axios
    .get('http://localhost:9090/user/article/page?pageNo=1&pageSize=100&isAsc=false')

    .then((res) => {
      articleList.value = res.data.data
    })

  axios
    .get('http://localhost:9090/type/page?pageNo=1&pageSize=10&isAsc=false')

    .then((res) => {
      typeList.value = res.data.data
    })
  axios
    .get('http://localhost:9090/message/getAll')

    .then((res) => {
      messageList.value = res.data.data
    })
}
function addEssay() {
  const data = new FormData()

  data.append('content', essay.value)
  axios.post(`http://localhost:9090/user/essay/add`, data)
}
create()
function changePage() {
  const pageNo = currentPage.value
  axios
    .get(`http://localhost:9090/user/article/page?pageNo=${pageNo}&pageSize=10&isAsc=false`)
    .then((res) => {
      articleList.value = res.data.data
    })
}
function addBlog() {
  router.push({ path: '/editor' })
}
function addType() {
  axios.post(`http://localhost:9090/type/add?name=${input.value}`).then((res) => {
    create()
  })
}
function onEditArticle(row) {
  // alert(row.id)
  router.push({ path: '/editor', query: { id: row.id } })
  // $router.push(`/editor?id=${row.id}`)
}

function onDeleteArticle(row) {
  const id = row.id

  axios.post(`http://localhost:9090/admin/article/delete/${id}`).then((res) => {
    create()
  })
}
function onDeleteType(row) {
  const id = row.id

  axios.post(`http://localhost:9090/type/delete/${id}`).then((res) => {
    create()
  })
}
function onEditType(row) {
  const id = row.id
  ElMessageBox.prompt('Please input your type', 'Tip', {
    confirmButtonText: 'OK',
    cancelButtonText: 'Cancel'
  })
    .then(({ value }) => {
      ElMessage({
        type: 'success',
        message: `成功修改为:${value}`
      })
      const data = new FormData()
      data.append('id', id)
      data.append('name', value)

      axios.post(`http://localhost:9090/type/update`, data).then((res) => {
        create()
      })
    })
    .catch(() => {
      ElMessage({
        type: 'info',
        message: 'Input canceled'
      })
    })
}
function onHideArticle(row) {}
function onDeleteMessage(row) {}
// 切换抽屉面板状态
function drawerboxToggle(drawerboxNumber) {
  let prevDrawerboxNumber = chosenSlideNumber.value
  const drawerboxes = document.querySelectorAll('.drawerbox')
  drawerboxes[prevDrawerboxNumber - 1].classList.toggle('active') // 切换前一个抽屉面板的状态
  drawerboxes[drawerboxNumber - 1].classList.toggle('active') // 切换当前抽屉面板的状态
}

const chosenSlideNumber = ref(1) // 当前选择的幻灯片编号
const offset = ref(0) // 幻灯片偏移量
const barOffset = ref(0) // 导航条偏移量
// 切换到指定编号的幻灯片
function slideTo(slideNumber) {
  drawerboxToggle(slideNumber) // 切换抽屉面板状态
  drawerbtnToggle(slideNumber) // 切换抽屉按钮状态
  // 更新偏移量
  let previousSlideNumber = chosenSlideNumber.value
  chosenSlideNumber.value = slideNumber
  offset.value += (chosenSlideNumber.value - previousSlideNumber) * -100 // 计算幻灯片偏移量
  barOffset.value += (chosenSlideNumber.value - previousSlideNumber) * 100 // 计算导航条偏移量
  barSlide(barOffset.value) // 移动导航条
  // 获取所有幻灯片，为每个幻灯片设置偏移量
  const slides = document.querySelectorAll('.manage-card')
  Array.from(slides).forEach((slide) => {
    slide.style.transform = `translateY(${offset.value}%)`
  })
}

// 切换抽屉按钮状态
function drawerbtnToggle(drawerBtnNumber) {
  let prevDrawerBtnNumber = chosenSlideNumber.value
  const drawerBtns = document.querySelectorAll('.drawer-btn')
  drawerBtns[prevDrawerBtnNumber - 1].classList.toggle('active') // 切换前一个抽屉按钮的状态
  drawerBtns[drawerBtnNumber - 1].classList.toggle('active') // 切换当前抽屉按钮的状态
}
// 移动导航条
function barSlide(barOffset) {
  const bar = document.querySelector('#bar')
  bar.style.transform = `translateY(${barOffset}%)`
}

import type { UploadProps, UploadUserFile } from 'element-plus'

const fileList = ref<UploadUserFile[]>([])

const dialogImageUrl = ref('')
const dialogVisible = ref(false)

const handleRemove: UploadProps['onRemove'] = (uploadFile, uploadFiles) => {
  // 删除图片
}

const handlePictureCardPreview: UploadProps['onPreview'] = (uploadFile) => {
  dialogImageUrl.value = uploadFile.url!
  dialogVisible.value = true
}
</script>
<style>
.BlogManage {
  display: block;
  width: 100%;
  background-color: rgb(255, 255, 255);
}
.TypeManage {
  display: block;
  width: 100%;
  background-color: rgb(255, 255, 255);
}
.manage-body {
  display: flex;
  justify-content: center;
  align-items: center;
  /* background-image: url(./img/bg.jpg); */
  background-size: cover;
}

#main {
  height: 100vh;

  width: 100vw;
  display: flex;
  /* justify-content: center;
      align-items: center; */
}

#click-section {
  width: 25%;
  height: 100%;
  /* padding: 20px 0; */
  /* position: relative; */
}

#drawerboxes {
  margin-left: 10%;
  width: 100%;
  height: 100%;
  position: relative;
  overflow: hidden;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
}

#drawerboxes::before {
  content: '';
  width: 8px;
  height: 94%;
  position: absolute;
  left: -10px;
  top: 3%;
  z-index: 120;
}

.drawerbox {
  height: calc(100% / 5.5);
  width: 70%;
  position: relative;
  z-index: 100;
  transform: translateX(-70%);
  transition: transform 0.5s ease-in-out;
}

.drawerbox.active {
  transform: translateX(0);
}

.drawer-btn {
  width: 100%;
  height: 100%;
  font: 800 30px '';
  background-color: rgb(175, 190, 255);
  border: none;
  transition: background-color 0.5s ease-in-out;
  color: #ffffff00;
}

.drawer-btn.active {
  /* background-image: url(./img/bg.jpg); */
  background-size: cover;
  color: rgb(70, 100, 180);
}

.drawer-btn:hover {
  cursor: pointer;
}

.drawer-head {
  position: absolute;
  color: rgb(255, 255, 255);
  font-size: 200px;
  font-weight: 700;
  right: -38px;
  top: calc(50% - 135px);
  text-shadow: 2px -1px 8px rgba(250, 80, 193, 0.323);
}

#slide-section {
  position: relative;
  height: 100%;
  width: 75%;
  display: flex;
  justify-content: center;
  /* padding: 0 40px; */
  background: linear-gradient(
    to right bottom,
    rgba(255, 255, 255, 0.6),
    rgba(255, 255, 255, 0.3),
    rgba(255, 255, 255, 0.2)
  );
  /* background-color: rgb(255, 255, 255); */
  backdrop-filter: blur(11px);
}

#slide-bar {
  position: absolute;
  top: 10%;
  left: 40px;
  height: 80%;
  width: 1px;
  background-color: rgb(223, 223, 223);
}

#bar {
  position: absolute;
  height: calc(100% / 4);
  width: 5px;
  top: 0;
  left: -1.2px;
  background-color: rgb(85, 115, 246);
  transition: transform 0.5s ease-in-out;
}

#card-section {
  height: 100%;
  width: 80%;
  overflow: hidden;
}

.manage-card {
  display: flex;
  flex-direction: column;
  height: 100%;
  width: 100%;
  padding: 10% 0;
  color: white;
  font-size: 30px;
  transition: transform 0.5s ease-in-out;
}
</style>
