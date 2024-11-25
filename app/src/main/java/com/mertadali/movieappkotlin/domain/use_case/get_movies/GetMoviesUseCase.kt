package com.mertadali.movieappkotlin.domain.use_case.get_movies

import coil.network.HttpException
import com.mertadali.movieappkotlin.data.remote.dto.useMovieList
import com.mertadali.movieappkotlin.domain.model.Movie
import com.mertadali.movieappkotlin.domain.repository.MovieRepository
import com.mertadali.movieappkotlin.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val repository: MovieRepository) {
    //Use case -> only one major public function, one feature, single responsibility
    fun executeGetMovie(search : String) : Flow<Resource<List<Movie>>> = flow {
        try{
            emit(Resource.Loading())
            val movieList = repository.getMovies(search)
            if (movieList.Response == "True"){
                emit(Resource.Success(movieList.useMovieList()))

            }else{
                emit(Resource.Error(message = "No valid data"))
            }

        }catch (e : IOException){
            emit(Resource.Error(message = "No network connection"))
        }catch (e : HttpException){
            emit(Resource.Error(message = e.localizedMessage ?: "Error"))
        }
    }


}