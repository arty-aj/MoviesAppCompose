package com.example.moviesappcompose.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.moviesappcompose.R
import com.example.moviesappcompose.models.Screen
import com.example.moviesappcompose.viewmodels.MoviesViewModel
import java.net.URLEncoder
// Icons https://fonts.google.com/icons?selected=Material+Symbols+Outlined:favorite:FILL@1;wght@400;GRAD@0;opsz@24&icon.platform=web&icon.set=Material+Symbols
// Compose icons https://m2.material.io/design/iconography/system-icons.html#design-principles

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun MovieView(
    modifier: Modifier =  Modifier,
    navController: NavController
) {
    val viewModel: MoviesViewModel = viewModel()
    val movies by viewModel.movies.collectAsState()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(){
            // Sticky header
            stickyHeader {
                Row (
                    modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primary)
                ){
                    Text(
                        text = "Movies now playing in theaters",
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            //.background()
                            .padding(top = 16.dp, bottom = 16.dp)
                            .align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                    Icon(
                        Icons.Filled.Star,
                        contentDescription = "favorites",
                        modifier
                            .padding(top = 16.dp, bottom = 16.dp, end = 5.dp)
                    )
                }
            }
            items(movies){movie->
                Column(
                    modifier
                        .padding(10.dp)
                ){
                    Card(
                        modifier
                            .clickable{
                                navController.navigate(
                                    route = "${Screen.MovieDetailScreen.route}?" +
                                            "img=${URLEncoder.encode("https://image.tmdb.org/t/p/w342${movie.poster_path}", "UTF-8")}}'&" +
                                            "title=${movie.original_title}&" +
                                            "desc=${movie.overview}&" +
                                            "rating=${movie.vote_average.toInt()}"
                                )
                            }
                    ) {
                        Row (){
                            AsyncImage(
                                model = "https://image.tmdb.org/t/p/w342${movie.poster_path}",
                                contentDescription = movie.original_title,
                            )
                            Column (
                                modifier
                                    .weight(1f)
                            ){
                                Text(
                                    movie.original_title,
                                    modifier
                                        .padding(5.dp)
                                )
                                Text(
                                    text = movie.overview,
                                    modifier
                                        .padding(5.dp),
                                    maxLines = 4
                                )
                            }
                            Icon(
                                painterResource(R.drawable.ic_favorite_fill0_icon_24),
                                contentDescription = "",
                                modifier
                                    .padding(5.dp)
                                    .clickable { /*TODO*/ }
                            )
                        }
                    }
                }
            }
        }
    }
}


