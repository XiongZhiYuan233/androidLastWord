<template>
    <div id="box">
        <span>{{ this.info['user_email'] }}</span>
        <span id="seperate"></span>
        <span>{{ this.info['name'] }}</span>
        <span id="seperate"></span>
        <span>{{ this.info['sex'] }}</span>
        <span id="seperate"></span>
        <span>{{ this.info['age'] }}</span>
        <span id="seperate"></span>
        <span>{{ this.info['stature'] }}</span>
        <span id="seperate"></span>
        <span>{{ this.info['phonenumber'] }}</span>
        <span id="seperate"></span>
        <span style="padding-top: 1.5vh;">
            <button id="mybt1" class="my_button" @click="this.change()">修改</button>
        </span>
        <span id="seperate"></span>
        <span style="padding-top: 1.5vh;">
            <button id="mybt1" class="my_button" @click="this.delete()">删除</button>
        </span>
    </div>

    <div v-if="this.display" style="width: 100vw;height: 90vh;background-color: black;position: absolute;top: 0;left: 0;opacity: 0;"></div>
    <div id="change_box" v-if="this.display">
        <!-- <div><div>user_email:</div><input v-model="user.user_email" :placeholder="this.info['user_email']"></div> -->
        <div><div>name:</div><input v-model="user.name " :placeholder="this.info['name']"></div>
        <div><div>sex:</div><input v-model="user.sex" :placeholder="this.info['sex']"></div>
        <div><div>age:</div><input v-model="user.age" :placeholder="this.info['age']"></div>
        <div><div>stature:</div><input v-model="user.stature" :placeholder="this.info['stature']"></div>
        <div><div>phonenumber:</div><input v-model="user.phonenumber" :placeholder="this.info['phonenumber']"></div>
        <div id="button_div">
            <button class="my_button" @click="submit">提交</button>
            <div></div>
            <button class="my_button" @click="change()">取消</button>
        </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
props:{
    info: Object
},
data(){
    return{
        display:false,
        user:{
                name:null,
                sex:null,
                age:null,
                stature:null,
                phonenumber:null
            },
    }
},
methods:{
    change(){
        this.display = !this.display
    },
    submit(){
            let formData = new FormData();
            formData.append('user_email', this.info['user_email']);
            if(this.user.name)
                formData.append('name', this.user.name);
            if(this.user.sex)
                formData.append('sex', this.user.sex);
            if(this.user.age)
                formData.append('age', this.user.age);
            if(this.user.stature)
                formData.append('stature', this.user.stature);
            if(this.user.phonenumber)
                formData.append('phonenumber', this.user.phonenumber);
            axios
            .post('/api/update_user_data',formData,{
                headers:{
                    token:sessionStorage.getItem("token"),
                    "Content-Type": 'multipart/form-data'
                }
            }
            )
            location.reload();
    },
    delete(){
        let formData = new FormData();
        formData.append('user_email', this.info['user_email']);
        axios
        .post('/api/admin_deleteUser',formData,{
            headers:{
                token:sessionStorage.getItem("token"),
                "Content-Type": 'multipart/form-data'
            }
        }
        )
        location.reload();
    }
}
}
</script>

<style scoped>
#box{
    /* margin: 100px 0 100px 100px; */
    margin-top: 3vh;


    background-color: #ffffff;
    border-radius: 10px;
    width: 80vw;
    margin-left: 15vw;
    height: 8vh;
    display: grid;
    /* grid-template-columns: repeat(8,1fr 0.0001fr); */
    grid-template-columns: 3fr 0.0001fr 1fr 0.0001fr 1fr 0.0001fr 1fr 0.0001fr 1fr 0.0001fr 3fr 0.0001fr 2fr 0.0001fr 2fr 0.0001fr;
    /* grid-template-rows: 1fr; */
    text-align:center;
    /* padding: 10vw; */
    box-shadow:0 0 10px #00000025;
    transition: 0.3s ease;

    white-space: nowrap;
}
#box:hover{
    box-shadow:0 0 10px #00000041;
    transform: translateX(1px);
    transform: translateY(-1px);
}
#box span{
    /* margin: 3vh; */
    /* width: 10px; */
    /* overflow: hidden; */
    overflow-x: auto;
    padding-top: 2vh;
    margin: 0 1vw;
}
#seperate{
    border-right: #dee0dfab 5px solid;
    border-radius: 100px;
    margin:auto 0 !important;
    padding: 0 !important;
    height: 7vh;
    box-shadow:0 0 5px #dee0dfab;
}

#change_box{
    z-index: 100;
    border-radius: 10px;
    background: #55e0c2da;
    width: 50vw;
    height: 50vh;
    position: fixed;
    top: 25vh;
    left: 25vw;
    box-shadow:0 0 10px #55e0c2da;
    display: grid;
    grid-template-rows: repeat(5,1fr);
    text-align: center;
}
#change_box div{
    padding: 1vh;
    display: grid;
    grid-template-columns: 3fr 8fr;
}
#change_box div div{
    margin-right: 1vw;
    /* width: 10px; */
}
#change_box input{
    width: 80%;
    height: 80%;
    border-radius: 5px;
    border: none;
    /* box-shadow:0 0 10px #b8121225; */
}

#button_div{
    margin-left: auto;
    margin-right: auto;
    width: 80%;
    grid-template-columns: 1fr 1fr 1fr !important;
}

.my_button{
    background-color: rgb(49, 52, 53);
    border: none;
    border-radius: 12px;
    color:white;
    padding: 1vh 2vw;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 1.8vh;
    cursor: pointer;
    transition-duration: 0.4s;
    -webkit-transition-duration: 0.4s;
}
#my_button:hover{
    box-shadow: 0 12px 16px 0 rgba(0,0,0,.24),
    0 17px 50px 0 rgba(0,0,0,.19);
}

/* #box span::-webkit-scrollbar {
    width: 10px;
    // height: 10px; // 高度写不写，都不影响，因为会根据内容的长度自动计算
}

#box span::-webkit-scrollbar-thumb {
    background: #ccc; 
    border-radius: 5px; 
}

#box span::-webkit-scrollbar-thumb:hover {
    background: #f40; 
}

#box span::-webkit-scrollbar-track {
    border-radius: 10px;  
    background-color: #1890ff  
} */
::-webkit-scrollbar {
    /* width: 50%; */
    /* height: 5px; */
    height: 0.8vh;
}

::-webkit-scrollbar-track {
  width: 0;
  height: 0;
  background: rgba(#101F1C, 0.1);
  -webkit-border-radius: 2em;
  -moz-border-radius: 2em;
  border-radius: 2em;
}

::-webkit-scrollbar-thumb {
  background-color: rgba(144,147,153,.5);
  background-clip: padding-box;
  min-height: 28px;
  -webkit-border-radius: 2em;
  -moz-border-radius: 2em;
  border-radius: 2em;
  transition: background-color .3s;
  cursor: pointer;
}

::-webkit-scrollbar-thumb:hover {
  background-color: rgba(144,147,153,.3);
}
::-webkit-scrollbar-button{
    display: none;
}

</style>