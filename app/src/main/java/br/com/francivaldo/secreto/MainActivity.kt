package br.com.francivaldo.secreto

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.francivaldo.secreto.ui.layouts.*
import br.com.francivaldo.secreto.ui.theme.SecretoTheme

class MainActivity : ComponentActivity() {
    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var navController:NavHostController
        var topNav by mutableStateOf(EnumTopNavigate.Activities)
        var BottonNav by mutableStateOf(EnumBottomNavigate.suggestions)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecretoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Routes.Login){
                        composable(Routes.Login){ LayoutLogin()}
                        composable(Routes.Loginup){ LayoutLogup()}
                        composable(Routes.Home){ LayoutHome()}
                        composable(Routes.Chat){ LayoutChat()}
                    }
                }
            }
        }
    }
}
