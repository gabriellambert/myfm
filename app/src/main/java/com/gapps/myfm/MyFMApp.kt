package com.gapps.myfm

import android.app.Application
import com.gapps.myfm.di.androidModule
import com.google.firebase.Firebase
import com.google.firebase.initialize
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.context.GlobalContext.stopKoin

class MyFMApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Firebase.initialize(this)
        startKoin {
            androidContext(this@MyFMApp)
            modules(
                androidModule
            )
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        stopKoin()
    }
}