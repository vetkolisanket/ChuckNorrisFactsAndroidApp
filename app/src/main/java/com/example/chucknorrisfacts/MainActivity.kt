package com.example.chucknorrisfacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import com.bumptech.glide.Glide
import com.example.chucknorrisfacts.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModels()
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