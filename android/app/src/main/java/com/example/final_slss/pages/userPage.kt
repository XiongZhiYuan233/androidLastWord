package com.example.final_slss.pages

import android.annotation.SuppressLint
import androidx.annotation.Dimension
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.final_slss.R
import com.example.final_slss.config.RouteConfig
import com.example.final_slss.start
import com.example.final_slss.ui.theme.Final_SLSSTheme


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun userPage(navController: NavController){
    Column (modifier = Modifier
        .background(Color(0xFFF6F6F6))
        .fillMaxSize()
        .padding(top = 20.dp, bottom = 20.dp, start = 10.dp, end = 10.dp)
    ){
        Row() {
            Image(painter = painterResource(id = R.drawable.img_20230728_233223), contentDescription = "head",
                modifier = Modifier
                    .size(100.dp)
                    .clip(
                        shape = RoundedCornerShape(15.dp)
                    )
            )
            Column(modifier = Modifier
                .padding(top = 25.dp, start = 30.dp)
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Text(text = "username", fontSize = 20.sp)
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
        Row() {
            Box(modifier = Modifier
                .height(100.dp)
                .weight(1f)
                .padding(end = 10.dp)
                .background(Color(0xFFDEFCF9), shape = RoundedCornerShape(15.dp))
                .shadow(elevation = 0.2.dp, shape = RoundedCornerShape(15.dp))
            ){
                Text(modifier = Modifier
                    .align(Alignment.Center)
                    .padding(end = 100.dp)
                    ,text = "213")
            }
            Box(modifier = Modifier
                .height(100.dp)
                .weight(1f)
                .padding(end = 10.dp)
                .background(Color(0xFFDEFCF9), shape = RoundedCornerShape(15.dp))
                .shadow(elevation = 0.2.dp, shape = RoundedCornerShape(15.dp))
            ){
                Text(modifier = Modifier
                    .align(Alignment.Center)
                    .padding(end = 100.dp)
                    ,text = "qwrwqq")
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
                .shadow(elevation = 0.2.dp, shape = RoundedCornerShape(15.dp))
            ){
                Text(modifier = Modifier
                    .align(Alignment.Center)
                    .padding(end = 100.dp)
                    ,text = "213")
            }
            Box(modifier = Modifier
                .height(100.dp)
                .weight(1f)
                .padding(end = 10.dp)
                .background(Color(0xFFDEFCF9), shape = RoundedCornerShape(15.dp))
                .shadow(elevation = 0.2.dp, shape = RoundedCornerShape(15.dp))
            ){
                Text(modifier = Modifier
                    .align(Alignment.Center)
                    .padding(end = 100.dp)
                    ,text = "qwrwqq")
            }
        }
    }

}



@Composable
@Preview
fun test(){
    userPage(navController = rememberNavController())
}