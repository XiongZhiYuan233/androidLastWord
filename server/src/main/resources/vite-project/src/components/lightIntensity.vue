<template>
    <div id="box">
      <div
      id="myChart_lightIntensity"
      :style="{ float: 'left', width: '100%', height: '30vh' }"
    ></div>
    </div>
  </template>
  
  <script>
  import * as echarts from 'echarts'
  var myChart;
  export default {
      data() {
      return {
        time:[],
        lightL:[],
      }
    },
    mounted() {
      this.drawLine()
    },
    created() {
      // 创建WebSocket连接
      this.socket = new WebSocket('ws://localhost:8080/data/lightIntensity/' + sessionStorage.getItem("user_email"));
  
      // 监听WebSocket连接打开
      this.socket.onopen = () => {
        console.log('WebSocket连接已打开(心率)');
      };
  
      // 监听WebSocket接收到消息
      this.socket.onmessage = (event) => {
        this.storedata(event)
        this.drawLine()
      };
    },
    methods: {
      // // 发送消息
      // sendMessage(message) {
      //   if (this.socket.readyState === WebSocket.OPEN) {
      //     this.socket.send(message);
      //   } else {
      //     console.error('WebSocket连接未打开');
      //   }
      // },
      drawLine() {
        if (myChart != null && myChart != "" && myChart != undefined) {
          myChart.dispose();//销毁
        }
        myChart = echarts.init(document.getElementById('myChart_lightIntensity'))
        myChart.setOption({
          title: {
              text: '光照强度',
              top:0,
              left:5,
              textStyle: {
                // fontSize: 20,
                color:'#e2e2e2',
              }
            },
            xAxis: {
    type: 'category',
    boundaryGap: false,
    data: this.time
  },
  yAxis: {
    type: 'value',
    name:"光照强度/Lux"
  },
  series: [
    {
      data: this.lightL,
      type: 'line',
      areaStyle: {}
    }
  ]
      
    
          })
      },
      storedata(json_data){
      const data = JSON.parse(json_data.data)
      let temp_time =  []
      let temp_lightL =  []
      console.log(json_data)
      for(let temp=0;temp<7;temp++){
        temp_time.push(data[0][temp])
        // console.log(data[0][temp])
        temp_lightL.push(data[1][temp])
      }
      this.lightL = temp_lightL
      this.time = temp_time
    }
    },
    beforeDestroy() {
      // 关闭WebSocket连接
      this.socket.close();
    }
  }
  </script>
  
  <style scoped>
  #box{
    background-color:#1c1919d3;
    width: 100%;
    height: 30vh;
    border-radius: 4%;
    float: right;
    clear: both;
  }
  </style>