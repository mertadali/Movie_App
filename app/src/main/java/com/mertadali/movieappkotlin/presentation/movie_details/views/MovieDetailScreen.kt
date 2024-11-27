package com.mertadali.movieappkotlin.presentation.movie_details.views

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.mertadali.movieappkotlin.presentation.movie_details.MoviesDetailViewModel

@Composable
fun MovieDetailScreen(moviesDetailViewModel: MoviesDetailViewModel = hiltViewModel(), onBackPressed : () -> Unit){
    
    val state = moviesDetailViewModel.state.value

    // Handle back button
    BackHandler {
        onBackPressed()
    }


    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black), contentAlignment = Alignment.Center){
        state.oneMovie?.let {
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = rememberAsyncImagePainter(model = it.Poster),
                    contentDescription = it.Title,
                    modifier = Modifier
                        .padding(14.dp)
                        .size(300.dp, 300.dp)
                        .clip(shape = RectangleShape)
                        .align(Alignment.CenterHorizontally))
                
                Text(text ="Title : ${it.Title} ", textAlign = TextAlign.Center, modifier = Modifier.padding(13.dp), color = Color.White)
                Text(text ="Year : ${it.Year} ", textAlign = TextAlign.Center, modifier = Modifier.padding(13.dp), color = Color.White)
                Text(text ="Actors : ${it.Actors} ", textAlign = TextAlign.Center, modifier = Modifier.padding(13.dp), color = Color.White)
                Text(text ="Country : ${it.Country} ", textAlign = TextAlign.Center, modifier = Modifier.padding(13.dp), color = Color.White)
                Text(text ="Director : ${it.Director} ", textAlign = TextAlign.Center, modifier = Modifier.padding(13.dp), color = Color.White)
                Text(text ="Imdb rating : ${it.imdbRating} ", textAlign = TextAlign.Center, modifier = Modifier.padding(13.dp), color = Color.White)

            }
        }

        if (state.errorDetail.isNotBlank()){
            Text(
                text = state.errorDetail,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.Center)
                    .padding(15.dp))
        }

        if(state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(alignment = Alignment.Center))
        }

    }


}