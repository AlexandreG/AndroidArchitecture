package fr.zzi.androidarchitecture.common

import android.app.Application

class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        AppDatabase.init(this)
    }

}