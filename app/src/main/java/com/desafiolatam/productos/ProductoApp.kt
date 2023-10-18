package com.desafiolatam.productos

import android.app.Application
import com.desafiolatam.productos.data.local.AssetDatabase
import com.desafiolatam.productos.data.local.AssetRepository

class ProductoApp : Application() {

    private val database by lazy {
        AssetDatabase.getDatabase(this)
    }

    val repository by lazy {
        AssetRepository(database.assetDao())
    }
}