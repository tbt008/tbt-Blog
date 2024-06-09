// 播放对象
let audio = document.querySelector('#ado')
// 播放按钮
const _audio = document.querySelector('._audio')
const _voice = document.querySelector('._voice')

// 音频设置
audio.src = "./audio/當山みれい - 春夏秋冬 reprise.mp3"
audio.controls = false
audio.loop = true
audio.volume = 0.3

// 播放开始与暂停以及相关的图标字体修改
function bofang() {
    if (audio.paused) {
        audio.play()
        _audio.classList.remove('icon-bofang')
        _audio.classList.add('icon-zanting')
    } else {
        audio.pause()
        _audio.classList.remove('icon-zanting')
        _audio.classList.add('icon-bofang')
    }
}

// 是否静音与相关的图标字体修改
_voice.addEventListener('click', () => {
    if (audio.muted) {
        audio.muted = false
        _voice.classList.remove('icon-yinliangguanbi')
        _voice.classList.add('icon-yinliangkai')
    } else {
        audio.muted = true
        _voice.classList.remove('icon-yinliangkai')
        _voice.classList.add('icon-yinliangguanbi')
    }
})

// 一上来先调一次初始化函数
changeSong()

// 将audio的初始化函数封装
function changeSong() {
    // 获取音频时长
    if (audio != null) {
        audio.load()
        audio.oncanplay = function () {
            let duraTime = document.querySelector('.duraTime')
            duraTime.innerHTML = transTime(audio.duration)
        }
    }

    // 格式化时间格式
    function transTime(time) {
        let duration = parseInt(time)
        let minute = parseInt(duration / 60)
        let sec = (duration % 60) + ''
        let isM0 = ':'
        if (minute == 0) {
            minute = '00'
        } else if (minute < 10) {
            minute = "0" + minute
        }
        if (sec.length == 1) {
            sec = "0" + sec
        }
        return minute + isM0 + sec
    }

    // 时长进度条
    const progress = document.querySelector(".progress");
    const slide = document.querySelector(".slide");
    const fill = document.querySelector(".fill")
    audio.ontimeupdate = function () {
        let l = (audio.currentTime / audio.duration) * 100;
        slide.style.left = l + "%";
        fill.style.width = l + "%";
        if (audio.currentTime == 0) {
            slide.style.left = "0%";
        }
        const currentTime = document.querySelector(".currentTime");
        currentTime.innerHTML = transTime(parseInt(audio.currentTime));
        const duraTime = document.querySelector(".duraTime");
        duraTime.innerHTML = transTime(audio.duration);
    };

    // 进度条拖动
    slide.onmousedown = function (e) {
        let x = e.clientX - this.offsetLeft
        document.onmousemove = function (e) {
            let jlx = ((e.clientX - x) / progress.clientWidth) * 100
            if (jlx <= 100 && jlx >= 0) {
                slide.style.left = jlx + "%"
            }
            audio.currentTime = (jlx / 100) * audio.duration
        }
        document.onmouseup = function () {
            document.onmousemove = null
            document.onmouseup = null
        }
    }
    slide.ontouchstart = function (e) {
        let x = e.targetTouches[0].clientX - this.offsetLeft
        document.ontouchmove = function (e) {
            let jlx = ((e.targetTouches[0].clientX - x) / progress.clientWidth) * 100
            if (jlx <= 100 && jlx >= 0) {
                slide.style.left = jlx + '%'
            }
            audio.currentTime = (jlx / 100) * audio.duration
        }
        document.ontouchend = function (e) {
            document.ontouchmove = null
            document.ontouchend = null
        }
    }
}

// right_box > .navigation 修改right_box 导航栏部分样式1

const items = document.querySelectorAll('.navigation li')
function setActive() {
    items.forEach((items) => {
        items.classList.remove('active')
    })
    this.classList.add('active')
    current_tag.innerText = this.innerText
}

items.forEach((items) => {
    items.addEventListener('click', setActive)
})

// 获取推荐歌曲  切歌功能
const image = document.querySelector('._img')
const recm_list = document.querySelectorAll('.recm_list ul li')
const audio_list = ['夜驱', 'Call your name', '万疆', 'アムリタ', '群青']
const image_list = ['夜驱', 'callYourName', '万疆', '翼年代', '群青']
// ftleft 切哥后对应的图片歌名和歌手名称也需要切换
const songName = document.querySelector('.songName')
const singer = document.querySelector('.singer')
const songAndSinger_list = [
    ['夜に駆ける','YOASOBI'],
    ['Call your name','李阿亚'],
    ['万疆','李玉刚'],
    ['アムリタ','牧野由依'],
    ['群青','YOASOBI']
]

for (let i = 0; i < recm_list.length; i++) {
    recm_list[i].addEventListener('click', function() {
        audio.src = "./audio/" + audio_list[i] + ".mp3"
        image.src = "./image/main/" + image_list[i] + ".jpg"
        songName.innerHTML = songAndSinger_list[i][0] + '<i class="iconfont icon-aixin"></i>'
        singer.innerHTML = songAndSinger_list[i][1]
        changeSong()
        audio.play()
    })
}