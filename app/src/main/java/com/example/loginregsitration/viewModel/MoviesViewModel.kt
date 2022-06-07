package com.example.loginregsitration.viewModel

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginregsitration.model.MoviesRespItem
import com.example.loginregsitration.model.repository.Repository
import com.example.loginregsitration.model.roomDB.AppDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository: Repository

    init {
        val dao = AppDB.getInstance()?.getDao()
        repository = dao?.let { Repository(dao = it) }!!
        getMeal()
    }

    val moviesState: MutableState<List<MoviesRespItem>> =
        mutableStateOf(emptyList<MoviesRespItem>())

    private fun getMeal() {
        viewModelScope.launch(Dispatchers.IO) {
            val moviesList = repository.getMoviesList()
            moviesState.value = moviesList
        }
    }


    private fun setLike(like: Boolean) {

    }

}