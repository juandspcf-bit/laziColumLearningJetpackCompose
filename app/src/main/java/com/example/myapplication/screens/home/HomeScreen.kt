package com.example.myapplication.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.model.Movie
import com.example.myapplication.model.getMovies
import com.example.myapplication.navigation.MovieScreens
import com.example.myapplication.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController){
    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = Color.Cyan,
            elevation = 5.dp
        ) {
            Text(text = "Movies", fontWeight = FontWeight.ExtraBold)
        }
    }) {
        MainContent(navController = navController)
    }

}


@Composable
fun MainContent( navController: NavController,
    movieList: List<Movie> = getMovies()
) {
    Column {
        LazyColumn() {
            items(items = movieList) { it ->
                MovieRow(movie = it){
                    Log.d("TAG", "MainContent: $it")
                    navController.navigate(route = MovieScreens.DetailScreen.name+"/$it")
                }
            }
        }
    }

}