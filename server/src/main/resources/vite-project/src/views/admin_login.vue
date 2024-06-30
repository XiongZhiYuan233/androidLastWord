<template>
    <div id="this">
      <div style="text-align: center;margin-bottom: 5%;">
          <h1 style="color: rgb(28, 29, 31);margin-bottom: 10%;">
              管理员登陆
          </h1>
          <h5 style="color: rgba(93, 98, 103, 0.635);">
              采用vue和springboot制作的系统
          </h5>
      </div>
      <div class="mb-3 mt-3">
          <label for="email" class="form-label">Email:</label>
          <input type="email" class="form-control" id="email" placeholder="Enter email" v-model="user.user_email" name="email">
      </div>
      <div class="mb-3">
          <label for="pwd" class="form-label">Password:</label>
          <input type="password" class="form-control" id="pwd" placeholder="Enter password" v-model="user.password_hash" name="pswd">
      </div>
      <!-- <div class="form-check mb-3">
          <label class="form-check-label">
              <input class="form-check-input" type="checkbox" name="remember"> Remember me
          </label>
      </div> -->
      <button type="submit" class="my_btn" @click="judge">Submit</button>
      <!-- <component :is="'https://www.google.com/recaptcha/api.js'"></component> -->
    </div>
  </template>
  
  <script>
  import axios from 'axios'
  // import func from 'vue-editor-bridge'
  
  export default {
    data(){
      return {
        user:{
          user_email:null,
          password_hash:null
        }
      }
    },
    methods:{
      judge(){
        // console.log(11),
        axios
        .post('/api/admin_login', this.user)
        .then(response => {
          if(response.data != "default"){
            // 登陆后存储并跳转
            this.$emit('login',response.data),
            sessionStorage.setItem("token",response.data),
            sessionStorage.setItem("user_email",this.user.user_email),
            this.$router.push({name: 'admin_index'})
          }
        })
        .catch(function(error){
          console.log(error);
        })
        // axios
        // .post('/user_data',{
        //   Headers:{
        //     token:sessionStorage.getItem("token"),
        //     data:{user}
        //   }
        // })
        // const {data:res} = await this.$ajax({
        //   methods: 'Get',
        //   // method:'Post',
        //   // url:'/login',
        //   url:'/test',
        //   data:this.user
        // }).then(()=>{
        //   if(res == 0){
  
        //   }
        //   this.$emit('login',1)
        //   console.log(res)
        // }
        
        
      }
    }
  }
  </script>
  
  <style scoped>
  #this{
      /* background-color:#242424; */
      color: rgb(28, 29, 31);
      position: absolute;
      left: 30vw;
      top: 20vh;
      width: 40%;
      z-index: 100;
  }
  input{
      color-scheme: light dark;
  }
  .my_btn{
    margin:auto 0;
    border-radius: 8px;
    border: 1px solid transparent;
    padding: 0.6em 1.2em;
    font-size: 1em;
    font-weight: 500;
    font-family: inherit;
    background-color: #484747;
    cursor: pointer;
    transition: border-color 0.25s;
  }
  .my_btn:hover {
    border-color: #646cff;
  }
  .my_btn:focus,
  .my_btn:focus-visible {
    outline: 4px auto -webkit-focus-ring-color;
  }
  </style>