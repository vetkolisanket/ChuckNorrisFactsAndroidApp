package com.example.chucknorrisfacts

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.bumptech.glide.Glide
import com.example.chucknorrisfacts.databinding.ActivityMainBinding
import com.example.chucknorrisfacts.theme.SunflowerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SunflowerTheme {
                Surface {
                    Main(viewModel = viewModel)
                }
            }
        }
        viewModel.getFact()
    }

    @Composable
    fun Main(viewModel: MainViewModel) {
        val fact by viewModel.getFactLD().observeAsState()
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = fact?.value ?: "",
                modifier = Modifier.fillMaxWidth(),
            )
            Button(onClick = { viewModel.getFact() }) {
                Text(text = "Next")
            }
        }
    }
}