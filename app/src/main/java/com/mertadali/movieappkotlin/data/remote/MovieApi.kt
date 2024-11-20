package com.mertadali.movieappkotlin.data.remote

import com.mertadali.movieappkotlin.data.remote.dto.MovieDTO
import com.mertadali.movieappkotlin.data.remote.dto.MovieDetailDTO
import com.mertadali.movieappkotlin.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    // https://www.omdbapi.com/?i=tt3896198&apikey=1be7f48a    i parameter

    // https://www.omdbapi.com/?s=batman&apikey=1be7f48a       s parameter

    // Endpoint yok o sebeple . koyabiliriz

    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString: String,
        @Query("apikey") apiKey : String = API_KEY
    ):MovieDTO

    @GET(".")
    suspend fun getMoviesDetail(
        @Query("i") imdbId : String,
        @Query("apikey") apiKey: String = API_KEY
    ):MovieDetailDTO
}