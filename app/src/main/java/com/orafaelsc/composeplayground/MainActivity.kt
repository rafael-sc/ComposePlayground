package com.orafaelsc.composeplayground

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.orafaelsc.composeplayground.navigation.RootNavigationGraph
import com.orafaelsc.composeplayground.ui.theme.ComposePlaygroundTheme
import com.orafaelsc.composeplayground.ui.view.LoadingView
import com.orafaelsc.composeplayground.ui.viewmodel.ObserveStateViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComplexNavigationGraph()
//            ComposePlaygroundTheme {
//                val scaffoldState = rememberScaffoldState()
//                Scaffold(
//                    scaffoldState = scaffoldState,
//                    topBar = {
//                        TopAppBar(
//                            title = { Text("home") },
//                            backgroundColor = MaterialTheme.colorScheme.onSecondary
//
//                        )
//                    },
//                    content = { HomeScreen(context = this) },
//                    drawerContent = { Text("Config") },
//                    bottomBar = {
//                        BottomAppBar() {
//                            Text("navigation bar")
//                        }
//                    }
//                )
//            }
        }
    }


    @Composable
    private fun ComplexNavigationGraph(){
        ComposePlaygroundTheme {
            RootNavigationGraph(navController = rememberNavController())
        }
    }

    @Composable
    private fun HomeScreen(context: Context) {
        LoadingView(viewModel = ObserveStateViewModel())
//        WelcomeView(context = context)
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            Greeting(name = "Playground")
//            HomeTextButton { Toast.makeText(context, "Toasted", Toast.LENGTH_SHORT).show() }
//        }
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
