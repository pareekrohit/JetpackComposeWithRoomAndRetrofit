package com.example.loginregsitration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginregsitration.screen.ListScreen
import com.example.loginregsitration.screen.LoginScreen
import com.example.loginregsitration.screen.RegistrationScreen
import com.example.loginregsitration.screen.SplashScreen
import com.example.loginregsitration.ui.theme.LoginRegsitrationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            LoginRegsitrationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavigationScreen(navController)
                }
            }
        }
    }
}


@Composable
fun NavigationScreen(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            SplashScreen(navController)
        }
        composable("login") {
            LoginScreen(navController)
        }
        composable("registration") {
            RegistrationScreen(navController)
        }
        composable("listScreen") {
            ListScreen(navController)
        }
    }

}


@Preview(showBackground = true)
@Composable
fun Preview() {
    LoginRegsitrationTheme {
        Surface(modifier = Modifier.fillMaxHeight()) {
            LoginScreen(null)
        }

    }
}