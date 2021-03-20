package com.polippo.shared

data class Meal(
    val title: String,
    val calories: Int,
    val ingredients: List<String>,
    val favored: Boolean
)
