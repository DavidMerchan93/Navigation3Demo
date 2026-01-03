package com.davidmerchan.navigation3demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.davidmerchan.navigation3demo.mediumNavigation.MediumNavigationWrapper
import com.davidmerchan.navigation3demo.ui.theme.Navigation3DemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigation3DemoTheme {
                MediumNavigationWrapper()
            }
        }
    }
}
