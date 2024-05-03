package com.example.chucknorrisfacts

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _factStateFlow = MutableStateFlow<UIState<Fact>>(UIState.Loading)
    val factStateFlow = _factStateFlow.asStateFlow()


    fun getFact() {
        viewModelScope.launch {
            _factStateFlow.value = UIState.Loading
            try {
                val fact = FactsRepository.getFact()
                _factStateFlow.value = UIState.Success(fact)
            } catch (e: Exception) {
                Log.e("getFact", "getFact: ${e.message}", )
                _factStateFlow.value = UIState.Error(getErrorMessage(e))
            }
        }
    }

    private fun getErrorMessage(e: Exception): String {
        return e.message ?: "Something went wrong!"
    }

}