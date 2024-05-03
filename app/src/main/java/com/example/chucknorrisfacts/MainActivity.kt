package com.example.chucknorrisfacts

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
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
        val state = viewModel.factStateFlow.collectAsState()
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (state.value is UIState.Loading) {
                CircularProgressIndicator()
            } else if (state.value is UIState.Success) {
                Text(
                    text = (state.value as UIState.Success).data.value,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.body1
                )
            }
            Button(onClick = { viewModel.getFact() }) {
                Text(text = "Next")
            }
        }
    }
}