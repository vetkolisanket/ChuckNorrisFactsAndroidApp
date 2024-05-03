package com.example.chucknorrisfacts

sealed class UIState<out T> {

    object Loading: UIState<Nothing>()

    class Error(val message: String): UIState<Nothing>()

    class Success<T>(val data: T): UIState<T>()

}