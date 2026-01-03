package com.davidmerchan.navigation3demo.hiltNavigation

import android.content.Intent
import android.net.Uri

// Parses deeplinks like: navigation3demo://app/home or /detail/{id}.
object HiltDeepLinkParser {
    fun fromIntent(intent: Intent?): HiltRoutes? = fromUri(intent?.data)

    fun fromUri(uri: Uri?): HiltRoutes? {
        if (uri == null) return null

        val first = uri.pathSegments.firstOrNull() ?: return HiltRoutes.Home

        return when (first.lowercase()) {
            "home" -> HiltRoutes.Home
            "detail" -> uri.pathSegments.getOrNull(1)?.let { HiltRoutes.Detail(it) }
            "error" -> HiltRoutes.Error
            else -> null
        }
    }
}
