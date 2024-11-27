package com.mertadali.movieappkotlin.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.mertadali.movieappkotlin.domain.model.Movie

@Composable
fun MovieListRow( movie: Movie, onItemClick : (Movie) -> Unit){

    Row(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .clickable {
            onItemClick(movie)
        }) {
        
        Image(
            painter = rememberAsyncImagePainter(model = movie.Poster),
            contentDescription = movie.Title,
            modifier = Modifier
                .padding(10.dp)
                .size(200.dp, 200.dp)
                .clip(shape = RectangleShape))

        Column(modifier = Modifier.align(alignment = Alignment.CenterVertically), horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text = movie.Title,
                style = MaterialTheme.typography.bodyLarge,
                overflow = TextOverflow.Ellipsis,
                color = Color.White)
            
            Spacer(modifier = Modifier.padding(2.dp))

            Text(text = movie.Year,
                style = MaterialTheme.typography.bodyMedium,
                overflow = TextOverflow.Ellipsis,
                color = Color.White)

        }

    }
}