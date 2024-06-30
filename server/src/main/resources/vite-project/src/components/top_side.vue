<template>
    <div>
        <div id="stone"></div>
        <nav>
            <ul>
                <div></div>
                <div id="iron">
                    <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-body-text" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M0 .5A.5.5 0 0 1 .5 0h4a.5.5 0 0 1 0 1h-4A.5.5 0 0 1 0 .5Zm0 2A.5.5 0 0 1 .5 2h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5Zm9 0a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5Zm-9 2A.5.5 0 0 1 .5 4h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1-.5-.5Zm5 0a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5Zm7 0a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1-.5-.5Zm-12 2A.5.5 0 0 1 .5 6h6a.5.5 0 0 1 0 1h-6a.5.5 0 0 1-.5-.5Zm8 0a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5Zm-8 2A.5.5 0 0 1 .5 8h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5Zm7 0a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5Zm-7 2a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 0 1h-8a.5.5 0 0 1-.5-.5Zm0 2a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5Zm0 2a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1h-2a.5.5 0 0 1-.5-.5Z"/>
                    </svg>
                </div>
                <li @mouseover="handleMouseOver(1)" @mouseout="handleMouseOut"><router-link to="/main_view">{{ banner[0] }}</router-link></li>
                <li @mouseover="handleMouseOver(2)" @mouseout="handleMouseOut"><router-link to="/user_consult">{{ banner[1] }}</router-link></li>
                <li @mouseover="handleMouseOver(3)" @mouseout="handleMouseOut"><router-link to="/our_service">{{ banner[2] }}</router-link></li>
                <li @mouseover="handleMouseOver(4)" @mouseout="handleMouseOut"><router-link to="/blog">{{ banner[3] }}</router-link></li>
                <!-- <li @mouseover="handleMouseOver(5)" @mouseout="handleMouseOut">{{banner[4]}}</li> -->
                <div class="slider" :style="{left:now_position + '%'}"></div>
            </ul>
            <div id="user">
                <router-link to="/user_view">
                    <div id="user-next">
                    <span>{{ user.name }}</span>
                    <div id="iron">
                        <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                        <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                        <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                    </svg>
                    </div>
                </div>
                </router-link>
            </div>
        </nav>
    </div>
</template>

<script>
// 使用说明
// 使用时传入banner表示导航栏的内容
// 传入position表示紫色块对应的位置


// import '../router'
export default {
    data(){
        return{
            banner:['首页', '健康咨询','我们的服务', '博客', '数据查询'],
            user:{
                name: 'admin',
            },
            new_position:0
        }
    },
    methods:{
        handleMouseOver(n){
            this.new_position = n
        },
        handleMouseOut(){
            this.new_position = this.position
        }
    },
    props:{
        position:Number
        // banner:Array
    },
    computed:{
        now_position(){
            if(this.new_position == 0){
                return 4 + this.position * 16
            }
            return 4 + this.new_position * 16
        }
    },
    beforeMount() {
        
    },
}
</script>

<style scoped>
*{
    margin: 0;
    padding: 0;
    border: 0;
    text-decoration: none;
    color: #919090;
    z-index: 100;
}
#stone{
    height: 8vh;
    width: 100%;
    top: 0;
    background-color: #242424f3;
}
#user{
    color: #000;
    flex:40%;
    z-index: 1;
    width: 100%;
    text-align: center;
}
#user-next{
    text-align: center;
    display: flex;
    align-items: center;
    float: right;
    margin-right: 30%;
}
#iron{
    text-align: center;
    display: flex;
    align-items: center;
    margin: 0 10px;
}
nav {
    min-width: 800px;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 8vh;
    width: 100%;
    position: fixed;
    top: 0;
    background-color: rgb(42, 41, 41);
}

ul {
    flex: 60%;
    position: relative;
    display: grid;
    width: 100%;
    /* grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr; */
    grid-template-columns:4% repeat(6,16%);
    padding: 0%;
}
ul li {
    /* background-color: #5252ed8d; */
    list-style: none;
    line-height: 40px;
    text-align: center;
    border-radius: 4px;
    z-index: 1;
    /* margin: 0 10px; */
}

/* 导航样式参考该地址：https://juejin.cn/post/7145485638580568095
文章作者：starry陆离 */
.slider {
    width: 16%;
    height: 40px;
    background-color: #5352ed;
    border-radius: 4px;
    position: absolute;
    left: 20%;
    bottom: 0;
    z-index: 0;
    transition: all ease 0.4s;
    animation: 2s ease-in-out waves infinite;
}
@keyframes waves {
    from {
    clip-path: polygon(
    0% 17%,
    9% 10%,
    18% 4%,
    30% 0%,
    43% 1%,
    49% 4%,
    57% 7%,
    66% 10%,
    78% 11%,
    89% 11%,
    96% 9%,
    100% 7%,
    100% 100%,
    0% 100%
    );
    }
    50% {
    clip-path: polygon(
    0% 4%,
    6% 9%,
    13% 13%,
    23% 15%,
    31% 16%,
    42% 15%,
    49% 13%,
    61% 10%,
    71% 5%,
    81% 3%,
    90% 2%,
    100% 5%,
    100% 100%,
    0% 100%
   );
    }
    to {
    clip-path: polygon(
    0% 17%,
    9% 10%,
    18% 4%,
    30% 0%,
    43% 1%,
    49% 4%,
    57% 7%,
    66% 10%,
    78% 11%,
    89% 11%,
    96% 9%,
    100% 7%,
    100% 100%,
    0% 100%
    );
}
}

/* li:nth-child(3):hover ~ .slider{
    left: 20%;
}
li:nth-child(4):hover ~ .slider{
    left: 36%;
}
li:nth-child(5):hover ~ .slider{
    left: 52%;
}
li:nth-child(6):hover ~ .slider{
    left: 68%;
}
li:nth-child(7):hover ~ .slider{
    left: 84%;
} */
</style>