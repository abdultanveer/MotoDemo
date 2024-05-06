package com.example.motodemo

import android.app.Application
import com.example.motodemo.data.ItemRoomDatabase

class ItemApplication:Application() {
    val database: ItemRoomDatabase by lazy { ItemRoomDatabase.getDatabase(this) }

}