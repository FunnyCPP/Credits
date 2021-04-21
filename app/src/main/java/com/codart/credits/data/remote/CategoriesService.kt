package com.codart.credits.data.remote

import com.codart.credits.data.entities.GetCategories
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CategoriesService {
    @GET("categories/country/{country_id}")
    suspend fun getCategories(@Path("country_id") country_id: Int) : Response<GetCategories>
}