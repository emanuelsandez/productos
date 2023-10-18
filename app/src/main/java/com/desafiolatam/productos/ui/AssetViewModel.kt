package com.desafiolatam.productos.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.desafiolatam.productos.data.local.AssetEntityCat
import com.desafiolatam.productos.data.local.AssetEntityProd
import com.desafiolatam.productos.data.local.AssetRepository
import com.desafiolatam.productos.utils.UpdateData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class AssetViewModel(private val repository: AssetRepository) : ViewModel() {
    val allAssets: LiveData<List<AssetEntityCat> >by lazy {
        repository.allAssets.also {
            getUpdatdData()
        }
    }

     fun addComment(task: AssetEntityProd){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addComment(task)
        }
    }

    fun getUpdatdData() {
        runBlocking {
            UpdateData.getUpdatedData()
        }
    }


}

class AssetViewModelFactory(private val repository: AssetRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AssetViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AssetViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }




}
