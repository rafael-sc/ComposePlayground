package com.orafaelsc.composeplayground

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.orafaelsc.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                val scaffoldState =
                    rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = { TopAppBar(title = { Text("home") }) },
                    content = { HomeScreen(context = this) },
                    drawerContent = { Text("Config") },
                    bottomBar = {
                        BottomAppBar() {
                            Text("navigation bar")
                        }
                    }
                )
            }
        }
    }

    @Composable
    private fun HomeScreen(context: Context) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Greeting(name = "Playground")
            HomeTextButton { Toast.makeText(context, "Toasted", Toast.LENGTH_SHORT).show() }
        }
    }


    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }

    @Composable
    fun HomeTextButton(onclick: () -> Unit) {
        Button(onClick = onclick) {
            Text(text = "Click to toast")
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposePlaygroundTheme {
            Greeting("Android")
        }
    }
}
