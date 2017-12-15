package com.example.joshb.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.joshb.coderswag.Model.Product
import com.example.joshb.coderswag.R
import com.example.joshb.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    lateinit var size : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)

        productTitleTxt.text = product.title
        val imageID = resources.getIdentifier(product.image, "drawable", packageName)
        productImg.setImageResource(imageID)
        productPriceTxt.text = product.price

        size = sizeSpinner

        val sizeAdapter = ArrayAdapter.createFromResource(this, R.array.sizes_array, android.R.layout.simple_spinner_item)
        sizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        size.adapter = sizeAdapter

        var selectedSize = ""

        size.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                selectedSize = "Select a Size"
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selectedSize = size.getItemAtPosition(p2).toString()
            }
        }

        buyBtn.setOnClickListener {
            Toast.makeText(this, "You bought a ${selectedSize} ${product.title}.", Toast.LENGTH_SHORT).show()
        }
    }
}
