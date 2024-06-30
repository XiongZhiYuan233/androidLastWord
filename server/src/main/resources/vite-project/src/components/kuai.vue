<template>
  <div>
    {{ all_sensorData.data1 }}
    {{ all_sensorData.data2 }}
    {{ all_sensorData.data3 }}
  </div>
</template>

<script>
export default {
  data(){
    return{
      all_sensorData:{
        data1:1,
        data2:2,
        data3:3
      }
    }
  }
}
</script>

<style scoped>
*{
  background-color:#2424246a;
  width: 250px;
  height: 350px;
  border-radius: 15px;
  display: flex;
  align-items: center;
  text-align: center;
  position: absolute;
  bottom: -70vh;
  left: 3vw;
  z-index: 100;
}
</style>