<template>
    <div id="box">
      <div
      id="myChart_bloodOxygen"
      :style="{ float: 'right', width: '100%', height: '45vh',color: '#fff' }"
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
        bloodO:[],
        Interval:null,
        max:0,
        min:0
      }
    },
    mounted() {
      this.drawLine()
    },
    created() {
      // 创建WebSocket连接
      this.socket = new WebSocket('ws://localhost:8080/data/bloodOxygen/' + sessionStorage.getItem("user_email"));
  
      // 监听WebSocket连接打开
      this.socket.onopen = () => {
        console.log('WebSocket连接已打开(血氧)');
      };
  
      // 监听WebSocket接收到消息
      this.socket.onmessage = (event) => {
        console.log("-----------")
        console.log(event)
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
        myChart = echarts.init(document.getElementById('myChart_bloodOxygen'))
        myChart.setOption({
          title: {
              text: '血氧',
              top:0,
              left:5,
              textStyle: {
                // fontSize: 20,
                color:'#e2e2e2',
              }
            },
            xAxis: {
    type: 'category',
    data: this.time
  },
  yAxis: {
    name:"血氧mg/kg",
    type: 'value',
    max:this.max + 10,
    min:this.min - 10,
    axisLabel:{
                  formatter:function(value,index){
                  return value.toFixed(0)   
                  }
                }
  },
  series: [
    {
      data: this.bloodO,
      type: 'line',
      smooth: true
    }
  ]

          })

      },
    storedata(json_data){
      const data = JSON.parse(json_data.data)
      let temp_time =  []
      let temp_bloodO =  []
      this.max = data[1][0]
      this.min = data[1][0]
      for(let temp=0;temp<7;temp++){
        temp_time.push(data[0][temp])
        // console.log(data[0][temp])
        temp_bloodO.push(data[1][temp])
        if(data[1][temp]>this.max)
          this.max = data[1][temp]
        if(data[1][temp]<this.min)
          this.min = data[1][temp]
      }
      this.bloodO = temp_bloodO
      this.time = temp_time
      let splitNumber = 5
      this.Interval = (this.max - this.min + 20) / splitNumber
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
    height: 45vh;
    border-radius: 4%;
    float: right;
    clear: both;
  }
  </style>