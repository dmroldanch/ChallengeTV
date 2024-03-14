package com.tvmaze.challenge.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tvmaze.challenge.presentation.characters.CharactersView
import com.tvmaze.challenge.presentation.detail.DetailView
import com.tvmaze.challenge.presentation.episodes.EpisodesView
import com.tvmaze.challenge.presentation.home.HomeView


@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationScreen.HomeView.route,
    ) {
        composable(NavigationScreen.HomeView.route) {

            HomeView(
                    navigateToCharacters = {navController.navigate(NavigationScreen.Character.route)},
                    navigateToEpisodes = {navController.navigate(NavigationScreen.Episodes.route)},
            )
        }

        composable(NavigationScreen.Episodes.route ) { backStackEntry ->
            EpisodesView(onItemClick = {})
       }

        composable(NavigationScreen.Character.route) { backStackEntry ->
            CharactersView(onItemClick = {})
        }
    }
}

sealed class NavigationScreen(val route: String) {
    object HomeView : NavigationScreen("home")
    object Character : NavigationScreen("character")

    object Episodes : NavigationScreen("episodes")
}
