package com.example.movieapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.movieapp.moviedata.Movie
import com.example.movieapp.moviedata.getMovies

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Detail(name : String,navController: NavController){
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Row(horizontalArrangement = Arrangement.Start) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        })
                    Spacer(modifier = Modifier.width(127.dp))
                    Text("Movies", style = MaterialTheme.typography.headlineMedium)
                }
            },
            modifier = Modifier.background(MaterialTheme.colorScheme.primary), colors = topAppBarColors(
                containerColor = Color.Gray,
                titleContentColor = Color.Black,
            )
        )


    }) { it ->
        var newMovie = getMovies().filter { movie -> movie.id == name }
        Surface(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth().padding(top = it.calculateTopPadding())
        ) {
            DetailOfMovie(newMovie)


        }
       
    }}

@Composable
private fun DetailOfMovie(newMovie: List<Movie>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = newMovie[0].title, style = MaterialTheme.typography.headlineMedium)
        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.DarkGray,
                    fontSize = 13.sp
                )
            ) {
                append("Plot: ")
            }
            withStyle(
                style = SpanStyle(
                    color = Color.DarkGray,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append(newMovie[0].plot)
            }

        }, modifier = Modifier.padding(6.dp))

        Divider(modifier = Modifier.padding(3.dp))
        Text(
            text = "Director: ${newMovie[0].director}",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Actors: ${newMovie[0].actors}",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Rating: ${newMovie[0].rating}",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(text = "Movie Images", style = MaterialTheme.typography.headlineMedium)
        HorizomtalImageView(newMovie)
    }
}
@Composable
fun HorizomtalImageView(newMovie: List<Movie>) {
    LazyRow {

            items(newMovie[0].images.size) {
                Card(modifier = Modifier.padding(12.dp).size(250.dp),elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                )) {
                    Image(
                        painter = rememberImagePainter(data = newMovie[0].images[it]),
                        contentDescription = "Movie Image are not show"
                    )

                }
            }

    }

}