package com.alexpetrov.tinder

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.facebook.drawee.backends.pipeline.Fresco

class MainApp : Application() {

    @SuppressLint("StaticFieldLeak")
    object ContextHolder {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        ContextHolder.context = this
    }
}