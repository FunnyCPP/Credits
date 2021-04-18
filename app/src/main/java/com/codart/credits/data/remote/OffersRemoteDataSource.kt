package com.codart.credits.data.remote

import javax.inject.Inject

class OffersRemoteDataSource @Inject constructor(
        private val offersService: OffersService
): BaseDataSource() {
    suspend fun getOffers(category_id: Int, country_id: Int) = getResult { offersService.getOffers(category_id,country_id) }
}