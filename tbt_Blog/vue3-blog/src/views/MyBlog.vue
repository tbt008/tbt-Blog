<template>
  <loading v-if="isloading"></loading>

  <div class="abm-main" v-if="!isloading">
    <div class="abm-left">
      <div class="abm-left-router-1">
        <div class="abm-left-router-title">说说</div>
        <div class="abm-left-router-desc">分享此刻心情</div>
      </div>
      <div class="abm-left-router-2">
        <div class="abm-left-router-title">生活倒影</div>
        <div class="abm-left-router-desc">记录生活的美好瞬间</div>
      </div>
      <div class="abm-left-router-3">
        <div class="abm-left-router-title">学习</div>
        <div class="abm-left-router-desc">学习不止于此</div>
      </div>
      <div class="abm-left-2">
        <h3 class="left-content-title">标签</h3>
        <el-tag
          class="label"
          v-for="label in labels"
          :key="label.id"
          :type="label.type"
          effect="light"
        >
          {{ label.name }} {{ label.count }}</el-tag
        >
      </div>
      <div class="abm-left-3">
        <h3 class="left-content-title">最新推荐</h3>
        <div
          class="newArticle"
          v-for="item in newArticle"
          :key="item.id"
          @click="$router.push(`/blog/detail?id=${item.id}`)"
        >
          <img style="border-radius: 10px" :src="item.coverImg" />
          <div class="font">
            <div class="newArticle-time">{{ item.createTime }}</div>
            <div class="newArticle-title">{{ item.title }}</div>
          </div>
        </div>
      </div>
    </div>

    <div class="abm-right">
      <div class="type-tab" v-bind:style="{ height: isOpen }">
        <ul class="tab">
          <li class="tab-active">
            <span @click="QueryTypeAll" class="first-tab" v-bind:class="{ select: isSelect == -1 }">
              全部</span
            >
          </li>
          <div
            class="classify"
            v-for="classify in classifys"
            :key="classify.id"
            :type="classify.type"
            @click="QueryByTypeId(classify.id)"
          >
            <li class="">
              <span v-bind:class="{ select: isSelect == classify.id }">{{ classify.name }}</span
              ><b></b>
            </li>
          </div>
        </ul>
        <div class="tab-expander" @click="change_open">
          <el-icon :size="25" v-if="!type_open"> <ArrowDown /></el-icon>
          <el-icon :size="25" v-if="type_open"><ArrowUp /></el-icon>
        </div>
      </div>
      <div
        v-for="item in articles"
        :key="item.id"
        @click="$router.push(`/blog/detail?id=${item.id}`)"
        class="abm-right-content"
      >
        <div class="abm-right-content-left">
          <img :src="item.coverImg" />
        </div>
        <div class="abm-right-content-right">
          <div class="show-type-blog">#{{ item.type }}</div>
          <h1 class="content-title">{{ item.title }}</h1>

          <div class="content-mid">{{ item.description }}</div>
          <div class="content-foot">
            作者 : {{ item.createUser }}
            <svg
              t="1716452560983"
              class="icon"
              viewBox="0 0 1024 1024"
              version="1.1"
              xmlns="http://www.w3.org/2000/svg"
              p-id="2826"
              width="20"
              height="20"
            >
              <path
                d="M510.364757 66.029856c-247.466138 0-448.073038 200.606901-448.073038 448.074062S262.897595 962.176956 510.364757 962.176956c247.462045 0 448.073038-200.606901 448.073038-448.073038S757.826801 66.029856 510.364757 66.029856zM662.781098 684.286901l-15.839757 15.84385c-8.751315 8.746198-22.936385 8.746198-31.683607 0L469.961558 554.833551c-5.021364-5.021364-4.40431-15.114233-4.40431-25.047466L465.557248 245.25989c0-12.375865 10.032494-22.403243 22.403243-22.403243l22.403243 0c12.371772 0 22.403243 10.027377 22.403243 22.403243l0 277.326213 130.013099 130.017192C671.532413 661.353586 671.532413 675.535587 662.781098 684.286901z"
                fill="#FF7A20"
                p-id="2827"
              ></path>
            </svg>

            发布于 : {{ item.createTime }}
          </div>
        </div>
      </div>
      <div class="loadPage" v-if="articles.length >= 5 && !isBottom">
        <el-button type="primary" @click="changePage" class="select">加载更多</el-button>
      </div>
      <div class="isBottom" v-else></div>
    </div>

    <el-backtop :right="100" :bottom="100" />
  </div>
  <BlogFooter></BlogFooter>
</template>
<script>
import loading from '@/components/loading.vue'
import BlogFooter from '@/components/BlogFooter.vue'
import axios from 'axios'
export default {
  name: 'ArticlePage',
  data() {
    return {
      isSelect: -1,
      isOpen: '3.5rem',
      type_open: false,
      articles: [],
      currentPage: 1,
      newBlog: [],
      isAsc: false,
      classifys: [],
      isloading: true,
      labels: [],
      isBottom: false
    }
  },
  components: {
    loading,
    BlogFooter
  },
  methods: {
    change_open() {
      if (this.type_open == false) {
        this.isOpen = 'auto'
      } else {
        this.isOpen = '3.5rem'
      }

      this.type_open = !this.type_open
    },
    QueryTypeAll() {
      this.isSelect = -1
      this.isBottom = false
      axios
        .get('http://localhost:9090/user/article/page?pageNo=1&pageSize=5&isAsc=false')
        .then((res) => {
          if (res.data.data.length == 0) {
            this.isBottom = true
          }
          this.articles = res.data.data
        })
    },
    QueryByTypeId(id) {
      this.isBottom = false
      this.isSelect = id
      axios
        .get(
          `http://localhost:9090/user/article/page?typeId=${this.isSelect}&pageNo=1&pageSize=5&isAsc=false`
        )
        .then((res) => {
          if (res.data.data.length == 0) {
            this.isBottom = true
          }
          this.articles = res.data.data
        })
      this.currentPage = 1
    },
    addBlog() {
      this.$router.push('/editor')
    },
    changePage() {
      this.currentPage += 1
      const pageNo = this.currentPage
      if (this.isSelect == -1) {
        // 查询所有
        axios

          .get(
            `http://localhost:9090/user/article/page?pageNo=${pageNo}&pageSize=5&isAsc=false`
          )
          .then((res) => {
            // console.log(res.data.data)
            if (res.data.data.length == 0) {
              this.isBottom = true
            }
            this.articles = this.articles.concat(res.data.data)
          })
      } else {
        const isSelect = this.isSelect
        axios
          // 60.205.254.145
          .get(
            `http://localhost:9090/user/article/page?typeId=${isSelect}&pageNo=${pageNo}&pageSize=5&isAsc=false`
          )
          .then((res) => {
            if (res.data.data.length == 0) {
              this.isBottom = true
            }
            this.articles = this.articles.concat(res.data.data)
          })
      }
    }
  },
  changeAsc() {
    if (this.isAsc == false) {
      this.isAsc = true
    } else {
      this.isAsc = false
    }
  },
  async created() {
    this.isloading = false
    const res = await axios.get(
      'http://localhost:9090/user/article/page?pageNo=1&pageSize=5&isAsc=false'
    )

    this.articles = res.data.data
    this.newArticle = res.data.data.slice(0, 3)
    
    // 标签
    const res1 = await axios.get('http://localhost:9090/label/getAll')
    var type = ['primary', 'success', 'info', 'warning', 'danger']
    this.labels = res1.data.data

    const ids = this.labels.map((label) => label.id)
    // 标签对于文章数
    const res1s = await axios.get(`http://localhost:9090/label/BatchCount?ids=${ids}`)
    for (var i = 0; i < this.labels.length; i++) {
      this.labels[i].type = type[Math.round(Math.random() * (6 - 0) + 0)]
      this.labels[i].count = res1s.data.data[i]
    }
    // 分类
    const res2 = await axios.get('http://localhost:9090/type/getAll')

    this.classifys = res2.data.data
    for (var j = 0; j < this.classifys.length; j++) {
      this.classifys[j].type = type[Math.round(Math.random() * (6 - 0) + 0)]
    }
  }
}
</script>

<style scoped>
@import '@/css/blog.css';
</style>
<style scoped>
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
.abm-left-router-title {
  color: #ffffff;
  font-size: 30px;
  position: relative;
  /* bottom: 10%; */
  top: 20%;

  left: 10%;
}
.abm-left-router-desc {
  color: #ffffff;
  font-size: 15px;
  position: relative;
  /* bottom: 10%; */
  font-family: YouYuan;
  top: 30%;
  left: 10%;
}
.abm-left-router-1:hover {
  transition: transform 0.2s;
  transform: scale(1.03);
}
.abm-left-router-2:hover {
  transition: transform 0.2s;
  transform: scale(1.03);
}
.abm-left-router-3:hover {
  transition: transform 0.2s;
  transform: scale(1.03);
}
.abm-left-router-1 {
  user-select: none;
  margin-bottom: 30px;
  margin-top: 30px;
  border-radius: 10px;
  /* background: linear-gradient(to right, rgb(52, 139, 255), rgb(21, 196, 255)); */
  /* background: linear-gradient(to right, rgb(24, 231, 174), rgb(30, 235, 234)); */
  background: linear-gradient(to right, rgb(255, 103, 84), rgb(255, 188, 55));
  height: 100px;
}
.abm-left-router-2 {
  user-select: none;
  margin-bottom: 30px;
  margin-top: 30px;
  border-radius: 10px;
  background: linear-gradient(to right, rgb(52, 139, 255), rgb(21, 196, 255));
  /* background: linear-gradient(to right, rgb(24, 231, 174), rgb(30, 235, 234)); */
  /* background: linear-gradient(to right, rgb(255, 103, 84), rgb(255, 188, 55)); */
  height: 100px;
}
.abm-left-router-3 {
  margin-bottom: 30px;
  user-select: none;
  margin-top: 30px;
  border-radius: 10px;
  /* background: linear-gradient(to right, rgb(52, 139, 255), rgb(21, 196, 255)); */
  background: linear-gradient(to right, rgb(24, 231, 174), rgb(30, 235, 234));
  /* background: linear-gradient(to right, rgb(255, 103, 84), rgb(255, 188, 55)); */
  height: 100px;
}
.loadPage {
  display: flex;
  /* margin: auto; */
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
.first-tab {
  border-top-right-radius: 0.375rem;
  border-bottom-right-radius: 0.375rem;
}
.tab-expander {
  line-height: 4.5rem;
  text-align: center;
  position: absolute;
  right: 20px;
}
.type-tab {
  position: relative;
  display: flex;
  background-color: rgb(255, 255, 255);
  border-radius: 1rem;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  width: auto;
  margin-bottom: 2rem;
  overflow-y: hidden;
  margin-top: 2rem;
  padding-left: 1.5rem;
  padding-right: 1.5rem;
  --tw-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px rgba(0, 0, 0, 0.06);
  box-shadow: var(--tw-ring-offset-shadow, 0 0 #0000), var(--tw-ring-shadow, 0 0 #0000),
    var(--tw-shadow);
  height: 3.5rem;
  transition: height 400ms ease;
}
.tab {
  user-select: none;
  display: flex;
  background-color: aliceblue;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  width: 650px;

  overflow-y: hidden;
  padding-left: 1.5rem;
  padding-right: 1.5rem;
  height: auto;
  transition: height 400ms ease;
  background-color: var(--background-secondary);
}

.tab li span {
  background-color: var(--background-primary);
  border-top-left-radius: 0.375rem;
  border-bottom-left-radius: 0.375rem;

  font-size: 0.875rem;
  line-height: 1.25rem;
  padding-top: 0.5rem;
  padding-bottom: 0.5rem;
  padding-left: 0.75rem;
  padding-right: 0.75rem;
  text-align: center;
  white-space: nowrap;
  background-color: rgb(241, 243, 249);
}
ul {
  display: block;
  list-style-type: disc;
  margin-block-start: 1em;
  margin-block-end: 1em;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
  padding-inline-start: 40px;
}

.tab li :hover {
  background-color: rgb(248, 249, 252);
}
b {
  border-top-right-radius: 0.375rem;
  border-bottom-right-radius: 0.375rem;
  font-size: 0.875rem;
  line-height: 1.25rem;
  padding-top: 0.5rem;
  padding-bottom: 0.5rem;
  padding-left: 0.75rem;
  padding-right: 0.75rem;
  text-align: center;
  white-space: nowrap;
  background-color: rgb(241, 243, 249);
}
.tab li {
  cursor: pointer;
  margin-top: 1rem;
  margin-bottom: 1rem;
  margin-right: 0.75rem;
}

ol,
ul {
  list-style: none;
  margin: 0;
  padding: 0;
}
</style>
