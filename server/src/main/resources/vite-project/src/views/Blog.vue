<template>
    <div>
        <top_side :position=4 />
        <banner :info="banner[3]" />

        <tiny-button id="blogButton" @click="fn" type="primary"> 博客类型 </tiny-button>
    <tiny-drawer title="标题" :visible="this.visible" @update:visible="visible = $event">
      <div>
        <br />
        <br />
        <span>
            <tiny-toggle-menu :data="datas"></tiny-toggle-menu>
        </span>
      </div>
    </tiny-drawer>
    </div>
    <blog-block :text1="'烧水除塑有方法 饮水安全新招揭秘'" :text2="'近期，《美国国家科学院院刊》发布了一项惊人研究，揭示每升瓶装水中平均含有约24万个可检出的塑料微粒。这些纳米级的塑料颗粒能够进入我们的肠道或肺部细胞，进而穿越血液，抵达心脏和大脑，甚至对孕妇而言，它们能穿越胎盘，进入胎儿体内。'"/>
    <blog-block :text1="'杨柳飞絮来袭 你需要连躲带防'" :text2="'好不容易挨过了花粉袭击，过敏星人又迎来了杨柳飞絮的围攻。飞絮飘散空中，可以说是无孔不入，它能引发过敏性鼻炎、过敏性哮喘等多种疾病。今天北京市疾控中心环境卫生所的专家就跟大家分享一下防飞絮的秘籍。'"/>
    <blog-block :text1="'炒菜喜欢冒烟爆炒？别小看厨房油烟的危害！'" :text2="'前几天看到一条热搜“一个不起眼的炒菜习惯惹癌上身”，说的是炒菜时把油烧到冒烟的事儿。其实这条热搜讲对了一半，“炒菜时把油烧到冒烟不利于健康”，这是正确的建议。但是热搜中所说的“高温会让菜中的不饱和脂肪酸发生氧化裂解和异构化，催生具有反式构型的反式脂肪酸”，则是“先开枪后画靶”的逻辑，没有什么道理。'"/>
    <blog-block :text1="'客观看待“脆皮年轻人”的花式养生'" :text2="'26岁的于超凡提前一周挂了北京按摩医院的推拿门诊。据报道，不少医院的推拿号需要提前3天预约，周末的号基本一放就空。所谓“脆皮年轻人”的花式养生让推拿门诊一号难求，也带火了其他养生方式。在社交媒体平台，除了按摩推拿，年轻人还热衷于分享八段锦、艾灸、刮痧等中医治疗或养生方式。专家提醒，应审慎评价身体状况后选择合适的养生或治疗，切勿盲目跟风。'"/>
    <blog-block :text1="'购买保温杯 材质要选对'" :text2="'  在冬季，很多人习惯外出时用保温杯饮水。如今，市面上的保温杯种类很多，如何才能选出安全性高的保温杯？保温杯不宜装哪些液体？科技日报记者就此采访了相关专家。'"/>
</template>

<script>
import banner from '../components/banner.vue'
import top_side from '../components/top_side.vue'
import { ToggleMenu as TinyToggleMenu } from '@opentiny/vue'
import { Drawer as TinyDrawer, Button as TinyButton } from '@opentiny/vue'
import blogBlock from '../components/blog_block.vue'

export default {
    components:{
       top_side,banner,TinyToggleMenu,TinyDrawer,TinyButton,blogBlock
    },
    data() {
        return {
            banner:['首页', '健康咨询','我们的服务', '博客', '数据查询'],
            datas:[
            {
                id: 1,
                label: '医疗'
            },
            {
                id: 2,
                label: '健康'
            },
            {
                id: 3,
                label: '服务'
            },
            {
                id: 4,
                label: '资讯'
            },
            ],
            visible:false
        }
    },
    methods:{
        fn() {
            this.visible = !this.visible
        }
    }
}
</script>

<style scoped>
#blogButton{
    position: fixed;
    top:30vh;
    left: 1vw;
}

</style>