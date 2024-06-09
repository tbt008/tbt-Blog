import { createApp } from 'vue'
import { createPinia } from 'pinia'
import App from './App.vue'
import router from './router'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
//引入这两个包
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'

const app = createApp(App)
app.use(createPinia())
app.use(router)
app.use(ElementPlus)
//把他加载到Vue中
app.use(mavonEditor)
app.mount('#app')

// use

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component)
}
