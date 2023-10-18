package com.desafiolatam.productos.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.desafiolatam.productos.data.local.AssetEntityProd
import com.desafiolatam.productos.databinding.ActivityAssetProdDetailBinding
import com.squareup.picasso.Picasso

class AssetProdDetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityAssetProdDetailBinding
    private val viewModel: AssetViewModel by viewModels()
    private val asset = intent.extras?.getSerializable("asset") as AssetEntityProd
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAssetProdDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Picasso.get()
            .load("https://api.escuelajs.co/api/v1/products${asset.images?.lowercase()}@2x.png")
            .resize(250, 250)
            .into(binding.assetImages)

        binding.assetTitle.text = asset.title
        binding.assetCreationat.text = asset.creationAt
        binding.assetPrice.text = "${asset.price} USD"
        binding.btnSave.setOnClickListener{
            addComment()
        }

        val rt= binding.productRatingBar
        rt.progress

    }
     fun addComment(){
        lifecycleScope.launchWhenCreated {
            val comment = binding.comment.text.toString()
            val id = asset.id.toString()

            viewModel.addComment(
                AssetEntityProd(id=id,creationAt= null,price =null, description = null, title = title.toString(),images = null, comment = comment)
            )
        }
        Toast.makeText(this,"Comentario guardado", Toast.LENGTH_SHORT).show()
    }
}