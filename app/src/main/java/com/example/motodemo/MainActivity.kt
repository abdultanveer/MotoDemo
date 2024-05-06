package com.example.motodemo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.motodemo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
 //   lateinit var tvDesc:TextView
   // lateinit var cancelBtn: Button

//    var count = 0
    lateinit var viewModel: MainViewModel


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     //  setContentView(R.layout.activity_main)
       // cancelBtn = findViewById(R.id.btnCancel)
       // createUI()
      //  tvDesc = findViewById(R.id.tvDesc) //getting handle
      //  Student abdul = new Student("ansari",234,"ahladf",45678);

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.tvDesc.setText(""+viewModel.count)

      /*  val secsObserver: Observer<Int> = object : Observer<Int>() {
            fun onChanged(integer: Int) {
                binding.tvDesc.setText(integer.toString())
            }
        }*/

        var secsObserver : Observer<Int> = object :Observer<Int>{
            override fun onChanged(value: Int) {
                //receiving the update/notification
                binding.tvDesc.setText(value.toString())
            }
        }

        //im registering/subscribing secsobserver
        viewModel._seconds.observe(this, secsObserver);


        binding.btnInc.setOnClickListener {
            viewModel.startTimer()
            binding.tvDesc.setText(""+viewModel._seconds)
           /* viewModel.incrementCount()
            binding.tvDesc.setText(""+ viewModel.count)*/
        }
        var abdul = Student("ansari",123,"jakldhaf",7654)
    }

    private fun createUI() {
        var layout = ConstraintLayout(this)
        var tvDesc = TextView(this)
        var loginBtn =  Button(this)
        loginBtn.setText("login")
        layout.addView(tvDesc)
        layout.addView(loginBtn)
    }

    fun clickHandler(view: View) {
        binding.tvDesc.setText("clicked by view binding")
        //tvDesc.setText("i was clicked")
    }
}