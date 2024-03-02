package com.serhiibaliasnyi.aivocab

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.serhiibaliasnyi.aivocab.ui.theme.AIVocabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AIVocabTheme {
                AppScreen()
            }
        }
    }
}
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showSystemUi = true)
@Composable
fun AppScreen() {
//    Scaffold() {//paddingValues ->
//        Text(
//            text = "Hello !"
//
//        )
//    }
    Scaffold(
        topBar = {Text(text="TopBar")},
        bottomBar = {Text(text="BottomBar")}

    ){paddingValues ->
        Box(
            modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
        ) {
            Text(
                text = "Main"
            )
        }
    }

}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AIVocabTheme {
        Greeting("Android")
    }
}