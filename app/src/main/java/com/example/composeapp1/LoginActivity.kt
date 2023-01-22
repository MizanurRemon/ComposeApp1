package com.example.composeapp1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp1.ui.theme.ComposeApp1Theme

class LoginActivity : ComponentActivity() {

    var currentContext: Context = this@LoginActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApp1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreenUI()
                }
            }
        }
    }
}

@Composable
private fun LoginScreenUI() {

    val context: Context = LocalContext.current
    val userName = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,

        ) {
        Text(
            text = "Hello Again!",
            fontWeight = FontWeight.Bold,
            color = Color.Blue,
            fontSize = 20.sp,
            fontFamily = FontFamily.Monospace
        )
        Text(
            text = "Welcome",
            fontWeight = FontWeight.Bold,
            color = Color.Blue,
            fontSize = 20.sp,
            fontFamily = FontFamily.Monospace
        )

        OutlinedTextField(
            value = userName.value,
            label = {
                Text(text = "Username")
            },
            placeholder = {
                Text(text = "Enter username")
            },
            leadingIcon = {
                Icon(
                    Icons.Filled.Person,
                    contentDescription = "username"
                )
            }, onValueChange = {
                userName.value = it
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = password.value,
            label = {
                Text(text = "Password")
            },
            placeholder = {
                Text(text = "Enter password")
            },
            leadingIcon = {
                Icon(
                    Icons.Filled.Lock,
                    contentDescription = "password"
                )
            }, onValueChange = {
                password.value = it
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedButton(
            onClick = {
                logInFun(
                    username = userName.value,
                    password = password.value,
                    context = context
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Log In")
        }
    }

}


fun logInFun(username: String, password: String, context: Context) {
    if (username == "remon" && password == "123456") {
        ShowToast.successToast("login successful", context)
        context.startActivity(Intent(context, MainActivity::class.java))
    } else {
        Log.d("dataxx", "error")
        ShowToast.errorToast("invalid login credentials", context)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview1() {
    ComposeApp1Theme {
        LoginScreenUI()
    }
}