package com.davidmerchan.navigation3demo.hiltNavigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class HiltRoutes : NavKey {
    @Serializable
    data object Home : HiltRoutes()

    @Serializable
    data class Detail(val id: String) : HiltRoutes()

    @Serializable
    data object Error : HiltRoutes()
}
