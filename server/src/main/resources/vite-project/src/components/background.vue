<!--  样式来源
    作者：山羊の前端小窝 https://www.bilibili.com/read/cv27116131/ 出处：bilibili -->


<template>
  <canvas></canvas>
</template>

<script>
export default {
}

</script>

<style scoped>
 * {
        padding: 0;
        margin: 0;
        z-index: 100;
    }
    body {
        width: 100%;
        height: 100vh;
        /* 背景渐变 */
        background-image: linear-gradient(-225deg, #231557 0%,
                #43107a 29%, #FF1361 100%);
    }
    canvas {
        position: fixed;
        width: 100%;
        height: 100%;
    }
</style>