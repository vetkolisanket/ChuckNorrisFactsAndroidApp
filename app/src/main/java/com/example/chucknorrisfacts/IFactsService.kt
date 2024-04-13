package com.example.chucknorrisfacts

import retrofit2.http.GET

interface IFactsService {

    @GET(ApiConstants.FACT)
    suspend fun getFact(): Fact

}