<template>
  <div class="blog-footer">
    <div class="footer-line"></div>

    <div class="info-main">
      <div class="info">Copyright © 2024 TBT</div>
      <h4 class="info">湘ICP备2024063407号</h4>
    </div>
  </div>
</template>
<style>
@media only screen and (max-width: 414px) {
  .info-main {
    padding-top: 3rem;
  }

  .info {
    width: 100%;
    text-align: center;
    margin: auto;
    margin-top: 1rem;
  }
  .blog-footer {
    margin-top: 50px;
    height: 8rem;
  }
  .footer-line {
    height: 3px;
    width: 100%;
    background-color: aliceblue;
  }
}
@media only screen and (min-width: 414px) {
  .info-main {
    padding-top: 50px;
  }

  .info {
    width: 100%;
    text-align: center;
    margin: auto;
    margin-top: 10px;
  }
  .blog-footer {
    margin-top: 50px;
    height: 200px;
  }
  .footer-line {
    height: 3px;
    width: 100%;
    background-color: aliceblue;
    /* background: linear-gradient(
    130deg,
    rgb(36, 198, 220),
    rgb(84, 51, 255) 41.07%,
    rgb(255, 0, 153) 76.05%
  ); */
  }
}
</style>
