package com.example.final_slss.viewmodel

import androidx.lifecycle.ViewModel
import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.example.final_slss.config.RouteConfig
import com.example.final_slss.datamodel.healthUiState
import com.example.final_slss.datamodel.mainUiState
import com.example.final_slss.datamodel.websocket
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import java.io.IOException


class mainViewmodel :ViewModel(){
    private val ip = "172.20.10.4:8080"
    private val _uiState = MutableStateFlow(mainUiState())
    val uiState: StateFlow<mainUiState> = _uiState.asStateFlow()

    private val _uiState_health = MutableStateFlow(healthUiState())
    val uiState_health: StateFlow<healthUiState> = _uiState_health.asStateFlow()
    /**
     * OkHttp 客户端
     * 注意 : 该类型对象较大, 尽量在应用中创建较少的该类型对象
     * 推荐使用单例
     */

    private val mOkttpClient = OkHttpClient()

//    val userdata = mainUiState();

    val MY_JSON = MediaType.parse("application/json; charset=utf-8")
    init {
//        login()
        println("初始化成功")
    }
    fun changeUserData(useremail : String = _uiState.value.useremail,password :String = _uiState.value.password){
//        userdata.useremail = useremail;
//        userdata.password = password;
        _uiState.value = mainUiState(useremail = useremail,password = password)
    }
    fun opensocket(){
        val websocketbloodOxygen = websocket(mOkttpClient,"ws://"+ip+"/data/bloodOxygen/"+_uiState.value.useremail,uiState_health,"bloodOxygen")
        val websocketHeartRate = websocket(mOkttpClient,"ws://"+ip+"/data/heartRate/"+_uiState.value.useremail,uiState_health,"HeartRate")
        val websocketHumiture = websocket(mOkttpClient,"ws://"+ip+"/data/humiture/"+_uiState.value.useremail,uiState_health,"Humiture")
        val websocketLightIntensity = websocket(mOkttpClient,"ws://"+ip+"/data/lightIntensity/"+_uiState.value.useremail,uiState_health,"LightIntensity")
    }
    fun login(){
        val json_f = JSONObject()
        json_f.put("user_email",_uiState.value.useremail)
        json_f.put("password_hash",_uiState.value.password)
//        val json_1 = JSONObject()
//        json_1.put("user",json_2)
//        println("json"+json_1)


//传过去的数据为null，user已经有了，说明是json处理出了问题
        val json = json_f.toString()
        val body: RequestBody = RequestBody.create(MY_JSON, json)
        val request = Request.Builder()
            .url("http://"+ip+"/login")
            .post(body)
            .build()

        mOkttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                // 请求失败处理
                println("请求失败")
                println(e)
            }

            override fun onResponse(call: Call, response: Response) {
                // 请求成功处理
                val responseData = response.body()?.string()
                if(responseData!=null && responseData != "default"){
                    _uiState.value.token = responseData;
                }
                println("usertoken"+_uiState.value.token)
                println("成功")
                opensocket()
                // 解析数据或更新UI等操作
            }
        })
    }
    fun register(){
        val json_f = JSONObject()
        json_f.put("user_email",_uiState.value.useremail)
        json_f.put("password_hash",_uiState.value.password)
//        val json_1 = JSONObject()
//        json_1.put("user",json_2)
//        println("json"+json_1)


//传过去的数据为null，user已经有了，说明是json处理出了问题
        val json = json_f.toString()
        val body: RequestBody = RequestBody.create(MY_JSON, json)
        val request = Request.Builder()
            .url("http://"+ip+"/addUser")
            .post(body)
            .build()

        mOkttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                // 请求失败处理
                println("请求失败")
                println(e)
            }

            override fun onResponse(call: Call, response: Response) {
                // 请求成功处理
//                val responseData = response.body()?.string()
//                if(responseData!=null && responseData != "default"){
//                    _uiState.value.token = responseData;
//                }
//                println("usertoken"+_uiState.value.token)
                println("注册成功")
                _uiState.value.password = "";
                // 解析数据或更新UI等操作
            }
        })
    }
}