package com.waichee.hiltpractice01.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.waichee.hiltpractice01.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}