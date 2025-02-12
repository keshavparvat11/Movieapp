package com.example.movieapp.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Header(){
    Card(modifier = Modifier.fillMaxWidth().height(50.dp)) {
        Text("Movie App")
    }
}

@Composable
fun movieCard(movie :String,navController: NavController) {
    Card(modifier = Modifier.fillMaxWidth().height(150.dp).padding(4.dp).clickable { navController.navigate("detail/$movie") }) {
        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(modifier = Modifier.size(140.dp), imageVector = Icons.Default.Person , contentDescription = "Movie Image")
            Text(text = movie, modifier = Modifier.padding(8.dp))

        }
    }
}