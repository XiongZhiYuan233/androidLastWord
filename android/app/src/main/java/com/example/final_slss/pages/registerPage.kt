package com.example.final_slss.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.final_slss.R
import com.example.final_slss.config.RouteConfig
import com.example.final_slss.viewmodel.mainViewmodel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun registerPage(modifier:Modifier = Modifier,
                 navController: NavController,
                 viewmodel: mainViewmodel,
                 useremail: String,
                 password:String,
                 onEmailValueChanged: (String) -> Unit,
                 onPasswordValueChanged: (String) -> Unit,
                 Register:()->Unit
){
    Column (verticalArrangement = Arrangement.spacedBy(24.dp)){
        Text(text = "Register",
            fontSize = 45.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally))
        OutlinedTextField(
            value =  useremail,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colorScheme.surface),
            onValueChange = onEmailValueChanged,
            label = { Text(stringResource(R.string.enter_your_email)) },
            isError = false,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { println("完成")}
            )
        )
        OutlinedTextField(
            value = password,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colorScheme.surface),
            onValueChange = onPasswordValueChanged,
            label = { Text(stringResource(R.string.enter_your_password)) },
            isError = false,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { }
            )
        )
        Button(onClick = Register,
            Modifier.padding(start = 150.dp)
        ) {
            Text(text = "Register")
        }
    }
}