<template>
  <div>
    <top_side :position=1></top_side>
    <div id="box">
      <div>
        <user_data_head />
        <data_change />
      </div>

    </div>
  </div>
</template>

<script>
import top_side from '../components/top_side.vue';
import user_data_head from '../components/user_data_head.vue';
import data_change from '../components/data_change.vue';
export default {
    components:{top_side,user_data_head,data_change}
}
</script>

<style scoped>
  *{
    z-index: 99;
  }
  #box{
    display: grid;
    grid-template-columns: 1fr 2fr;
  }
</style>