<template>
    <div id="mainBlock">
        <div class="basic-container">
            <div v-for="fit in fits" :key="fit">
                <tiny-image style="" :src="url" :fit="fit"></tiny-image>
            </div>
        </div>

        <div id="textBox">
            <p id="title">{{ text1 }}</p>
            <div>
                {{ text2 }}
            </div>
            <div id="bottomText">
                来源：北京青年报
            </div>
        </div>
    </div>
</template>

<script>
import { Image } from '@opentiny/vue'
export default {
    components: {
    TinyImage: Image
  },
  props:{
    text1:String,
    text2:String
  },
  data() {
    return {
      fits: ['cover'],
      url: `https://cdn.pixabay.com/photo/2020/06/04/15/06/dentist-5259162_1280.jpg`
    }
  }
}
</script>

<style scoped>
#mainBlock{
    margin-top: 1vh;
    width: 80vw;
    height: 20vh;
    background-color: rgba(208, 208, 208, 0.438);
    margin-left: 10vw;
}
#mainBlock:hover{
    background-color: rgb(208, 208, 208);;
}

.basic-container {
  display: flex;
  flex-wrap: wrap;
  position: relative;
  top: 20%;
  left: 6%;
  /* transform: scale(1.3); */
}

.title {
  margin: 16px 16px 8px 0;
}
.tiny-image {
  width: 100px;
  height: 100px;
  margin-right: 16px;
}
#textBox{
    width: 60vw;
    position: relative;
    left: 20%;
    top: -50%;
}
#title{
    font-size: 3vh;
}
#bottomText{
    float: right;
    color: rgb(170, 170, 171);
}
</style>