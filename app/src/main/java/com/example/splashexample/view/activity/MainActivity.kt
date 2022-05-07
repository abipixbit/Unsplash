package com.example.splashexample.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.splashexample.R
import com.example.splashexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}