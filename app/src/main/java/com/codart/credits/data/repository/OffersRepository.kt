package com.codart.credits.data.repository

import com.codart.credits.data.remote.OffersRemoteDataSource
import com.codart.credits.utils.performGetOperationWithoutDB
import javax.inject.Inject

class OffersRepository @Inject constructor(
        private val remoteDataSource: OffersRemoteDataSource,
) {
    fun getOffers(category_id:Int, country_id:Int) = performGetOperationWithoutDB(
            networkCall = { remoteDataSource.getOffers(category_id,country_id) }
    )
}