<template>
    <div>
        <top_side :position=2 />
        <banner :info="banner[1]" />
        <div id="mainPart">
            <div class="left-panel">
                <tiny-fall-menu id="menu" :data="dataset"></tiny-fall-menu>
            </div>
            <div id="cards">
                <doctor_card title="李锦" text="擅长痤疮，皮肤美容，甲真菌病，足癣股癣，皮肤瘙痒，荨麻疹，带状疱疹，湿疹，疣，银屑病，性传播疾病等常见病诊治。"  />
                <doctor_card title="谢立夏" text="互联网问诊答疑10000+次，擅长各种皮肤病个体化治疗。硕士。发表学术论文十余篇，皮肤病治疗国家专利一项。       "/>
                <doctor_card title="李宗辉" text="多年皮肤科医师，从事病房与门诊等基础皮肤科工作，完成数万例临床病人的诊疗，并负责常见皮肤疾病的外科治疗。    "/>
            </div>
        </div>
    </div>
</template>

<script>
import banner from '../components/banner.vue';
import doctor_card from '../components/doctor_card.vue';
import top_side from '../components/top_side.vue';
import { FallMenu as TinyFallMenu } from '@opentiny/vue';
export default {
    components:{
        top_side,banner,doctor_card,TinyFallMenu
    },
    data() {
        return {
            banner:['首页', '健康咨询','我们的服务', '词云视图', '数据查询'],
            dataset : ([

  { title: '皮肤科', url: '#/zh-CN/index' },
  { title: '儿科', url: '#/zh-CN/index' },
  { title: '耳鼻咽喉科', url: '#/zh-CN/index' },
  { title: '心血管内科', url: '#/zh-CN/index' },
  { title: '眼科', url: '#/zh-CN/index' },
  { title: '精神心理科', url: '#/zh-CN/index' },
  { title: '皮肤科', url: '#/zh-CN/index' },

        ])
    }
    },
}
</script>

<style scoped>
#mainPart{
    margin-top: 1vh;
    background: #b0b0b0;
    position: relative;
    left: 5vw;
    width: 90vw;
    border-radius: 4px;
    padding: 1vh 3vw;
}
.left-panel{
    padding: 28px 30px;
    justify-content: space-between;
    border-bottom: 1px solid #e8e9eb;
}
#menu{
    --ti-fall-menu-bg-color-normal:rgba(71, 71, 71, 0);
    --ti-fall-menu-bg-color-hover:rgba(71, 71, 71, 0.512);
}
#cards{
    display: flex;
    margin-top: 1vh;
}

</style>