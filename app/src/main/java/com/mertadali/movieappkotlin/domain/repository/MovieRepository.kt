package com.mertadali.movieappkotlin.domain.repository

import com.mertadali.movieappkotlin.data.remote.dto.MovieDTO
import com.mertadali.movieappkotlin.data.remote.dto.MovieDetailDTO

interface MovieRepository {

    suspend fun getMovies(search: String) : MovieDTO
    suspend fun getMoviesDetail(imdbId : String) : MovieDetailDTO
}