package com.example.chucknorrisfacts

import javax.inject.Inject

class FactsRepository @Inject constructor(private val service: IFactsService) {

    suspend fun getFact() = service.getFact()

}