package com.example.loginregsitration.model.roomDB

import android.app.Application
import androidx.room.*
import com.example.loginregsitration.model.MoviesRespItem

@Database(entities = [MoviesRespItem::class], version = 1, exportSchema = false)
/*@TypeConverters(FlavourConverter::class, SizeConverter::class)*/
abstract class AppDB : RoomDatabase() {

    abstract fun getDao(): Dao

    companion object {
        @Volatile
        private var INSTANCE: AppDB? = null
        fun getDatabase(application: Application): AppDB {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        application,
                        AppDB::class.java,
                        "Movies_app_database"
                    )
                        .build()
                }
            }
            return INSTANCE!!
        }


        // Use this to call on any place
        fun getInstance(): AppDB? {
            return INSTANCE
        }
    }



}