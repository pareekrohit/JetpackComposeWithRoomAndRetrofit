package com.example.loginregsitration.model.retrofit

import com.example.loginregsitration.model.MoviesResp
import com.example.loginregsitration.model.MoviesRespItem
import com.example.mycomposeapp.model.retrofit.Constants.Companion.MOVIES_ENDPOINT
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET(MOVIES_ENDPOINT)
    suspend fun getMoviesList(): List<MoviesRespItem>


}