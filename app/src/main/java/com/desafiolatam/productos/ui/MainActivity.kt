package com.desafiolatam.productos.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.desafiolatam.productos.ProductoApp
import com.desafiolatam.productos.data.local.AssetEntityCat
import com.desafiolatam.productos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnItemClickListener {


    lateinit var binding: ActivityMainBinding

    private val assetViewModel: AssetViewModel by viewModels {
        AssetViewModelFactory((application as ProductoApp).repository)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val recyclerView = binding.recyclerview

        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = AssetListAdapter(this)

        recyclerView.adapter = adapter

        assetViewModel.allAssets.observe(this) {
                assets -> assets.let { adapter.submitList(it)}
        }

        binding.swipeRefreshLayout.setOnRefreshListener {
            assetViewModel.getUpdatdData()
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

    override fun onItemClick(asset: AssetEntityCat) {
        val intent = Intent(this, AssetDetailActivity::class.java)
        intent.putExtra("asset", asset)
        startActivity(intent)
    }


}