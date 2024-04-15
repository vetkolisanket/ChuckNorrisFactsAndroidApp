package com.example.chucknorrisfacts

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val factLD = MutableLiveData<Fact>()

    fun getFactLD(): LiveData<Fact> = factLD

    fun getFact() {
        viewModelScope.launch {
            try {
                val fact = FactsRepository.getFact()
                factLD.value = fact
            } catch (e: Exception) {
                Log.e("getFact", "getFact: ${e.message}", )
            }
        }
    }

}