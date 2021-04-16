package com.codart.credits.data.remote

import com.codart.credits.data.entities.GetCountries
import retrofit2.Response
import retrofit2.http.GET

interface CountriesService {
    @GET("countries")
    suspend fun getCountries() : Response<GetCountries>
}