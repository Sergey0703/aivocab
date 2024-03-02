package com.serhiibaliasnyi.aivocab

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.serhiibaliasnyi.aivocab.ui.theme.AIVocabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AIVocabTheme(useDarkTheme = true) {
                AppScreen()
            }
        }
    }
}
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
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
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text="TopBar", fontSize = 30.sp) },
                colors=TopAppBarDefaults.largeTopAppBarColors(
                    containerColor =MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor =MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Menu,
                            contentDescription = "Main menu")
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Settings,
                            contentDescription = "Settings")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.MoreVert,
                            contentDescription = "More menu")
                    }
                }


            )
            },

        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Add,
                    contentDescription = "More menu")
            }
            },
        floatingActionButtonPosition = FabPosition.End,
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected =true ,
                    label ={ Text(text="List")},
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(imageVector = Icons.Default.List,
                            contentDescription = "List")
                     })
                NavigationBarItem(
                    selected =false ,
                    label ={ Text(text="Settings")},
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(imageVector = Icons.Default.Settings,
                            contentDescription = "Settings")
                    })
                NavigationBarItem(
                    selected =false ,
                    label ={ Text(text="Favorite")},
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "Favorite")
                    })
            }

                    },
        snackbarHost = {}

    ){paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Text(
                text = "Main",
                fontSize = 30.sp
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