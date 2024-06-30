<template>
    <div>
        <tiny-card id="card" :auto-width="true" :title="title" type="image" :src="url">
      <p>
        {{text}}
      </p>
      <p class="myP">
        西安市第八医院
      </p>
      <p class="myP">
        皮肤科
      </p>
      <button id="chooseButton">问医生</button>
    </tiny-card>
    </div>
</template>

<script>
import { Card as TinyCard } from '@opentiny/vue'
export default {
    components:{
        TinyCard
    },
    props:{
        text: String,
        title: String,
    },
    data(){
        return{
            url:"https://cdn.pixabay.com/photo/2018/09/27/14/14/analysis-3707159_1280.jpg",
        }
    }
}
</script>

<style scoped>
#card{
    margin: 0 1vw;
}
#chooseButton{
    width: 120px;
    height: 38px;
    min-height: 38px;
    border-radius: 4px;
    font-size: 1.4rem;
    font-weight: 500;
    margin-top: 24px;
    color: #fff;
    display: flex;
    align-items: center;
    justify-content: center;
    color: #fff;
    background-color: #00c792;
    margin: auto;
}
.myP{
    text-align:center;
}
</style>