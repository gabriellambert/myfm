package com.gapps.myfm.search

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gapps.myfm.search.compose.PlayerDetailsScreen
import com.gapps.myfm.search.compose.SearchScreen
import com.gapps.myfm.search.navigation.PlayerDetails
import com.gapps.myfm.search.navigation.SearchHome

@Composable
fun SearchScreenModuleNav() {
    val navController = rememberNavController()
    SearchScreenModuleNavHost(navController = navController)
}

@Composable
fun SearchScreenModuleNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = SearchHome.route,
    ) {
        composable(route = SearchHome.route) {
            SearchScreen(navController)
        }
        composable(route = PlayerDetails.route) {
            PlayerDetailsScreen(navController)
        }
    }
}
