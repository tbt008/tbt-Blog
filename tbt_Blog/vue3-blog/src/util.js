//判断是否是移动端 
export const isMobile = () => {
    return !!navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)
}