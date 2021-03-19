package com.polippo.wearbootcamp03

data class Meal(
    val title: String,
    val calories: Int,
    val ingredients: List<String>,
    val favored: Boolean
)
