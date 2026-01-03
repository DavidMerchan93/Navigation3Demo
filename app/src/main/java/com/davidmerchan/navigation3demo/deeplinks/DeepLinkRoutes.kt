package com.davidmerchan.navigation3demo.deeplinks

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class DeepLinkRoute : NavKey {
    @Serializable
    data object Home : DeepLinkRoute()

    @Serializable
    data class Detail(val id: String) : DeepLinkRoute()

    @Serializable
    data object Error : DeepLinkRoute()
}
