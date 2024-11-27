package com.mertadali.movieappkotlin.presentation.movie_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mertadali.movieappkotlin.domain.use_case.get_movie_details.GetMovieDetailUseCase
import com.mertadali.movieappkotlin.util.Constants.IMDB_ID
import com.mertadali.movieappkotlin.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MoviesDetailViewModel @Inject constructor(private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val stateHandle: SavedStateHandle) : ViewModel() {

    private val _state = mutableStateOf<MoviesDetailState>( MoviesDetailState())
    val state : State<MoviesDetailState> = _state

    init {
        stateHandle.get<String>(IMDB_ID)?.let {
            getMoviesDetailFromUseCase(it)
        }
    }
   private var job : Job? = null

    private fun getMoviesDetailFromUseCase(imdb : String){
        job?.cancel()
        job = getMovieDetailUseCase.executeGetMovieDetailUseCase(imdb).onEach {

           when(it){
               is Resource.Loading ->{
                   _state.value = MoviesDetailState(isLoading = true)
               }
               is  Resource.Error ->{
                   _state.value = MoviesDetailState(errorDetail = it.message ?: "Error")

               }
               is Resource.Success ->{
                   _state.value = MoviesDetailState(oneMovie = it.data)

               }

           }
       }.launchIn(viewModelScope)

    }



}