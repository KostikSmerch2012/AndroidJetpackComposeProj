package com.example.moyakuhnya

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.feature.home.MainScreen
import com.example.feature.screens.theme.MoyaKuhnyaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoyaKuhnyaTheme(dynamicColor = false) {
                MainScreen()
            }
        }
    }
}
