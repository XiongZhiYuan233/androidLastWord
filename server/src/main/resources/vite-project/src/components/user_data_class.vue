<template>
    <div id="box">
        <span>邮箱</span>
        <span id="seperate"></span>
        <span>用户名</span>
        <span id="seperate"></span>
        <span>性别</span>
        <span id="seperate"></span>
        <span>年龄</span>
        <span id="seperate"></span>
        <span>身高</span>
        <span id="seperate"></span>
        <span>电话号码</span>
        <span id="seperate"></span>
        <span>修改信息</span>
        <span id="seperate"></span>
        <span>删除信息</span>
    </div>
</template>

<script>
export default{

}
</script>

<style scoped>
#box{
    z-index: 100;
    position: fixed;
    top: 0;
    /* margin: 100px 0 100px 100px; */
    /* margin: 50px 0; */
    

    background-color: #ffffff;
    border-radius: 0 0 10px 10px;
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
/* #box:hover{
    box-shadow:0 0 10px #00000041;
    transform: translateX(1px);
    transform: translateY(-1px);
} */
#box span{
    /* margin: 3vh; */
    /* width: 10px; */
    /* overflow: hidden; */
    overflow-x: auto;
    padding-top: 2vh;
    margin: 0 1vw;
}
#seperate{
    border-right: #818c87ab 5px solid;
    border-radius: 100px;
    margin:auto 0 !important;
    padding: 0 !important;
    height: 7vh;
    box-shadow:0 0 5px #818c87ab;
}


#my_button{
    background-color: rgb(49, 52, 53);
    border: none;
    border-radius: 12px;
    color:white;
    padding: 1vh 2vw;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
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