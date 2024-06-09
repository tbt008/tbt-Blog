<script setup lang="ts">
import BlogHeader from '@/components/BlogHeader.vue'
import PhoneNav from '@/components/PhoneNav.vue'
import marked from 'marked'
</script>
<template>
  <div id="main">
    <blog-header></blog-header>
    <router-view></router-view>
    <phone-nav></phone-nav>
  </div>
</template>
<style scoped>
#main {
  display: block;
}
</style>
