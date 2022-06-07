package com.example.mycomposeapp.model.retrofit

import android.content.Context
import com.example.loginregsitration.model.retrofit.ApiService
import com.example.mycomposeapp.model.retrofit.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    fun buildApi(): ApiService {
        val interceptor = HttpLoggingInterceptor()
        interceptor.apply { interceptor.level = HttpLoggingInterceptor.Level.BODY }
        /*val client = OkHttpClient.Builder().addInterceptor().build()*/

        val client = OkHttpClient.Builder()
        client.addInterceptor(interceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .followRedirects(true)
            .followSslRedirects(true)
            .build()
        /*.addInterceptor { chain ->
            val newRequest = chain.request().newBuilder()
                .addHeader("Authorization", UUID.randomUUID().toString())
                .build()
            chain.proceed(newRequest)
        }*/


        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            /*.client(client)*/
            .build()
            .create(ApiService::class.java)
    }
}

