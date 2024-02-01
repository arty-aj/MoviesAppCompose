package com.example.moviesappcompose.models

//Specify single screens
//Sealed Class only allows classes inside of screen class to inherit from Screen
sealed class Screen (val route: String){
    object MainScreen: Screen("main_screen")
    object MovieDetailScreen: Screen("movie_detail_screen")
}