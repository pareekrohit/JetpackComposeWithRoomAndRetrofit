package com.example.loginregsitration.model.roomDB

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.example.loginregsitration.model.MoviesRespItem

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMoviesList(list: List<MoviesRespItem>)

    @Query("SELECT * FROM MoviesRespItem")
    suspend fun getMoviesList(): List<MoviesRespItem>

    /*@Query("SELECT * FROM MoviesRespItem WHERE id=:id")
    fun getSingleCake(id: String): LiveData<MoviesRespItem>*/


}