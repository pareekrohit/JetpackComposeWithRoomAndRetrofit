package com.example.loginregsitration.model.repository

import android.util.Log
import com.example.loginregsitration.checkForInternet
import com.example.loginregsitration.model.MoviesRespItem
import com.example.loginregsitration.model.retrofit.ApiService
import com.example.loginregsitration.model.roomDB.Dao
import com.example.mycomposeapp.model.retrofit.RetrofitClient

class Repository(
    private val api: ApiService = RetrofitClient().buildApi(),
    private val dao: Dao
) {

    private suspend fun getApiMovieList(): List<MoviesRespItem> {
        Log.d("Movies", "Repository Api Called")
        val res = api.getMoviesList()
        Log.d("Movies", "Resp ${res.toString()}")
        return res
    }

    /*suspend fun saveMovieListToDB() {
        if (checkForInternet()) {
            dao.insertMoviesList(getApiMovieList())
        } else {
            dao.insertMoviesList(list)
        }
    }*/


    suspend fun getMoviesList(): List<MoviesRespItem> {
        Log.d("Movies", "Repository getMoviesList")
        if (checkForInternet()) {
            dao.insertMoviesList(getApiMovieList())
            Log.d("Movies", "Repository Api data inserted into DB")
        }

        Log.d("Movies", "Repository Movies List returned")
        return dao.getMoviesList();
    }


}