package com.davidmerchan.navigation3demo.advanceNavigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.davidmerchan.navigation3demo.screens.DetailScreen
import com.davidmerchan.navigation3demo.screens.ErrorScreen
import com.davidmerchan.navigation3demo.screens.HomeScreen
import com.davidmerchan.navigation3demo.utils.back
import com.davidmerchan.navigation3demo.utils.navigateTo

@Composable
fun AdvanceNavigationWrapper(modifier: Modifier = Modifier) {
    val backStack = rememberNavBackStack(Routes.Home)

    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        onBack = {
            backStack.back()
        },
        entryProvider = entryProvider {

            entry<Routes.Home> {
                HomeScreen { id ->
                    backStack.navigateTo(Routes.Detail(id))
                }
            }

            entry<Routes.Detail> { key ->
                DetailScreen(id = key.id) {
                    backStack.back()
                }
            }

            entry<Routes.Error> {
                ErrorScreen()
            }
        }
    )
}