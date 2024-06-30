package com.example.final_slss.datamodel

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.flow.StateFlow
import okhttp3.OkHttpClient
import java.util.Arrays


class websocket(client:OkHttpClient,url:String,uiState: StateFlow<healthUiState>,judge:String) {

    val request = okhttp3.Request.Builder()
        .url(url)
        .build()

    val ws = client.newWebSocket(request, object : okhttp3.WebSocketListener() {
        override fun onOpen(webSocket: okhttp3.WebSocket, response: okhttp3.Response) {
            // 连接成功时的回调
            println("WebSocket connection opened.")
        }

        override fun onMessage(webSocket: okhttp3.WebSocket, text: String) {
            // 接收到文本消息时的回调
            println("Received message: $text")
            transport(text,judge,uiState)
        }

        override fun onClosing(webSocket: okhttp3.WebSocket, code: Int, reason: String) {
            // 连接关闭前的回调
            println("WebSocket connection is closing with code $code and reason '$reason'")
        }

        override fun onClosed(webSocket: okhttp3.WebSocket, code: Int, reason: String) {
            // 连接关闭后的回调
            println("WebSocket connection closed with code $code and reason '$reason'")
        }

        override fun onFailure(webSocket: okhttp3.WebSocket, t: Throwable, response: okhttp3.Response?) {
            // 连接失败时的回调
            println("WebSocket failed with error: ${t.message}")
        }
    })

}

fun transport(inputString:String,judge: String,uiState: StateFlow<healthUiState>) {
    if(judge == "bloodOxygen"){
//        var list1 = inputString.split("],[")[0]
        var list2 = inputString.split("],[")[1]
//        val r1 = Regex("\"(.*?)\"")
//        uiState.value.bloodOxygen = r1.findAll(list2).toList()[6].toString().replace("\"","")
        uiState.value.bloodOxygen = list2.split(",")[6].replace("]]","")
    }
    else if(judge == "LightIntensity"){
//        var list1 = inputString.split("],[")[0]
        var list2 = inputString.split("],[")[1]
//        val r1 = Regex("\"(.*?)\"")
//        uiState.value.LightIntensity = r1.findAll(list2).toList()[6].toString().replace("\"","")
        uiState.value.LightIntensity = list2.split(",")[6].replace("]]","")

    }else if(judge == "Humiture"){
        var list2 = inputString.split("],[")[1]
        var list3 = inputString.split("],[")[2]
        uiState.value.Tem = list2.split(",")[6]
        uiState.value.Hum = list3.split(",")[6].replace("]]","")
        println(uiState.value.Tem)
        println(uiState.value.Hum )
    }else if(judge == "HeartRate"){
        uiState.value.HeartRate = inputString
    }
}

