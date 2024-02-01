package com.example.moviesappcompose.models.response

data class AllMoviesData(
    val dates: Dates,
    val page: Int=0,
    val results: List<Results> =listOf(),
    val total_pages: Int = 0,
    val total_results: Int = 0
)