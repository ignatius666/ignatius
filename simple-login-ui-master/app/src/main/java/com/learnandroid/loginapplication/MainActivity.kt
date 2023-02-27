package com.learnandroid.loginapplication

import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.learnandroid.loginapplication.composables.*
import com.learnandroid.loginapplication.ui.theme.LoginApplicationTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        setContent {
            LoginApplicationTheme {
                LoginApplication(this)
            }
        }
    }

    @Composable
    fun LoginApplication(context: Context){
        val navController = rememberNavController()

        var SAFE_NAME = remember { mutableStateOf("") }
        var SAFE_EMAIL = remember { mutableStateOf("") }
        var SAFE_PHONE = remember { mutableStateOf("") }
        var SAFE_PASSWORD = remember { mutableStateOf("") }

        NavHost(navController = navController, startDestination = "login_page", builder = {
            composable("login_page", content = { LoginPage(navController = navController, context = context, name = SAFE_NAME, email = SAFE_EMAIL, phone = SAFE_PHONE, password = SAFE_PASSWORD) })
            composable("register_page", content = { RegisterPage(navController = navController, context = context, name = SAFE_NAME, email = SAFE_EMAIL, phone = SAFE_PHONE, password = SAFE_PASSWORD) })
            composable("home_page", content = { HomePage(navController = navController, context = context) })
            composable("notification_page", content = { NotificationPage(navController = navController, context = context) })
            composable("profile_page", content = { ProfilePage(navController = navController, context = context, name = SAFE_NAME, email = SAFE_EMAIL) })
        })
    }
}

