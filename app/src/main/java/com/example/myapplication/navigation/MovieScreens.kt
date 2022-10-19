package com.example.myapplication.navigation

enum class MovieScreens {
    HomeScreen,
    DetailScreen;
    companion object{
        fun fromRoute(route:String): MovieScreens{
            return when(route.substringBefore("/")){
                HomeScreen.name -> HomeScreen
                DetailScreen.name -> DetailScreen
                else -> {HomeScreen}
            }
        }
    }
}