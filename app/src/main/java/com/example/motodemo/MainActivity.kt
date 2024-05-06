package com.example.motodemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //  Student abdul = new Student("ansari",234,"ahladf",45678);

        var abdul = Student("ansari",123,"jakldhaf",7654)
    }
}