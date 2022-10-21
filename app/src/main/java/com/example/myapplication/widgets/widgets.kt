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
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.myapplication.model.Movie

@Composable
fun MovieRow(movie: Movie, OnItemClicked: (String) -> Unit) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()

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
                        Text(buildAnnotatedString {
                            withStyle(style = SpanStyle(color= Color.DarkGray,
                                fontSize= 13.sp)
                            ){
                                append("Plot: ")
                            }
                            withStyle(style = SpanStyle(color= Color.DarkGray,
                                fontSize= 13.sp,
                                fontWeight = FontWeight.Light
                            )
                            ){
                                append(movie.plot)
                            }
                        }, modifier = Modifier.padding(4.dp))
                        Divider(modifier= Modifier.padding(6.dp))
                        Text(text="Director: ${movie.director}", style=MaterialTheme.typography.caption)
                        Text(text="Actors: ${movie.actors}", style=MaterialTheme.typography.caption)
                        Text(text="Rating: ${movie.rating}", style=MaterialTheme.typography.caption)

                    }

                }
                Icon(
                    imageVector = if (!expanded) {
                        Icons.Filled.KeyboardArrowDown
                    } else {
                        Icons.Filled.KeyboardArrowUp
                    },
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