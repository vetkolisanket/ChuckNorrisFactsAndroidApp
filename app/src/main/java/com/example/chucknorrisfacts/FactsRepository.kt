package com.example.chucknorrisfacts

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object FactsRepository {

    private val service by lazy { RestClient.getFactsService() }

    suspend fun getFact(): Fact {
        return withContext(Dispatchers.IO) {
            service.getFact()
        }
    }

}