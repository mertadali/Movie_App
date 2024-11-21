package com.mertadali.movieappkotlin.data.remote.dto

import com.mertadali.movieappkotlin.domain.model.Movie

data class MovieDTO(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)

fun MovieDTO.useMovieList() : List<Movie>{
    return Search.map { search -> Movie(search.Poster,search.Title,search.Year,search.imdbID) }

}

