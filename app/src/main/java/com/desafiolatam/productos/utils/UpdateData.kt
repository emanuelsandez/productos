package com.desafiolatam.productos.utils

import android.util.Log
import com.desafiolatam.productos.ProductoApp
import com.desafiolatam.productos.data.remote.PlatziRetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class UpdateData {

    companion object {

        // ESTE METODO SIRVE PARA OBTENER LOS DATOS ACTUALIZADOS CUANDO SE INSTALA LA APP

        suspend fun getUpdatedData() = coroutineScope {
            launch(Dispatchers.IO) {
                val service = PlatziRetrofitClient.retrofitInstance()
                val response = service.getData()
                val data = response.body()

                val app = ProductoApp()

                app.repository.deleteAssets()

                if (response.isSuccessful) {
                    if (data != null) {

                        for (asset in data.data) {
                            Log.i("Asset ", asset.idCategory)
                            app.repository.insertAsset(asset)
                        }
                    }
                } else {
                    Log.e("UpdateData Error", "Ocurrió un error al ejecutar getUpdatedData")
                }
            }
        }
    }

}