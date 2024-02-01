package com.example.moviesappcompose.models.data

import com.example.moviesappcompose.models.response.AllMoviesData
import com.example.moviesappcompose.utils.Utils
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/3/movie/now_playing${Utils.key}")
    suspend fun getMovies() : Response<AllMoviesData>
}