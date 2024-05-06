package com.example.motodemo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.motodemo.data.Item
import com.example.motodemo.data.ItemDao
import com.example.motodemo.data.ItemRoomDatabase
import com.example.motodemo.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
 //   lateinit var tvDesc:TextView
   // lateinit var cancelBtn: Button

    lateinit var dao: ItemDao


    /*  private val viewModel: MainViewModel by activity {
          MainViewModel.HomeViewModelFactory(
              (this?.application as ItemApplication).database
                  .itemDao()
          )
       }*/

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
        var  database = ItemRoomDatabase.getDatabase(this)
        dao = database.itemDao()

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

        binding.btnInsert.setOnClickListener {
            insertDb()
        }
        binding.btnGet.setOnClickListener {
            retreiveDb().observe(this){
                    itemRetreived -> binding.tvDb.text = itemRetreived.toString()

            }
        }

    }

    fun add( a:Int){

    }
    private fun insertDb() {
        GlobalScope.launch {
            var item = Item(21,"fruits",11.11,11)
            dao.insert(item)
        }
    }

    fun retreiveDb(): LiveData<Item> {
        return dao.getItem(12).asLiveData()

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