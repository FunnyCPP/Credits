package com.codart.credits.data.remote

import com.codart.credits.data.entities.GetOffersDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface OfferDetailService {
    @GET("products/{product_id}")
    suspend fun getOffer(@Path("product_id")product_id: Int) : Response<GetOffersDetail>
}