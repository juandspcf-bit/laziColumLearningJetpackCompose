package com.example.myapplication.screens.home.details

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.myapplication.model.getMovies
import com.example.myapplication.navigation.MovieScreens
import com.example.myapplication.screens.home.MainContent
import com.example.myapplication.widgets.MovieRow


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailsScreen(navController: NavController, movieData: String?) {

    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = Color.Cyan,
            elevation = 5.dp
        ) {
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back to Home Page",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    }
                )
                Spacer(modifier = Modifier.width(100.dp))
                Text(text = "Movie info", fontWeight = FontWeight.ExtraBold)
            }

        }
    }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            movieData?.let {
                val filter = getMovies().filter { movie -> movie.id == it }
                MovieRow(movie = filter[0], OnItemClicked = {})
                Spacer(modifier = Modifier.height(8.dp))
                Divider()
                LazyRow() {
                    items(filter[0].images) { image ->
                        Card(modifier = Modifier
                            .padding(12.dp)
                            .size(240.dp), elevation = 5.dp) {
                            AsyncImage(
                                model = image,
                                contentDescription = null
                            )
                        }
                    }
                }


            }
        }
    }


}
