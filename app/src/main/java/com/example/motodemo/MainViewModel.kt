package com.example.motodemo

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.motodemo.data.ItemDao
import kotlinx.coroutines.launch


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
            Log.i(TAG,"count is --"+count)
        count++
    }




    /*class HomeViewModelFactory(private val itemDao: ItemDao) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(itemDao) as T    }
    }*/
}