package com.example.motodemo

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import kotlin.random.Random
/*
1.  i added aidl in build features of gradle = true sync
2. select the app folder rt click -- new - aidl-aidl file
3. gavethe name as IAddMoto and create a abstract method add(int a, int b)
4. rebuild the project
5.  in MyService -- create a var aidlBinder and implement the add method
5. in manifest add the intent filter
 */
class MyService : Service() {
    private val mybinder = LocalBinder()


    private val aidlBinder = object : IAddMoto.Stub() {
        override fun add(a: Int, b: Int): Int {
            Log.i(TAG,"sum is "+ a+b)
            return a+b
        }
    }

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
        return  aidlBinder //2
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