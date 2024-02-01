package com.example.moviesappcompose.views

import RatingBar
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.moviesappcompose.R

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MovieDetails(
    modifier: Modifier = Modifier,
    imageLink: String?,
    title: String?,
    desc: String?,
    rating: Int?,
//    iconFilled: Boolean?
){
    val scrollState = rememberScrollState()
    BoxWithConstraints (
        //modifier.fillMaxSize().border(2.dp, Color.Black)
    ){
        val pageSize = this.maxHeight
        Box (
            modifier
                .fillMaxSize()
                //.border(2.dp, Color.Green)
        ) {
            Column(
                modifier = Modifier
                    //.padding(5.dp)
                    .fillMaxWidth()
                    //.border(2.dp, Color.Red)
                    .height(this@BoxWithConstraints.maxHeight)
                    .verticalScroll(scrollState)
            ) {
                AsyncImage(
                    model = imageLink!!,
                    contentDescription = "",
                    modifier
                        .fillMaxWidth()
                        .height(589.dp)
                )
                Row (
                    modifier
                        .padding(top = 10.dp, bottom = 10.dp)
                ){
                    Text(
                        text = title!!,
                        modifier
                            .weight(1f),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Icon(
                        Icons.Outlined.FavoriteBorder,
                        contentDescription = "Favorites",
                        modifier
                            .padding(end = 10.dp)
                            .size(28.dp)
                            .clickable { /* TODO */},
                    )
                }
                RatingBar(
                    rating = rating!!.toDouble()
                )
                Text(
                    text = desc!!,
                    modifier
                        .padding(10.dp)
                )
            }
        }
    }
}
