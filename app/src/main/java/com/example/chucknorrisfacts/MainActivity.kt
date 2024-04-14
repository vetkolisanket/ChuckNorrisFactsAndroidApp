package com.example.chucknorrisfacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import com.bumptech.glide.Glide
import com.example.chucknorrisfacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.getFact()
        viewModel.getFactLD().observe(this) {
            binding.tvFact.text = it.value
            Glide.with(this).load(it.iconUrl).into(binding.ivImage)
        }
        binding.btnNext.setOnClickListener { viewModel.getFact() }
    }
}