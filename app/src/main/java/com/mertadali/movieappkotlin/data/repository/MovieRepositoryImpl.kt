package com.mertadali.movieappkotlin.data.repository

import com.mertadali.movieappkotlin.data.remote.MovieApi
import com.mertadali.movieappkotlin.data.remote.dto.MovieDTO
import com.mertadali.movieappkotlin.data.remote.dto.MovieDetailDTO
import com.mertadali.movieappkotlin.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api : MovieApi) : MovieRepository {
    override suspend fun getMovies(search: String): MovieDTO {
        return api.getMovies(search)


    }

    override suspend fun getMoviesDetail(imdbId: String): MovieDetailDTO {
        return api.getMoviesDetail(imdbId)
    }


}