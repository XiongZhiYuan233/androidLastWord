<template>
    <div>
        <div id="class_head"></div>
        <div id="operate">
            <div>
                <input id="searchIp" v-model="this.search_comment" placeholder="ByName">
                <button class="Bts" @click="search()">搜索</button>
                <button class="Bts" @click="reset()">重置</button>
            </div>
            <div id="operate_2">
                <button id="Sbt" @click="change_style()">添加用户</button>
                <div id="addBlock" :style="this.style">
                    <input class="comIpt" v-model="this.user.user_email" placeholder="Email">
                    <input class="comIpt" v-model="this.user.password_hash" placeholder="Password">
                    <button class="Bts" style="margin-left: 1.5vw;" @click="addUser()">ok</button>
                </div>
            </div>
        </div>
        
        <user_data_class />
        <div v-for="item in display_users" :key="item">
            <user_data :info="item"/>
        </div>


        <!-- <li v-for="item in users_length" :key="item">
            <user_data :info="user[item]"/>
        </li> -->
        <!-- <user_data :info="users[0]"/> -->
        <!-- <user_data /> -->
    </div>
</template>

<script>
import axios from 'axios'
import user_data from '../components/user_data.vue'
import user_data_class from '../components/user_data_class.vue'
import { toRaw } from 'vue'
export default {
    components:{
        user_data,user_data_class
    },
    data(){
        return{
            users:null,
            display_users:null,
            search_comment:null,
            style:{
                left: "-15vw"
            },
            user:{
                user_email:null,
                password_hash:null
            }
        }
    },
    created(){
        axios
        .get('/api/admin_getdata',{                          
            headers:{
                token:sessionStorage.getItem("token")
            }
        })
        .then(response => {
            var list = toRaw(response.data)
            this.users = list
            this.display_users = list.slice()
        })
        
    },
    methods:{
        search(){
            this.display_users = this.users.slice()
            var sign = 0
            if(this.search_comment!=null){
                for(var i = 0;i<this.users.length;i++){
                let regex = new RegExp(this.search_comment, "i");
                if(this.users[i]['name'].match(regex)==null){
                    this.display_users.splice(i-sign,1)
                    sign+=1
                }
            }
            }
        },
        reset(){
            this.search_comment=null
            this.search()
        },
        change_style(){
            if(this.style.left == "-15vw")
                this.style.left = "-1.5vw"
            else
                this.style.left = "-15vw"
        },
        addUser(){
            if(this.user.user_email!=null && this.user.password_hash!=null){
                axios
                .post('/api/admin_addUser',this.user,{
                    headers:{
                        token:sessionStorage.getItem("token"),
                        // "Content-Type": 'multipart/form-data'
                    }
                }
            )
            location.reload();
            }else
                alert("邮箱及密码不能为空")
        }
    }
}
</script>

<style scoped>
#class_head{
margin-bottom: 10vh;
}
#operate{
    width: 12vw;
    height: 15vh;
    background-color: rgb(186, 186, 186);
    position: absolute;
    left: 0;
    top: 0;
    border-radius: 0 9px 9px 0;
    padding-top: 3vh;
    box-shadow:0 0 10px rgb(186, 186, 186);
    font-size: 2vh;
}
#searchIp{
    border-radius: 0 5px 5px 0;
    width: 80%;
    height: 3vh;
    border: none;
}
#searchIp:hover{
    width: 11vw;
    height: 4vh;
}
#searchIp:focus{
    width: 11vw;
    height: 4vh;
}
.Bts{
    /* border-radius: 5px; */
    background-color: rgb(49, 52, 53);
    border: none;
    border-radius: 12px;
    color:white;
    padding: 0.5vh 1vw;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 1.8vh;
    cursor: pointer;
    transition-duration: 0.4s;
    -webkit-transition-duration: 0.4s;
    margin-top: 2vh;
    margin-right: 1vw;
    width: 5vw;
    height: 3.7vh;
}
.Bts:hover{
    width: 5vw;
    height: 4vh;
}

#operate_2{
    position: absolute;
    top: 25vh;
    left: 1.5vw;
}
#addBlock{
    border-radius: 0 12px 12px 0;
    position: absolute;
    width: 11.5vw;
    height: 20vh;
    top: 10vh;
    background-color: rgb(186, 186, 186);
    padding: 2vh 0 0 0.7vw;
}
#Sbt{
    background-color: rgb(49, 52, 53);
    border: none;
    border-radius: 12px;
    color:white;
    padding: 0.5vh 1vw;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 1.8vh;
    cursor: pointer;
    transition-duration: 0.4s;
    -webkit-transition-duration: 0.4s;
    margin-top: 2vh;
    margin-right: 1vw;
    width: 9vw;
    height: 4.7vh;
}
#Sbt:hover{
    width: 10vw;
    height: 6vh;
}
.comIpt{
    border-radius: 5px;
    width: 90%;
    height: 4vh;
    border: none;
    margin-top: 2vh;
}
.comIpt:hover{
    box-shadow:0 0 1vh #ffffffd3;
}
.comIpt:focus{
    box-shadow:0 0 1vh #ffffffd3;
}
</style>
