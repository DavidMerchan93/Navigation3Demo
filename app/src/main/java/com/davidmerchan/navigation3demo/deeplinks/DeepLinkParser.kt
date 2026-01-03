package com.davidmerchan.navigation3demo.deeplinks

import android.content.Intent
import android.net.Uri

// Parses deeplinks like: navigation3demo://app/home or /detail/{id}.
object DeepLinkParser {
    fun fromIntent(intent: Intent?): DeepLinkRoute? = fromUri(intent?.data)

    fun fromUri(uri: Uri?): DeepLinkRoute? {
        if (uri == null) return null

        val first = uri.pathSegments.firstOrNull() ?: return DeepLinkRoute.Home

        return when (first.lowercase()) {
            "home" -> DeepLinkRoute.Home
            "detail" -> uri.pathSegments.getOrNull(1)?.let { DeepLinkRoute.Detail(it) }
            "error" -> DeepLinkRoute.Error
            else -> null
        }
    }
}
