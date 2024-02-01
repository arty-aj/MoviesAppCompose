package com.example.moviesappcompose.viewmodels

import android.util.Log
import androidx.compose.ui.res.booleanResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesappcompose.models.response.AllMoviesData
import com.example.moviesappcompose.models.response.Dates
import com.example.moviesappcompose.models.response.Results
import com.example.moviesappcompose.utils.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class MoviesViewModel : ViewModel(){
    private val _movies : MutableStateFlow<List<Results>> = MutableStateFlow(listOf<Results>())
    val movies : StateFlow<List<Results>> = _movies.asStateFlow()

    init {
        dataRetrieval()
    }

    private fun dataRetrieval(){
        viewModelScope.launch {
            val response = try {
                RetrofitInstance.api.getMovies()
            }catch (e: IOException){
                Log.e("IO", "IOException: ${e.message}")
                return@launch
            }catch (e: HttpException){
                Log.e("HTTP", "HTTP Exception: ${e.message}")
                return@launch
            }
            if (response.isSuccessful && response.body() != null){
                updateMovies(response.body()!!.results)
            }
        }
    }

    private fun updateMovies(body: List<Results>) {
        _movies.update {
            body
        }
    }

}