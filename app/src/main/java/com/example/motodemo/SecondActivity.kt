package com.example.motodemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.motodemo.databinding.ActivityMainBinding
import com.example.motodemo.databinding.ActivitySecondBinding
import com.example.motodemo.network.MarsApi
import kotlinx.coroutines.launch

class SecondActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnGetJson.setOnClickListener {
            getMarsPhotos()
        }
    }

    private fun getMarsPhotos() {
        lifecycleScope.launch {

            val listResult = MarsApi.retrofitService.getPhotos()
            binding.tvJson.text = listResult
            //_status.value = listResult
        }
        }
}