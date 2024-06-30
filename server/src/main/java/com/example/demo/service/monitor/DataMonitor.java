package com.example.demo.service.monitor;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.iot.model.v20180120.*;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.example.demo.controller.WebsocketController_bloodOxygen;
import com.example.demo.controller.WebsocketController_heartRate;
import com.example.demo.controller.WebsocketController_humiture;
import com.example.demo.controller.WebsocketController_lightIntensity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.google.gson.*;

import java.text.SimpleDateFormat;
import java.util.*;


@Component
public class DataMonitor {

    private WebsocketController_humiture Websocketcontroller_humiture = new WebsocketController_humiture();
    private WebsocketController_heartRate Websocketcontroller_heartRate = new WebsocketController_heartRate();
    private WebsocketController_bloodOxygen Websocketcontroller_bloodOxygen = new WebsocketController_bloodOxygen();
    private WebsocketController_lightIntensity Websocketcontroller_lightIntensity = new WebsocketController_lightIntensity();
//    @Scheduled(fixedRate = 10000)  // 每10秒执行一次
    public void humiture() throws JsonProcessingException {
        Object[][] data = new Object[3][];
        data[0] = new String[]{"11:01", "11:11", "11:21", "11:31", "11:41", "11:51", "12:01"};
        data[1] = new Integer[]{10, 20, 30, 40, 50, 60, 70};
        data[2] = new Integer[]{50, 20, 70, 20, 100, 80, 90};

        ObjectMapper mapper = new ObjectMapper();
        String jsonArr = mapper.writeValueAsString(data);
        Websocketcontroller_humiture.sendOneMessage("123456789@163.com",jsonArr);
    }

//    @Scheduled(fixedRate = 10000)  // 每10秒执行一次
    public void heartRate() throws JsonProcessingException {
        String data = "100";
        Websocketcontroller_heartRate.sendOneMessage("123456789@163.com",data);
    }

    DataMonitor() {
        for(int i=0;i<7;i++){
            time.offer("00:00");
            tem.offer(0f);
            hum.offer(0d);
            bloodOxy.offer(0d);
            lightInt.offer(0f);
            heartRat = 0d;
        }
    }

    private static Queue<String> time = new ArrayDeque<>();
    private static String last_time = null;
    private static Queue<Float>tem = new ArrayDeque<>();
    private static Queue<Double>hum = new ArrayDeque<>();
    private static Queue<Double> bloodOxy = new ArrayDeque<>();
    private static Queue<Float> lightInt = new ArrayDeque<>();
    private static double heartRat;

    public  static DefaultAcsClient client;
    private static final String a = "";
    private static final String b ="";
    private static final String c = "";
    private static final String d = "";
    private static final String e="";
    private static final String f = "";
//    @Scheduled(fixedRate = 1000)  // 每1秒执行一次
    public void getData(){
        //帮助文档
        //https://help.aliyun.com/zh/iot/developer-reference/use-iot-platform-sdk-for-java-1?spm=a2c4g.11186623.0.0.2ac16bc3bBy4hH
        //csdn资料
        //https://blog.csdn.net/qq_39724355/article/details/131683340


        //初始化客户端连接对象
        IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        client = new DefaultAcsClient(profile);
        //构建数据查询请求
        QueryDevicePropertyStatusRequest request = new QueryDevicePropertyStatusRequest();
        request.setRegionId(regionId);
        request.setIotInstanceId(iotid);
        request.setDeviceName(deviceName);
        request.setProductKey(deviceProductkey);
        //获取返回值，并对数据进行解析输出
//        try {
//            // 发起查询设备属性请求
//            QueryDevicePropertyStatusResponse response = client.getAcsResponse(request);
//            // 处理查询结果
//            // 可以从response中获取传感器的数据
//            // 获取传感器数据
//            String string= JSON.toJSONString(response);
//            // 解析JSON数据
//            // 创建Gson对象
//            Gson gson = new Gson();
//            // 将JSON字符串解析为JsonObject
//            JsonObject jsonObject = gson.fromJson(string, JsonObject.class);
//            // 从JsonObject中提取"data"字段
//            JsonObject dataObject = jsonObject.getAsJsonObject("data");
//            System.out.println(string);
//            // 提取"data"字段中的"list"数组
//            JsonArray dataList = dataObject.getAsJsonArray("list");
//            Map<String, String> keyValueMap = new HashMap<>();
//            for (JsonElement element : dataList) {
//                JsonObject jsonObj = element.getAsJsonObject();
//                String key = jsonObj.get("key").getAsString();
//                String value = jsonObj.get("value").getAsString();
//                keyValueMap.put(key, value);
//            }
//
//            // 获取数据字段
//            System.out.println(keyValueMap);
////            System.out.println(keyValueMap.get(""));
//            //将传感器数据输出
////            System.out.println("传感器数据：" + list.get(0).getAsJsonObject().get("value"));
//
//        } catch (ClientException e) {
//            // 处理异常
//            e.printStackTrace();

//        } catch (ServerException e) {
//            throw new RuntimeException(e);
//        } catch (ClientException e) {
//            throw new RuntimeException(e);
        try {
            // 发起查询设备属性请求
            QueryDevicePropertyStatusResponse response = client.getAcsResponse(request);
            // 处理查询结果
            // 可以从response中获取传感器的数据
            // 获取传感器数据
            String string=JSON.toJSONString(response);
            // 解析JSON数据
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = (JsonObject) parser.parse(string);
            // 获取数据字段
            String s_o_n = jsonObject.get("success").getAsString();
            System.out.println(string);
            System.out.println(s_o_n);




            if(Objects.equals(s_o_n, "true")){
                JsonObject data = (JsonObject) jsonObject.get("data");
                JsonArray list = (JsonArray) data.get("list");
//                //将传感器数据输出
//                All_sensorData all_sensorData = new All_sensorData();
//                all_sensorData.setBloodOxygen();
//                all_sensorData.setHumidity();
//                all_sensorData.setHeartRate();
//                all_sensorData.setTemperature();
//                all_sensorData.setLightLntensity();
//                all_sensorData.setTime(new Date(list.get(0).getAsJsonObject().get("time").getAsLong()));
//                System.out.println(all_sensorData.getTime());
                SimpleDateFormat format = new SimpleDateFormat ("HH:mm");
                String now_time = format.format(new Date(list.get(0).getAsJsonObject().get("time").getAsLong()));
                if(!Objects.equals(last_time,now_time)){
                    last_time =now_time;
                    time.poll();
                    time.offer(now_time);
                    tem.poll();
                    tem.offer(list.get(9).getAsJsonObject().get("value").getAsFloat());
                    hum.poll();
                    hum.offer(list.get(10).getAsJsonObject().get("value").getAsDouble());
                    bloodOxy.poll();
                    bloodOxy.offer(list.get(13).getAsJsonObject().get("value").getAsDouble());
                    lightInt.poll();
                    lightInt.offer(list.get(11).getAsJsonObject().get("value").getAsFloat());
                    heartRat = list.get(12).getAsJsonObject().get("value").getAsDouble();

                    senddata(5);
                }

            }

        } catch (ClientException e) {
            // 处理异常
            e.printStackTrace();
        }
        }
        public void senddata(int which_data){
            JsonArray jsonarr_t_h = new JsonArray();
            jsonarr_t_h.add(new Gson().toJsonTree(time).getAsJsonArray());
            jsonarr_t_h.add(new Gson().toJsonTree(tem).getAsJsonArray());
            jsonarr_t_h.add(new Gson().toJsonTree(hum).getAsJsonArray());

            JsonArray jsonarr_bo = new JsonArray();
            jsonarr_bo.add(new Gson().toJsonTree(time).getAsJsonArray());
            jsonarr_bo.add(new Gson().toJsonTree(bloodOxy).getAsJsonArray());

            JsonArray jsonarr_li = new JsonArray();
            jsonarr_li.add(new Gson().toJsonTree(time).getAsJsonArray());
            jsonarr_li.add(new Gson().toJsonTree(lightInt).getAsJsonArray());

            if(which_data==1){
                Websocketcontroller_humiture.sendOneMessage("123456789@163.com", String.valueOf(jsonarr_t_h));
            } else if (which_data == 2) {
                Websocketcontroller_bloodOxygen.sendOneMessage("123456789@163.com", String.valueOf(jsonarr_bo));
            } else if (which_data == 3) {
                Websocketcontroller_lightIntensity.sendOneMessage("123456789@163.com", String.valueOf(jsonarr_li));
            } else if (which_data == 4) {
                Websocketcontroller_heartRate.sendOneMessage("123456789@163.com", String.valueOf(heartRat));
            }else {
                Websocketcontroller_humiture.sendOneMessage("123456789@163.com", String.valueOf(jsonarr_t_h));
                Websocketcontroller_bloodOxygen.sendOneMessage("123456789@163.com", String.valueOf(jsonarr_bo));
                Websocketcontroller_lightIntensity.sendOneMessage("123456789@163.com", String.valueOf(jsonarr_li));
                Websocketcontroller_heartRate.sendOneMessage("123456789@163.com", String.valueOf(heartRat));
            }
        }
    }

