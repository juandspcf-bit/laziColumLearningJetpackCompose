package com.example.myapplication.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.myapplication.model.Movie

@Composable
fun MovieRow(movie: Movie, OnItemClicked: (String) -> Unit) {
    var expanded by remember{
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable {
                OnItemClicked(movie.id)
            },
        shape = RoundedCornerShape(corner = CornerSize(10.dp)),
        elevation = 6.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                elevation = 4.dp
            ) {
                //Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Movie Image")
                AsyncImage(
                    model = movie.images[0],
                    contentDescription = null
                )

            }
            Column(modifier = Modifier.padding(4.dp)) {
                Text(text = movie.title, style = MaterialTheme.typography.h6)
                Text(text = "Director: ${movie.director}", style = MaterialTheme.typography.caption)
                Text(text = "Release: ${movie.year}", style = MaterialTheme.typography.caption)

                AnimatedVisibility(visible = expanded) {
                    Column {
                        Text(text = "Heyyy")
                    }

                }
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Down Arrow",
                    modifier = Modifier.clickable {
                                                  expanded = !expanded
                    },
                    tint = Color.DarkGray
                )
            }


        }


    }
}