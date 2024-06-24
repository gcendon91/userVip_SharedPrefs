package com.gcendon.uservip

import android.app.Application

class UserVipApplication: Application(){
    //companion object hace q la variable dentro sea accedida por toda la aplicacion, y el late init
    //permite que se inicialize mas tarde la variable.
    companion object {
        lateinit var prefs:Prefs
    }
    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}