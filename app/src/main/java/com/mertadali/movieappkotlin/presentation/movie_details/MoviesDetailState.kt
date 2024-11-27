package com.mertadali.movieappkotlin.presentation.movie_details

import com.mertadali.movieappkotlin.domain.model.MovieDetail

data class MoviesDetailState(
    val isLoading : Boolean = false,
    val errorDetail : String= "",
    val oneMovie  : MovieDetail? = null
)
