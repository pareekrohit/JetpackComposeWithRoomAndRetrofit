package com.example.loginregsitration

import android.app.Application
import com.example.loginregsitration.model.roomDB.AppDB

class MyApplication : Application() {


    /*init {
        instance = this
    }*/


    override fun onCreate() {
        super.onCreate()
        instance = this
        AppDB.getDatabase(this)

    }

    /*val database: AppDB by lazy { AppDB.getDatabase(this) }*/

    companion object {
        lateinit var instance: MyApplication
    }


}