<template>
  <div id="banner">
    {{ info || 'No props passed yet'}}
  </div>
</template>

<script>
export default {
    props:{
        info: String
    }
}
</script>

<style scoped>
#banner{
  background-color: #413d3d;
  height: 8vh;
  display: flex;
  align-items: center;
  color: #ffffff;
  /* font-family:'Courier New', Courier, monospace ; */
  font-size: 5vh;
  font-weight: 500;
  padding-left: 3%;
  border-radius: 0px 0px 3px 3px;
}
</style>