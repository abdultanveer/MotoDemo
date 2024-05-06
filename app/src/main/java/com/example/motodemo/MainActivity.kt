package com.example.motodemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.motodemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
 //   lateinit var tvDesc:TextView
   // lateinit var cancelBtn: Button

    var count = 0

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

        binding.btnInc.setOnClickListener {
            binding.tvDesc.setText(""+ ++count)
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