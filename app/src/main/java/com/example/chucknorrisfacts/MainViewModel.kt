package com.example.chucknorrisfacts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val factLD = MutableLiveData<Fact>()

    fun getFactLD(): LiveData<Fact> = factLD

    fun getFact() {
        viewModelScope.launch {
            val fact = FactsRepository.getFact()
            factLD.value = fact
        }
    }

}