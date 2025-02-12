package com.example.movieapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.Component.Header
import com.example.movieapp.Component.movieCard

@Composable
fun MainContent(navController: NavController){
    var movielists = listOf<String>("IronMan","SpiderMan","Avenger EndGame","Avanger Infinity War","Thor Love And Thunder","Thor Love And Thunder",
        "IronMan","SpiderMan","Avenger EndGame","Avanger Infinity War","Thor Love And Thunder","Thor Love And Thunder")
    MovieList(movielists,navController)

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieList(movielist : List<String> , navController: NavController){
    Scaffold(topBar = {
        TopAppBar(modifier = Modifier.fillMaxWidth().background(color = Color.Blue),
            title = {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center,verticalAlignment = Alignment.CenterVertically) {
                    Text("Movies", style = MaterialTheme.typography.headlineMedium, color = Color.Red)
                }
            }
            )



    }) { paddingValues ->  // Apply this padding inside the Column
        Column(modifier = Modifier.padding(paddingValues)) {
            LazyColumn {
                items(movielist.size) { moviee ->  // Correct way to loop through the list
                    movieCard(movielist[moviee], navController)
                }
            }
        }

}

}