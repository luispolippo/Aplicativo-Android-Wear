package com.polippo.sharedlib

data class Meal(
    val title: String,
    val calories: Int,
    val ingredients: List<String>,
    val favored: Boolean
)
