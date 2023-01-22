package com.example.composeapp1

import android.os.Bundle
import android.text.Layout.Alignment
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp1.ui.theme.ComposeApp1Theme
import com.example.composeapp1.utils.User
import com.example.composeapp1.utils.dummyData

class ProductActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApp1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    productPageUI()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview2() {
        ComposeApp1Theme {
            productPageUI()
            //RecyclerView(datas = dummyData())
        }
    }


    @Composable
    fun RecyclerView(datas: List<User>) {
        LazyColumn() {
            item(datas) {
                for (i in 0..datas.size - 1) {
                    eachRow(user = datas[i])
                }
            }
        }
    }


    @Composable
    fun eachRow(user: User) {
        Card(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(
                CornerSize(8.dp)
            ),
            elevation = 2.dp
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = androidx.compose.ui.Alignment.Companion.CenterVertically
            ) {

                Image(

                    painter = painterResource(id = R.drawable.testimage),
                    contentDescription = "image",
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(80.dp, 80.dp),
                    contentScale = ContentScale.Crop,

                    )
                Text(
                    text = user.description,
                    color = Color.Black,
                    modifier = Modifier.padding(all = 10.dp),
                    textAlign = TextAlign.Justify,
                )


            }
        }
    }

    @Composable
    fun productPageUI() {
        val context = LocalContext.current
        Scaffold(
            topBar = {
                TopAppBar(

                    backgroundColor = Color.Cyan,
                    title = {
                        Text("Products", color = Color.Black, fontWeight = FontWeight.Bold)
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            //testClick("menu", context)
                            

                        }) {
                            Icon(
                                Icons.Filled.ArrowBack,
                                contentDescription = "back",
                                tint = Color.Black
                            )
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
                            Icon(
                                Icons.Filled.Search,
                                contentDescription = "search",
                                tint = Color.Black
                            )
                        }

                        showSwitch()


                    })
            },
        ) {
            RecyclerView(datas = dummyData())

        }
    }


}




