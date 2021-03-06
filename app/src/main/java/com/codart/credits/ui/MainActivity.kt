package com.codart.credits.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codart.credits.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    companion object{
        var country_id: Int = 176
        var category_id: Int = 59
        var product_id: Int = 46
    }
}