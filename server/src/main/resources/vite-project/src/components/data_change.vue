<template>
  <div>
    <button id="change" @click="myClick()" v-if=!b_or_n>EditProfile</button>
    <div id="dataForm" v-if=b_or_n>
        <div id="formContent">
            <form>
                <div>
                    <span>Name</span>
                    <input id="age" v-model="user.name">
                </div>
                <div>
                    <span>Sex</span>
                    <input id="address" v-model="user.sex">
                </div>
                <div>
                    <span>Age</span>
                    <input id="age" v-model="user.age">
                </div>
                <div>
                    <span>Stature</span>
                    <input id="age" v-model="user.stature">
                </div>
                <div>
                    <span>PhoneNumber</span>
                    <input id="age" v-model="user.phonenumber">
                </div>
                <div>
                    <span>image</span>
                    <input type="file" @change="handleImageUpload" style="color: black">
                </div>
            </form>
            <button id="button_1" type="submit" @click="submit">Submit</button>
            <button id="button_2" @click="myClick">close</button>
        </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
    data(){
        return{
            b_or_n:false,
            user:{
                name:null,
                sex:null,
                age:null,
                stature:null,
                phonenumber:null
            },
            headportrait:null
        }
    },
    methods:{
        myClick(){
            console.log(1)
            this.b_or_n = !this.b_or_n
        },
        submit(){
            let formData = new FormData();
            formData.append('name', this.user.name);
            formData.append('sex', this.user.sex);
            formData.append('age', this.user.age);
            formData.append('stature', this.user.stature);
            formData.append('phonenumber', this.user.phonenumber);
            formData.append('headportrait', this.headportrait);
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
        handleImageUpload(event) {
            this.headportrait = event.target.files[0];
        }       
    }
}
</script>

<style scoped>
input{
    padding: 5px 12px;
    font-size: 14px;
    line-height: 20px;
    /* color: var(--fgColor-default, var(--color-fg-default)); */
    vertical-align: middle;
    background-color: var(--bgColor-default, var(--color-canvas-default));
    background-repeat: no-repeat;
    background-position: right 8px center;
    border: 1px solid rgba(106, 104, 104, 0.675);
    border-radius: 6px;
    box-shadow: var(--shadow-inset, var(--color-primer-shadow-inset));
    transition: 80ms cubic-bezier(0.33, 1, 0.68, 1);
    transition-property: color, background-color, box-shadow, border-color;
    color: rgb(255, 255, 255);
}
#dataForm{
    /* position:fixed; */
    /* top: 0; */
    /* left: 0; */
    width: 25vw;
    height: 100%;
    /* background: rgba(67, 58, 58, 0.5); */
    z-index: 101;
}
#formContent{
    /* position:fixed; */
    /* top: 10vh; */
    /* left: 25%; */

    width: 50%;
    /* padding: 13px; */
    /* background: rgb(156, 156, 156); */
    margin-left: 3vw;
}
#formContent div{
    margin: 1vh 0;
}
#formContent div span{
    /* margin-right: 5px; */
    color: black;
}
button{
    margin: 1vh 0 0 3vw;
    display: block;
    width: 25vw;
    text-align: center;
    position: relative;
    display: inline-block;
    padding: 5px 16px;
    font-size: 14px;
    font-weight: var(--base-text-weight-medium, 500);
    line-height: 20px;
    white-space: nowrap;
    vertical-align: middle;
    cursor: pointer;
    -webkit-user-select: none;
    user-select: none;
    border: 1px solid;
    border-radius: 6px;
    -webkit-appearance: none;
    appearance: none;
    color: var(--button-default-fgColor-rest, var(--color-btn-text));
    border-color: var(--button-default-borderColor-rest, var(--color-btn-border));
    box-shadow: var(--button-default-shadow-resting, var(--color-btn-shadow)), var(--button-default-shadow-inset, var(--color-btn-inset-shadow));
    transition: 80ms cubic-bezier(0.33, 1, 0.68, 1);
    transition-property: color, background-color, box-shadow, border-color;
}
form div span{
    color: aliceblue;
    font-weight: var(--base-text-weight-semibold, 600);
}
#button_1{
    margin: 1vh 1vw 1vh 0;
    width: 80px;
    background-color: #3fb950;
    font-weight: 700;
    color: white;
    border: 0;

}
#button_2{
    margin: 1vh 0 1vh 0vw;
    font-weight: 700;
    width: 80px;
}
</style>