package com.example.testvk

import android.app.Application
import com.example.testvk.di.application
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKTokenExpiredHandler
import org.koin.core.context.GlobalContext.startKoin

class SampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(application))
        }
        VK.addTokenExpiredHandler(tokenTracker)
    }

    private val tokenTracker = object : VKTokenExpiredHandler {
        override fun onTokenExpired() {
            // token expired
        }
    }


}