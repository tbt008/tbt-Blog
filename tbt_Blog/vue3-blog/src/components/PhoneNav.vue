<template>
  <nav class="phone-nav">
    <div class="phone-nav-item phone-active" @click="this.$router.push('/')">
      <!-- color="rgb(69, 156, 238)" -->
      <el-icon>
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1024 1024" data-v-6fbb019e="">
          <path
            fill="currentColor"
            d="M192 413.952V896h640V413.952L512 147.328zM139.52 374.4l352-293.312a32 32 0 0 1 40.96 0l352 293.312A32 32 0 0 1 896 398.976V928a32 32 0 0 1-32 32H160a32 32 0 0 1-32-32V398.976a32 32 0 0 1 11.52-24.576"
          ></path></svg
      ></el-icon>
      <span class="phone-text">Home</span>
    </div>
    <div class="phone-nav-item" @click="this.$router.push('/blog')">
      <el-icon
        ><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1024 1024" data-v-6fbb019e="">
          <path
            fill="currentColor"
            d="M832 384H576V128H192v768h640zm-26.496-64L640 154.496V320zM160 64h480l256 256v608a32 32 0 0 1-32 32H160a32 32 0 0 1-32-32V96a32 32 0 0 1 32-32m160 448h384v64H320zm0-192h160v64H320zm0 384h384v64H320z"
          ></path></svg
      ></el-icon>

      <span class="phone-text">Blog</span>
    </div>
    <div class="phone-nav-item" @click="this.$router.push('/music')">
      <el-icon
        ><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1024 1024" data-v-6fbb019e="">
          <path
            fill="currentColor"
            d="M896 529.152V512a384 384 0 1 0-768 0v17.152A128 128 0 0 1 320 640v128a128 128 0 1 1-256 0V512a448 448 0 1 1 896 0v256a128 128 0 1 1-256 0V640a128 128 0 0 1 192-110.848M896 640a64 64 0 0 0-128 0v128a64 64 0 0 0 128 0zm-768 0v128a64 64 0 0 0 128 0V640a64 64 0 1 0-128 0"
          ></path></svg
      ></el-icon>
      <span class="phone-text">Music</span>
    </div>
    <div class="phone-nav-item" @click="this.$router.push('/message')">
      <el-icon
        ><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1024 1024" data-v-6fbb019e="">
          <path
            fill="currentColor"
            d="m199.04 672.64 193.984 112 224-387.968-193.92-112-224 388.032zm-23.872 60.16 32.896 148.288 144.896-45.696zM455.04 229.248l193.92 112 56.704-98.112-193.984-112-56.64 98.112zM104.32 708.8l384-665.024 304.768 175.936L409.152 884.8h.064l-248.448 78.336zm384 254.272v-64h448v64h-448z"
          ></path></svg
      ></el-icon>
      <span class="phone-text">Message</span>
    </div>
    <div class="phone-nav-item" @click="this.$router.push('/aboutMe')">
      <el-icon
        ><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1024 1024" data-v-6fbb019e="">
          <path
            fill="currentColor"
            d="M512 512a192 192 0 1 0 0-384 192 192 0 0 0 0 384m0 64a256 256 0 1 1 0-512 256 256 0 0 1 0 512m320 320v-96a96 96 0 0 0-96-96H288a96 96 0 0 0-96 96v96a32 32 0 1 1-64 0v-96a160 160 0 0 1 160-160h448a160 160 0 0 1 160 160v96a32 32 0 1 1-64 0"
          ></path></svg
      ></el-icon>
      <span class="phone-text">Me</span>
    </div>
    <div class="phone-nav-overlay"></div>
  </nav>
</template>

<script>
export default {
  data() {
    return {}
  },
  mounted() {
    const navigationTabItems = document.querySelectorAll('.phone-nav-item')
    navigationTabItems.forEach(function (item) {
      item.addEventListener('click', function () {
        navigationTabItems.forEach(function (item) {
          item.classList.remove('phone-active')
        })
        this.classList.add('phone-active')
        const prevAllLength = Array.from(this.parentNode.children).indexOf(this)

        document.querySelector('.phone-nav-overlay').style.left =
          (prevAllLength * screen.availWidth) / 5 + 'px'
      })
    })
  }
}
</script>
<style scoped>
@media only screen and (min-width: 414px) {
  .phone-nav {
    display: none;
  }
}
@media only screen and (max-width: 414px) {
  * {
    padding: 0;
    margin: 0;
  }

  .phone-nav {
    user-select: none;
    z-index: 99;
    height: 3rem;
    width: 97%;
    background-color: #fff;
    border-radius: 10px 10px 30px 30px;
    overflow: hidden;
    border: 5px solid #fff;
    display: flex;
    position: fixed;
    bottom: 0;
    margin: auto;
  }

  .phone-nav-item {
    user-select: none;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    width: 20%;
    flex-shrink: 0;
    cursor: pointer;
    transition: 0.3s;
    position: relative;
    z-index: 2;
  }

  .phone-nav-item.phone-active {
    width: 20%;
  }

  .phone-nav-item.phone-active .phone-text {
    opacity: 1;
    transform: translateY(10px);
  }

  .phone-nav-overlay {
    border-radius: 10px;
    background-color: #e4f2ff;
    height: 100%;
    width: 20%;
    position: absolute;
    left: 0;
    top: 0;
    transition: 0.3s;
  }

  .phone-text {
    display: block;
    font-weight: 400;
    font-size: 13px;
    /* color: rgb(69, 156, 238); */
    color: rgb(69, 156, 238);
    opacity: 0;
    transition-duration: 0.3s;
    transform: translateY(20px);
    user-select: none;
    padding-bottom: 5px;
  }
}
</style>
