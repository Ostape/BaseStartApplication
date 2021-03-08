package com.robosh.basestartapplication.application

import android.app.Application
import com.robosh.basestartapplication.net.di.netModule
import com.robosh.basestartapplication.testModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RoboshApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@RoboshApp)
            modules(
                listOf(
                    testModule,
                    netModule
                )
            )
        }
    }
}