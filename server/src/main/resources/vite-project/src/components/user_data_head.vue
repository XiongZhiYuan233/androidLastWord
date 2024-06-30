<template>
  <div id="imag">
    <img id="userimg" style="width: 25vw;" :src="'data:;base64,'+ user_image">
  </div>
  <div id="name">{{ user_name }}</div>

</template>

<script>
import axios from 'axios';
export default {
    data() {
        return {
            user_image:'',
            user_name:"gray"
        }
    },
    created(){
        axios
        .get('/api/getdata',{                          
            headers:{
                token:sessionStorage.getItem("token")
            }
        })
        .then(response => {
            console.log(response)
            this.user_image = response.data[0]
            this.user_name = response.data[1]
        })
        .catch(console.error())
    }
}
</script>

<style scoped>
    #imag{
        /* background-color: black; */
        margin-top: 10vh;
        margin-left: 3vw;
    }
    #userimg{
        box-shadow: 2px 2px 3px rgb(108, 106, 106);
        border-radius: 3px;
    }
    #name{
        color: #aaa6a6;
        font-weight: 800;
        font-size: 3vw;
        margin: 1vh 0 1vh 3vw;
    }
</style>