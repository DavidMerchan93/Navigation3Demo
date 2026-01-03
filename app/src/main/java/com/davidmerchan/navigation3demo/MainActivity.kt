package com.davidmerchan.navigation3demo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateOf
import com.davidmerchan.navigation3demo.hiltNavigation.HiltDeepLinkParser
import com.davidmerchan.navigation3demo.hiltNavigation.HiltNavigationWrapper
import com.davidmerchan.navigation3demo.hiltNavigation.HiltRoutes
import com.davidmerchan.navigation3demo.ui.theme.Navigation3DemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    // Holds a route parsed from a new deeplink intent while the app is running.
    private val pendingRoute = mutableStateOf<HiltRoutes?>(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Use the launch intent to decide the first screen to show.
        val initialRoute = HiltDeepLinkParser.fromIntent(intent) ?: HiltRoutes.Home

        setContent {
            Navigation3DemoTheme {
                HiltNavigationWrapper(
                    initialRoute = initialRoute,
                    pendingRoute = pendingRoute.value,
                )
            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        // Route the new deeplink without recreating the Activity.
        pendingRoute.value = HiltDeepLinkParser.fromIntent(intent)
    }
}
