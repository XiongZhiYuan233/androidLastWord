package com.example.final_slss.route

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.final_slss.config.RouteConfig
import com.example.final_slss.pages.dataPage
import com.example.final_slss.pages.loginPage
import com.example.final_slss.pages.registerPage
import com.example.final_slss.pages.userPage
import com.example.final_slss.ui.theme.Final_SLSSTheme
import com.example.final_slss.viewmodel.mainViewmodel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavController(modifier: Modifier = Modifier,
                  navController: NavHostController,
                  viewmodel: mainViewmodel) {
//    val navController = rememberNavController()
    val mainViewModeluistate by viewmodel.uiState.collectAsState()
    val mainViewModelhealeth by viewmodel.uiState_health.collectAsState()
    Final_SLSSTheme {
        MaterialTheme{
            Scaffold(
                content = {
                    NavHost(navController = navController, startDestination = RouteConfig.ROUTE_PAGETWO) {
//                        composable(RouteConfig.ROUTE_PAGEONE) {
//                            loginPage(navController)
//                        }
                        composable(RouteConfig.ROUTE_PAGETWO) {
                            if(mainViewModeluistate.token != ""){
                                dataPage(navController,
                                    bloodOxygen = mainViewModelhealeth.bloodOxygen,
                                    HeartRate = mainViewModelhealeth.HeartRate,
                                    Hum = mainViewModelhealeth.Hum,
                                    Tem = mainViewModelhealeth.Tem,
                                    LightIntensity = mainViewModelhealeth.LightIntensity)
                            }else{
                                Text(text = "请登录后查看",
                                    fontSize = 45.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .fillMaxWidth())
                            }
                        }
                        composable(RouteConfig.ROUTE_PAGETHREE) {
                            if(mainViewModeluistate.token != ""){
                                userPage(navController)
                            }
                            else{
                                loginPage(modifier = modifier,
                                    navController,
                                    mainViewmodel(),
                                    useremail = mainViewModeluistate.useremail,
                                    password = mainViewModeluistate.password,
                                    onEmailValueChanged = {viewmodel.changeUserData(useremail = it)},
                                    onPasswordValueChanged = {viewmodel.changeUserData(password = it)},
                                    Login = {viewmodel.login();navController.popBackStack(RouteConfig.ROUTE_PAGETHREE, false);
                                        navController.navigate(RouteConfig.ROUTE_PAGETHREE);println("token"+mainViewModeluistate.token)
                                    }
                                )
                            }
                        }
                        composable(RouteConfig.ROUTE_PAGEFOUR) {
                            registerPage(modifier = modifier,
                                navController,
                                mainViewmodel(),
                                useremail = mainViewModeluistate.useremail,
                                password = mainViewModeluistate.password,
                                onEmailValueChanged = {viewmodel.changeUserData(useremail = it)},
                                onPasswordValueChanged = {viewmodel.changeUserData(password = it)},
                                Register = {viewmodel.register();navController.popBackStack(RouteConfig.ROUTE_PAGETHREE, false);
                                    navController.navigate(RouteConfig.ROUTE_PAGETHREE);println("token"+mainViewModeluistate.token)
                                })
                        }
                    }
                },
                bottomBar = {
                    BottomAppBar {
                        Row() {
//                            IconButton(modifier = Modifier.weight(1f),onClick = {
////                                navController.navigate(RouteConfig.ROUTE_PAGEONE)
//                            }){
//                                Icon(Icons.Default.Settings,contentDescription = null)
//                            }
                            IconButton(modifier = Modifier.weight(1f),onClick = {
                                navController.navigate(RouteConfig.ROUTE_PAGETWO)
                            }){
                                Icon(Icons.Default.Star,contentDescription = null)
                            }
                            IconButton(modifier = Modifier.weight(1f),onClick = {
                                navController.navigate(RouteConfig.ROUTE_PAGETHREE)
                            }){
                                Icon(Icons.Default.AccountBox,contentDescription = null)
                            }
                        }

                    }
                }
            )
        }
    }


}
