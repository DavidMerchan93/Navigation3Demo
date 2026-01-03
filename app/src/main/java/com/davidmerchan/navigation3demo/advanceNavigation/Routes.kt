package com.davidmerchan.navigation3demo.advanceNavigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes : NavKey {
    @Serializable
    data object Home : Routes()

    @Serializable
    data class Detail(val id: String) : Routes()

    @Serializable
    data object Error : Routes()
}
