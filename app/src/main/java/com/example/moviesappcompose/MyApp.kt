package com.example.moviesappcompose


import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.moviesappcompose.models.Screen
import com.example.moviesappcompose.models.response.Results
import com.example.moviesappcompose.views.MovieDetails
import com.example.moviesappcompose.views.MovieView

@Composable
fun MyApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route ){
        composable(route = Screen.MainScreen.route){
            MovieView(navController = navController)
        }
        composable(
            route=Screen.MovieDetailScreen.route + "?img={img}&title={title}&desc={desc}&rating={rating}",
            arguments = listOf(
                navArgument("img"){
                    type = NavType.StringType
                },
                navArgument("title"){
                    type = NavType.StringType
                },
                navArgument("desc"){
                    type = NavType.StringType
                },
                navArgument("rating"){
                    type = NavType.IntType
                }
//                navArgument("icon"){
//                    type = NavType.BoolType
//                }
            )
        ){ entry ->
            MovieDetails(
                imageLink = entry.arguments?.getString("img"),
                title = entry.arguments?.getString("title"),
                desc = entry.arguments?.getString("desc"),
                rating = entry.arguments?.getInt("rating")
//                iconFilled = entry.arguments?.getBoolean("icon")
            )
        }
    }
}