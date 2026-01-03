package com.davidmerchan.navigation3demo.mediumNavigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.davidmerchan.navigation3demo.basicNavigation.Detail
import com.davidmerchan.navigation3demo.screens.DetailScreen
import com.davidmerchan.navigation3demo.screens.ErrorScreen
import com.davidmerchan.navigation3demo.screens.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
data object HomeMedium : NavKey

@Serializable
data class DetailMedium(val id: String) : NavKey

@Serializable
data object ErrorMedium : NavKey

@Composable
fun MediumNavigationWrapper(modifier: Modifier = Modifier) {

    val backStack = rememberNavBackStack(HomeMedium)

    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        onBack = {
            backStack.removeLastOrNull()
        },
        entryProvider = { key ->
            when (key) {
                is HomeMedium -> NavEntry(key) {
                    HomeScreen { id ->
                        backStack.add(DetailMedium(id))
                    }
                }

                is DetailMedium -> NavEntry(key) {
                    DetailScreen(id = key.id) {
                        backStack.removeLastOrNull()
                    }
                }

                else -> NavEntry(key = ErrorMedium) {
                    ErrorScreen()
                }
            }
        }
    )
}
