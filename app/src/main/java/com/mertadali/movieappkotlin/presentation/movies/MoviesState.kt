package com.mertadali.movieappkotlin.presentation.movies

import com.mertadali.movieappkotlin.domain.model.Movie

data class MoviesState(
    val isLoading : Boolean = false,
    val movieList : List<Movie> = emptyList(),
    val error  : String = "",
    val searching : String = "pulp"                    // kullanıcının etkişeleşime geçeceği yer -> Event
)


// view model içinde daha önceden yaptığımız kısımdı bu.



