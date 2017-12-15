package com.example.joshb.coderswag.Controller

import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.telecom.Call
import com.example.joshb.coderswag.Adapters.ProductsRecycleAdapter
import com.example.joshb.coderswag.Model.Product
import com.example.joshb.coderswag.R
import com.example.joshb.coderswag.Services.DataService
import com.example.joshb.coderswag.Utilities.EXTRA_CATEGORY
import com.example.joshb.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter : ProductsRecycleAdapter
    var product = Product("", "", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        productsTypeTxt.text = categoryType
        adapter = ProductsRecycleAdapter(this, DataService.getProducts(categoryType)) { product ->
            val detailsIntent = Intent(this, DetailsActivity :: class.java)
            detailsIntent.putExtra(EXTRA_PRODUCT, product)
            startActivity(detailsIntent)
        }

        var spanCount = 2
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3
        }

        val screenSize = resources.configuration.screenWidthDp
        if (screenSize > 720) {
            spanCount = 3
        }

        val layoutManager = GridLayoutManager(this, spanCount)
        productsListView.layoutManager = layoutManager
        productsListView.adapter = adapter
    }
}
