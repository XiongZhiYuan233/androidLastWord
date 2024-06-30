<template>
    <div id="box">
      <div
      id="myChart_heartRate"
      :style="{ float: 'right', width: '100%', height: '30vh' }"
    ></div>
    </div>
  </template>
  
  <script>
  import * as echarts from 'echarts'
  var myChart;
  export default {
      data() {
      return {
        heartRate:null
      }
    },
    mounted() {
      this.drawLine()
    },
    created() {
      // 创建WebSocket连接
      this.socket = new WebSocket('ws://localhost:8080/data/heartRate/' + sessionStorage.getItem("user_email"));
  
      // 监听WebSocket连接打开
      this.socket.onopen = () => {
        console.log('WebSocket连接已打开(心率)');
      };
  
      // 监听WebSocket接收到消息
      this.socket.onmessage = (event) => {
        this.heartRate = event.data / 100
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
        myChart = echarts.init(document.getElementById('myChart_heartRate'))
        myChart.setOption({
          title: {
              text: '心率',
              top:0,
              left:5,
              textStyle: {
                // fontSize: 20,
                color:'#e2e2e2',
              }
            },
              series: [
    {
      type: 'gauge',
      startAngle: 180,
      endAngle: 0,
      center: ['50%', '75%'],
      radius: '90%',
      min: 0,
      max: 1,
      splitNumber: 8,
      axisLine: {
        lineStyle: {
          width: 6,
          color: [
            [0.25, '#FF6E76'],
            [0.5, '#FDDD60'],
            [0.75, '#58D9F9'],
            [1, '#7CFFB2']
          ]
        }
      },
      pointer: {
        icon: 'path://M12.8,0.7l12,40.1H0.7L12.8,0.7z',
        length: '12%',
        width: 20,
        offsetCenter: [0, '-60%'],
        itemStyle: {
          color: 'auto'
        }
      },
      axisTick: {
        length: 12,
        lineStyle: {
          color: 'auto',
          width: 2
        }
      },
      splitLine: {
        length: 20,
        lineStyle: {
          color: 'auto',
          width: 5
        }
      },
      axisLabel: {
        color: '#464646',
        fontSize: 20,
        distance: -60,
        rotate: 'tangential',
        formatter: function (value) {
          if (value === 0.875) {
            return 'Grade A';
          } else if (value === 0.625) {
            return 'Grade B';
          } else if (value === 0.375) {
            return 'Grade C';
          } else if (value === 0.125) {
            return 'Grade D';
          }
          return '';
        }
      },
      title: {
        offsetCenter: [0, '-10%'],
        fontSize: 20
      },
      detail: {
        fontSize: 30,
        offsetCenter: [0, '-35%'],
        valueAnimation: true,
        formatter: function (value) {
          return Math.round(value * 100) + '';
        },
        color: 'inherit'
      },
      data: [
        {
          value: this.heartRate,
          name: '心率'
        }
      ]
    }
  ]
          })
      },
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