package com.davidmerchan.navigation3demo.basicNavigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.davidmerchan.navigation3demo.screens.DetailScreen
import com.davidmerchan.navigation3demo.screens.ErrorScreen
import com.davidmerchan.navigation3demo.screens.HomeScreen

data object Home
data class Detail(val id: String)

@Composable
fun BasicNavigationWrapper(modifier: Modifier = Modifier) {
    val backStack = remember { mutableStateListOf<Any>(Home) }

    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        onBack = {
            backStack.removeLastOrNull()
        },
        entryProvider = { key ->
            when (key) {
                is Home -> NavEntry(key) {
                    HomeScreen { id ->
                        backStack.add(Detail(id))
                    }
                }

                is Detail -> NavEntry(key) {
                    DetailScreen(id = key.id) {
                        backStack.removeLastOrNull()
                    }
                }

                else -> NavEntry(key = Unit) {
                    ErrorScreen()
                }
            }
        }
    )
}
