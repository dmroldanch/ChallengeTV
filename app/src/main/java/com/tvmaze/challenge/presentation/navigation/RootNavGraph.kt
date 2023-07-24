package com.tvmaze.challenge.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tvmaze.challenge.presentation.detail.DetailView
import com.tvmaze.challenge.presentation.home.HomeView


@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationScreen.HomeView.route,
    ) {
        composable(NavigationScreen.HomeView.route) {
            HomeView() { id ->
                    navController.navigate(NavigationScreen.DetailView.route + "/$id")
                }
        }

        composable(NavigationScreen.DetailView.route + "/{id}") { backStackEntry ->

            DetailView(backStackEntry.arguments?.getString("id")?.toInt() ?: 0 )
        }
    }
}

sealed class NavigationScreen(val route: String) {
    object HomeView : NavigationScreen("home")
    object DetailView : NavigationScreen("detail")
}
