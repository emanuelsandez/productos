package com.desafiolatam.productos.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.desafiolatam.productos.data.local.AssetEntityCat
import com.desafiolatam.productos.data.local.AssetEntityProd
import com.desafiolatam.productos.databinding.ActivityAssetCatDetailBinding
import com.squareup.picasso.Picasso

class AssetDetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityAssetCatDetailBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAssetCatDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val asset = intent.extras?.getSerializable("asset") as AssetEntityCat
        val assetp = intent.extras?.getSerializable("asset") as AssetEntityProd

        Picasso.get()
            .load("https://api.escuelajs.co/api/v1/products${asset.imageCategory?.lowercase()}@2x.png")
            .resize(250, 250)
            .into(binding.assetImagecategory)

        binding.assetNamecategory.text= asset.nameCategory
        binding.assetTitle.text=assetp.title
        binding.assetPrice.text=assetp.price
        binding.assetCreationat.text=assetp.creationAt

    }
}