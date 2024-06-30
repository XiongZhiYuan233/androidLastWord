<template>
    <div>
        <top_side :position=1 />
        <banner :info="banner[0]" />
        <!-- qqqq -->
        <!-- <kuai /> -->
        <div id="pos_1">
            <div>
                <div id="pos_4">
                    <img id="img1" src="/resources/title.png" />
                    <img id="img2" src="/resources/title.png" />
                </div>
            </div>
            <div>
                <div id="pos_2">
                    <div><humiture /></div>
                    <div><bloodOxygen /></div>
                </div>
                <div id="pos_3">
                    <div><lightIntensity /></div>
                    <div><heartRate /></div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import banner from '../components/banner.vue'
import kuai from '../components/kuai.vue'
import top_side from '../components/top_side.vue'
import humiture from '../components/humiture.vue'
import heartRate from '../components/heartRate.vue'
import lightIntensity from '../components/lightIntensity.vue'
import bloodOxygen from '../components/bloodOxygen.vue'

export default {
    components:{
        kuai,top_side,banner,humiture,heartRate,lightIntensity,bloodOxygen
    },
    data() {
        return {
            banner:['首页', '健康咨询','我们的服务', '博客', '数据查询'],
        }
    },
}
</script>

<style scoped>
#pos_1{
    display: grid;
    grid-template-columns: 1fr 5fr;
}
#pos_2{
    /* height: 1000px; */
    display: grid;
    grid-template-columns: 2fr 1fr;
}
#pos_2 div{
    padding: 10px 5px;
}
#pos_3{
    display: grid;
    grid-template-columns: 3fr 2fr;
}
#pos_3 div{
    padding: 10px 5px;
}
#pos_4{
    margin-top: 2vh;
    box-shadow: 1px 1px 10px black;
}
#pos_4 img{
}
#pos_4:hover #img1{
    opacity: 0;
}
#pos_4:hover #img2{
    display: block;
}
#img1{
    width: 100%;
}
#img2{
    position: absolute;
    top: 30vh;
    width: 40vw;
    z-index: 100;
    display: none;
}
</style>