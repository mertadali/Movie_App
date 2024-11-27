package com.mertadali.movieappkotlin.presentation.movies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mertadali.movieappkotlin.domain.use_case.get_movies.GetMoviesUseCase
import com.mertadali.movieappkotlin.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val getMoviesUseCase: GetMoviesUseCase) :ViewModel() {

    private val _state = mutableStateOf(value = MoviesState())
    val state  : State<MoviesState> = _state

    private var job : Job? = null

    init {
        getMoviesFromUseCase(_state.value.searching)
    }

    private fun getMoviesFromUseCase(search : String){
        job?.cancel()
        job = getMoviesUseCase.executeGetMovie(search).onEach {

            when(it){
                is  Resource.Success ->{
                    _state.value = MoviesState(movieList = it.data ?: emptyList())

                }
                is Resource.Loading ->{
                    _state.value = MoviesState(isLoading = true)

                }
                is Resource.Error->{
                    _state.value = MoviesState(error = it.message ?: "Error")
                }
            }

        }.launchIn(viewModelScope)
    }

    fun onEvent(event: MoviesEvent){
        when(event){
            is MoviesEvent.Search ->{
                getMoviesFromUseCase(search = event.searchString)
            }
        }

    }

}