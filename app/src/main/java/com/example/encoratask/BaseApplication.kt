package com.example.encoratask

import android.app.Application
import com.example.encoratask.di.AppComponent
import com.example.encoratask.di.DaggerAppComponent

class BaseApplication : Application(){

    companion object {
        private lateinit var appComponent: AppComponent

        fun getAppComponent() = appComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().build()
    }
}