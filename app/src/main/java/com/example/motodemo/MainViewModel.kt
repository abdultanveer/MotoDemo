package com.example.motodemo

import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    var count = 0

    fun incrementCount(){
        count++
    }
}