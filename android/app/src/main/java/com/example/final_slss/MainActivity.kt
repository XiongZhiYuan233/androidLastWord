package com.example.final_slss

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.final_slss.route.NavController
import com.example.final_slss.ui.theme.Final_SLSSTheme
import com.example.final_slss.viewmodel.mainViewmodel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // A surface container using the 'background' color from the theme
            start(mainViewmodel())
        }
    }
}



@Composable
fun start(mainViewmodel: mainViewmodel){
    Final_SLSSTheme {
        // A surface container using the 'background' color from the theme
        val myNavController = rememberNavController()
//        val mainViewmodel by mainViewmodel.uiState.collectAsState()
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NavController(navController = myNavController, viewmodel = mainViewmodel)
        }

    }
}

@Preview
@Composable
fun preScaffold() {
    start(mainViewmodel())
}