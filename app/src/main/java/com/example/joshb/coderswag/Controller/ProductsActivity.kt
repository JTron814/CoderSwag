package com.example.joshb.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.joshb.coderswag.R
import com.example.joshb.coderswag.Utilities.EXTRA_CATEGORY

class ProductsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        println(categoryType)
    }
}
