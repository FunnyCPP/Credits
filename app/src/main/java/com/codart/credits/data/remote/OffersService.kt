package com.codart.credits.data.remote

import com.codart.credits.data.entities.GetOffers
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface OffersService {
    @GET("products/category/{category_id}/country/{country_id}")
    suspend fun getOffers(@Path("category_id")category_id: Int, @Path("country_id")country_id: Int) : Response<GetOffers>
}