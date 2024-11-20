package com.mertadali.movieappkotlin.data.remote.dto

data class MovieDTO(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)