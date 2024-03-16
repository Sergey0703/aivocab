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
import androidx.compose.material.icons.filled.Favorite
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.serhiibaliasnyi.aivocab.ui.theme.AIVocabTheme


enum class Tab(
    val label: String,
    val icon: ImageVector,
){
    Items("Items", Icons.Default.List),
    Settings("Settings", Icons.Default.Settings),
    Favourite("Profile", Icons.Default.Favorite),
}
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

var currentTab: Tab by remember{
    mutableStateOf(Tab.Items)

}

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text=currentTab.label, fontSize = 30.sp) },
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
                Tab.values().forEach {tab->
                    NavigationBarItem(
                        selected = tab==currentTab,
                        onClick = { currentTab=tab },
                        label= {Text(text=tab.label)},
                        icon = {Icon(imageVector = tab.icon,
                            contentDescription = null
                            )

                         })

                }
            }

                    },
        snackbarHost = {}

    ){paddingValues ->
        Box(contentAlignment = Alignment.Center,
                 modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            TabScreen(tab = currentTab )
        }
        /*Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Text(
                text = "Main",
                fontSize = 30.sp
            )
        }
        */

    }

}

@Composable
fun ItemsScreen(){
    //Box(contentAlignment = Alignment.Center){
       Text(text="Items screen", fontSize = 28.sp)
    //}
}
@Composable
fun SettingsScreen(){
   // Box(contentAlignment = Alignment.Center){
        Text(text="Settings screen", fontSize = 28.sp)
   // }
}
@Composable
fun ProfileScreen(){
    //Box(contentAlignment = Alignment.Center){
        Text(text="Profile screen", fontSize = 28.sp)
   // }
}
@Composable
fun TabScreen(tab:Tab){
    when(tab){
        Tab.Items-> ItemsScreen()
        Tab.Settings-> SettingsScreen()
        Tab.Favourite-> ProfileScreen()
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