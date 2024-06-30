<template>
  <div id="box">
    <div
    id="myChart_humiture"
    :style="{ float: 'left', width: '100%', height: '45vh' }"
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
      tem:[],
      hum:[],
      tem_max:null,
      hum_max:null,
      tem_min:null,
      hum_min:null,
      Interval_t:null,
      Interval_h:null
    }
  },
  mounted() {
    this.drawLine()
  },
  created() {
    // 创建WebSocket连接
    this.socket = new WebSocket('ws://localhost:8080/data/humiture/' + sessionStorage.getItem("user_email"));

    // 监听WebSocket连接打开
    this.socket.onopen = () => {
      console.log('WebSocket连接已打开(温湿度)');
    };

    // 监听WebSocket接收到消息
    this.socket.onmessage = (event) => {
      this.storedata(event)
      this.getaxis()
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
      myChart = echarts.init(document.getElementById('myChart_humiture'))
      myChart.setOption({
            // color:'#fff',
            title: {
              text: '温湿度',
              top:0,
              left:5,
              textStyle: {
                // fontSize: 20,
                color:'#e2e2e2',
              }
            },
            xAxis: {
              // type: 'category',
              data: this.time
            },
            yAxis: [
              {
                type: 'value',
                name:'温度/℃',
                max:this.tem_max + 10,
                min:this.tem_min - 10,
                interval: this.Interval_t,
                axisLabel:{
                  formatter:function(value,index){
                  return value.toFixed(2)   
                  }
                }
              },
              {
                type: 'value',
                name:'湿度/RH',
                max:this.hum_max + 10,
                min:this.hum_min - 10,
                interval: this.Interval_h,
              }
            ],
            legend: {
               data:['温度', '湿度'],
               textStyle:{
                color: '#ffffff',
               },
               top:10
            },
            series: [
              {
                name:"温度",
                data: this.tem,
                type: 'line',
                yAxisIndex: 0
              },
              {
                name:"湿度",
                data: this.hum,
                type: 'line',
                yAxisIndex: 1
              }
            ]

        })
    },
    getaxis(){
      this.tem_max = this.tem[0]
      this.hum_max = this.tem[0]
      this.tem_min = this.hum[0]
      this.hum_min = this.hum[0]
      for(let temp=0;temp<7;temp++){
        if(this.tem[temp]>this.tem_max)
        this.tem_max = this.tem[temp]
        if(this.tem[temp]<this.tem_min)
        this.tem_min = this.tem[temp]
        if(this.hum[temp]>this.hum_max)
        this.hum_max = this.hum[temp]
        if(this.hum[temp]<this.hum_min)
        this.hum_min = this.hum[temp]
      }
      let splitNumber = 10
      this.Interval_t = (this.tem_max - this.tem_min + 20) / splitNumber
      this.Interval_h = (this.hum_max - this.hum_min + 20) / splitNumber
    },
    storedata(json_data){
      const data = JSON.parse(json_data.data)
      let temp_tem =  []
      let temp_hum =  []
      let temp_time =  []
      console.log(json_data)
      for(let temp=0;temp<7;temp++){
        temp_time.push(data[0][temp])
        // console.log(data[0][temp])
        temp_tem.push(data[1][temp])
        temp_hum.push(data[2][temp])
      }
      this.tem = temp_tem
      this.hum = temp_hum
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
  height: 45vh;
  border-radius: 4%;
  color: #e2e2e2;
}
</style>