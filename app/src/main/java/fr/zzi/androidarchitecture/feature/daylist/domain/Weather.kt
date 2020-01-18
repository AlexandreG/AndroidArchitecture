package fr.zzi.androidarchitecture.feature.daylist.domain

data class Weather(
    val icon: String,
    val iconURL: String,
    val main: String,
    val description: String
)