package com.example.movieapp.Component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.movieapp.moviedata.Movie
import com.example.movieapp.moviedata.getMovies


//@Preview(showBackground = true)
@Composable
fun movieCard(movie :Movie = getMovies()[0], navController: NavController) {
   var showDetails by remember { mutableStateOf(false) }
    Card(modifier = Modifier.fillMaxWidth().padding(4.dp).clickable { navController.navigate("detail/${movie.id}") }) {
        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {

            Image(
                painter = rememberImagePainter(data = movie.poster, builder = {

                    crossfade(true)
                    transformations(CircleCropTransformation())
                })
                ,
                contentDescription = "Movie Poster",
                modifier = Modifier.size(100.dp)
            )
            MoreDetails(movie, showDetails)

        }
    }
}

@Composable
private fun MoreDetails(movie: Movie, showDetails: Boolean) {
    var showDetails1 = showDetails
    Column(modifier = Modifier.padding(4.dp)) {
        Text(text = movie.title, modifier = Modifier.padding(8.dp), fontWeight = FontWeight.Bold)
        Text(text = "Director: ${movie.director}", modifier = Modifier)
        Text(text = "Released: ${movie.year}", modifier = Modifier)
        AnimatedVisibility(showDetails1) {
            Column(modifier = Modifier.padding(4.dp)) {
                Divider()
                Text(text = "Plot: ${movie.plot}", modifier = Modifier)
                Text(text = "Genre: ${movie.genre}", modifier = Modifier)
                Text(text = "Actors: ${movie.actors}", modifier = Modifier)

            }
        }
        Icon(imageVector = if (!showDetails1) Icons.Default.ArrowDropDown
        else Icons.Default.KeyboardArrowUp,
            contentDescription = "Show Details",
            modifier = Modifier.clickable { showDetails1 = !showDetails1 })

    }
}