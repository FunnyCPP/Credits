package com.codart.credits.data.remote

import javax.inject.Inject

class OfferDetailRemoteDataSource @Inject constructor(
        private val offerDetailService: OfferDetailService
): BaseDataSource() {
    suspend fun getOffer(product_id: Int) = getResult { offerDetailService.getOffer(product_id) }
}