package com.codart.credits.data.remote

import com.codart.credits.data.entities.GetCategories
import retrofit2.Response
import retrofit2.http.GET

interface CategoriesService {
    @GET("categories")
    suspend fun getCategories() : Response<GetCategories>
}