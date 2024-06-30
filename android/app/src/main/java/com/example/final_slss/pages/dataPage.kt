package com.example.final_slss.pages


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.final_slss.config.RouteConfig
import com.example.final_slss.ui.theme.Final_SLSSTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.final_slss.R


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun dataPage(navController: NavController,
             bloodOxygen : String = "",
             HeartRate : String = "",
             Hum : String = "",
             Tem : String = "",
             LightIntensity : String = ""
             ){
    Column (modifier = Modifier
        .background(Color(0xFFF6F6F6))
        .fillMaxSize()
        .padding(top = 20.dp, bottom = 20.dp, start = 10.dp, end = 10.dp)
    ){
        Text(text = "HealthData",
            fontSize = 45.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally))
        Row() {
            Box(modifier = Modifier
                .height(100.dp)
                .weight(1f)
                .padding(end = 10.dp)
                .background(Color(0xFFDEFCF9), shape = RoundedCornerShape(15.dp))
                .shadow(elevation = 0.2.dp, shape = RoundedCornerShape(1.dp))
            ){
                Text(modifier = Modifier
                    .align(Alignment.Center)
                    .padding(end = 10.dp)
                    ,text = "bloodOxygen: "+bloodOxygen)
            }
            Box(modifier = Modifier
                .height(100.dp)
                .weight(1f)
                .padding(end = 10.dp)
                .background(Color(0xFFDEFCF9), shape = RoundedCornerShape(15.dp))
                .shadow(elevation = 0.2.dp, shape = RoundedCornerShape(1.dp))
            ){
                Text(modifier = Modifier
                    .align(Alignment.Center)
                    .padding(end = 10.dp)
                    ,text = "HeartRate: "+HeartRate)
            }
        }
        Row(modifier = Modifier
            .padding(top = 20.dp)
        ) {
            Box(modifier = Modifier
                .height(100.dp)
                .weight(1f)
                .padding(end = 10.dp)
                .background(Color(0xFFDEFCF9), shape = RoundedCornerShape(15.dp))
                .shadow(elevation = 0.2.dp, shape = RoundedCornerShape(1.dp))
            ){
                Column(modifier = Modifier
                    .padding(top = 10.dp, start = 30.dp)) {
                    Text(modifier = Modifier
                        .padding(end = 10.dp)
                        ,text = "Hum: "+Hum)
                    Text(modifier = Modifier
                        .padding(top = 20.dp,end = 10.dp)
                        ,text = "Tem: "+Tem)
                }
//                Text(modifier = Modifier
//                    .align(Alignment.Center)
//                    .padding(end = 100.dp)
//                    ,text = "Hum: "+Hum)
//                Text(modifier = Modifier
//                    .align(Alignment.Center)
//                    .padding(end = 10.dp)
//                    ,text = "Tem: "+Tem)
            }
            Box(modifier = Modifier
                .height(100.dp)
                .weight(1f)
                .padding(end = 10.dp)
                .background(Color(0xFFDEFCF9), shape = RoundedCornerShape(15.dp))
                .shadow(elevation = 0.2.dp, shape = RoundedCornerShape(1.dp))
            ){
                Text(modifier = Modifier
                    .align(Alignment.Center)
                    .padding(end = 10.dp)
                    ,text = "LightIntensity: "+LightIntensity)
            }
        }
    }
}