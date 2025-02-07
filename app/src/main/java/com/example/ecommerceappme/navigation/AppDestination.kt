package com.example.ecommerceappme.navigation

import androidx.compose.runtime.saveable.Saver
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

val AppDestinationSaver = Saver<AppDestination, String>(
    save = { destination -> Json.encodeToString(AppDestination.serializer(), destination) },
    restore = { json -> Json.decodeFromString(AppDestination.serializer(), json) }
)


@Serializable
sealed interface AppDestination {

    @Serializable
    data object Splash : AppDestination

    @Serializable
    data object Login : AppDestination

    @Serializable
    data object SignUp : AppDestination

    @Serializable
    data object Home : AppDestination

    @Serializable
    data object Categories : AppDestination

    @Serializable
    data object WishList : AppDestination

    @Serializable
    data object Profile : AppDestination

    @Serializable
    data object Cart : AppDestination
}