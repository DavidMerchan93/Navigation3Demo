package com.davidmerchan.navigation3demo

import android.app.ComponentCaller
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateOf
import com.davidmerchan.navigation3demo.deeplinks.DeepLinkNavigationWrapper
import com.davidmerchan.navigation3demo.deeplinks.DeepLinkParser
import com.davidmerchan.navigation3demo.deeplinks.DeepLinkRoute
import com.davidmerchan.navigation3demo.ui.theme.Navigation3DemoTheme

class MainActivity : ComponentActivity() {
    // Holds a route parsed from a new deeplink intent while the app is running.
    private val pendingRoute = mutableStateOf<DeepLinkRoute?>(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Use the launch intent to decide the first screen to show.
        val initialRoute = DeepLinkParser.fromIntent(intent) ?: DeepLinkRoute.Home

        setContent {
            Navigation3DemoTheme {
                DeepLinkNavigationWrapper(
                    initialRoute = initialRoute,
                    pendingRoute = pendingRoute.value,
                )
            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        // Route the new deeplink without recreating the Activity.
        pendingRoute.value = DeepLinkParser.fromIntent(intent)
    }
}
