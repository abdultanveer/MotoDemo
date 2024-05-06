package com.example.motodemo

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    var TAG = MainViewModel::class.java.simpleName
    var count = 0
    lateinit var timer: CountDownTimer
   // var _seconds:Int =  0
      val _seconds = MutableLiveData<Int>()

    //  val seconds:Int = 0


    fun startTimer() {
        timer = object :CountDownTimer(10_000,1_000){
            override fun onTick(millisUntilFinished: Long) {
                Log.i(TAG,"time remaining --"+_seconds)

                _seconds.value = millisUntilFinished.toInt()

            }

            override fun onFinish() {
            }
        }.start()
    }

        fun incrementCount(){
        count++
    }
}