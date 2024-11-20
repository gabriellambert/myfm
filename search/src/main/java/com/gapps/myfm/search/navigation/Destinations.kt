package com.gapps.myfm.search.navigation

interface Destinations {
    val route: String
}

object SearchHome : Destinations {
    override val route = "search_home"
}

object PlayerDetails : Destinations {
    override val route = "player_details"
}
