package com.example.motodemo

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.motodemo.databinding.ActivityMainBinding
import com.example.motodemo.databinding.ActivitySecondBinding
import com.example.motodemo.network.MarsApi
import kotlinx.coroutines.launch

class SecondActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySecondBinding
    lateinit var mService: MyService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnGetJson.setOnClickListener {
            getMarsPhotos()
        }

        binding.btnStart.setOnClickListener { startMyService() }
        binding.btnStop.setOnClickListener { stopMyService() }
        binding.btnBind.setOnClickListener { bindMyService() }
        binding.btnUnbind.setOnClickListener { unbindMyService() }
    }

    private fun unbindMyService() {
        TODO("Not yet implemented")
    }

    private fun bindMyService() {
        var serviceIntent = Intent(this, MyService::class.java)

        bindService(serviceIntent,serviceConnection, BIND_AUTO_CREATE)//1
    }


    private val serviceConnection = object : ServiceConnection {
        //3
        override fun onServiceConnected(p0: ComponentName?, mybinder: IBinder?) {
            val binder = mybinder  as MyService.LocalBinder
           // mService = MyService()
            mService = binder.getInstanceMyService()
           var score = mService.latestScore
            Log.i(TAG,"score is --"+score)
           var location = mService.getLocation()
            Log.i(TAG,"location is --"+location)

        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            TODO("Not yet implemented")
        }
    }

        private fun stopMyService() {
        var serviceIntent = Intent(this, MyService::class.java)
        stopService(serviceIntent)
    }

    private fun startMyService() {
        var serviceIntent = Intent(this, MyService::class.java)
        serviceIntent.putExtra("downloadurl","http://download.com/movie")
        startService(serviceIntent)
    }


    private fun getMarsPhotos() {
        lifecycleScope.launch {
            val listResult = MarsApi.retrofitService.getPhotos()
            binding.tvJson.text = "the json contains ${listResult.size} no of json objects"
            //_status.value = listResult
        }
        }

    companion object{
        var TAG = SecondActivity::class.java.simpleName
    }
}