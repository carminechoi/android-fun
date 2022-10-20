package com.example.practice

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.ic_home, "Home")
    object Tip : NavigationItem("tip", R.drawable.ic_tip, "Tip")
    object Weather : NavigationItem("weather", R.drawable.ic_weather, "Weather")
    object Calculator : NavigationItem("calculator", R.drawable.ic_calculate, "Calculate")
    object Profile : NavigationItem("profile", R.drawable.ic_profile, "Profile")
}