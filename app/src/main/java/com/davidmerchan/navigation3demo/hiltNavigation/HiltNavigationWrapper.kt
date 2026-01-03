package com.davidmerchan.navigation3demo.hiltNavigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.davidmerchan.navigation3demo.screens.ErrorScreen
import com.davidmerchan.navigation3demo.utils.back
import com.davidmerchan.navigation3demo.utils.navigateTo

@Composable
fun HiltNavigationWrapper(
    initialRoute: HiltRoutes = HiltRoutes.Home,
    pendingRoute: HiltRoutes? = null,
    modifier: Modifier = Modifier,
) {
    val backStack = rememberNavBackStack(initialRoute)

    // Navigate when a new deeplink arrives while the app is in the foreground.
    LaunchedEffect(pendingRoute) {
        pendingRoute?.let { backStack.navigateTo(it) }
    }

    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        onBack = { backStack.back() },
        entryProvider = entryProvider {
            entry<HiltRoutes.Home> {
                HiltHomeScreen { id ->
                    backStack.navigateTo(HiltRoutes.Detail(id))
                }
            }

            entry<HiltRoutes.Detail> { key ->
                HiltDetailScreen(id = key.id) {
                    backStack.back()
                }
            }

            entry<HiltRoutes.Error> {
                ErrorScreen()
            }
        }
    )
}
