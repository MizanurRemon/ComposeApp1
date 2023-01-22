package com.example.composeapp1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp1.ui.theme.ComposeApp1Theme

class MainActivity : ComponentActivity() {
    val paddingValues = PaddingValues(all = 16.dp)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApp1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    surfaceUI()
                }
            }
        }
    }
}

@Composable
fun surfaceUI() {
    val context = LocalContext.current
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                backgroundColor = Color.Cyan,
                title = {
                    Text("Demo", color = Color.Black, fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    IconButton(onClick = {
                        testClick("menu", context)
                    }) {
                        Icon(Icons.Filled.Menu, contentDescription = "menu", tint = Color.Black)
                    }
                },
                actions = {
                    IconButton(onClick = {
                        testClick("notification", context)

                    }) {
                        Icon(
                            Icons.Filled.Notifications,
                            contentDescription = "notification",
                            tint = Color.Black
                        )
                    }
                    IconButton(onClick = {
                        testClick("search", context)
                    }) {
                        Icon(Icons.Filled.Search, contentDescription = "search", tint = Color.Black)
                    }

                    showSwitch()

                })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {}, backgroundColor = Color.Cyan, modifier = Modifier.padding(all = 10.dp)
            ) {

                Icon(Icons.Filled.Add, contentDescription = "floating Add")
            }
        }, floatingActionButtonPosition = FabPosition.End
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = { context.startActivity(Intent(context, ProductActivity::class.java)) }) {
                Text(text = "Click")
            }

        }
    }
}

@Composable
fun showSwitch() {
    val context = LocalContext.current

    val isChecked = remember {
        mutableStateOf(false)
    }
    Switch(checked = isChecked.value, onCheckedChange = {
        isChecked.value = it

        if (isChecked.value) {
            testClick("ON", context)
        } else {
            testClick("OFF", context)
        }
    }, modifier = Modifier.run {
        size(20.dp)
        padding(5.dp)
    })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeApp1Theme {
        surfaceUI()
    }
}


fun testClick(text: String, context: Context) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}