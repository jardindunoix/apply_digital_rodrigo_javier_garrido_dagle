package cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.utilities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavDestination.Companion.createRoute

@SuppressLint("RestrictedApi")
fun NavController.navigateTo(
    route: String,
    args: Bundle,
) {
    val routeLink = NavDeepLinkRequest
        .Builder
        .fromUri(createRoute(route).toUri())
        .build()

    val deepLinkMatch = graph.matchDeepLink(routeLink)
    if (deepLinkMatch != null) {
        val destination = deepLinkMatch.destination
        val id = destination.id
        navigate(id, args)
    } else {
        navigate(route)
    }
}