package com.example.motodemo

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import kotlin.random.Random

class MyService : Service() {
    private val mybinder = LocalBinder()

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG,"service created")
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
         super.onStartCommand(intent, flags, startId)
        var url = intent?.getStringExtra("downloadurl")
        Log.i(TAG,"service started and downloading from -"+url)

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"service destroyed")

    }

    private val mGenerator = Random(20)

    fun getLocation():String{
        return "penang"
    }

    val latestScore: Int
        get() = mGenerator.nextInt(100)

    //whenever a client[activity tries to bind to this service i'll return this binder
    override fun onBind(intent: Intent): IBinder {
        Log.i(TAG,"incoming binding requesting")
        return  mybinder //2
    }

    companion object{
        var TAG = MyService::class.java.simpleName
    }

    inner class LocalBinder : Binder(){

        //4
        fun getInstanceMyService():MyService{
            return  this@MyService
        }
    }
}