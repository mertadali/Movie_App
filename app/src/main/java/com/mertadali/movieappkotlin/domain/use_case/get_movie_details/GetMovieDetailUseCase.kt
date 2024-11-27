package com.mertadali.movieappkotlin.domain.use_case.get_movie_details

import com.mertadali.movieappkotlin.data.remote.dto.useMovieDetail
import com.mertadali.movieappkotlin.domain.model.MovieDetail
import com.mertadali.movieappkotlin.domain.repository.MovieRepository
import com.mertadali.movieappkotlin.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repository :MovieRepository){

    fun executeGetMovieDetailUseCase(imdb : String) : Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val detailList = repository.getMoviesDetail(imdb)
            emit(Resource.Success(detailList.useMovieDetail()))
        }catch (e : IOException){
           emit(Resource.Error(message = "No valid data"))

        }
    }
}