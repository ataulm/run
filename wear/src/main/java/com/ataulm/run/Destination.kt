package com.ataulm.run

sealed interface Destination {
    val route: String
}

object Home : Destination {
    override val route = "home"
}

object Schedule : Destination {
    override val route = "schedule"
}

object Run : Destination {
    override val route = "run"
}

object Settings : Destination {
    override val route = "settings"
}
