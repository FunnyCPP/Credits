package com.codart.credits.data.repository

import com.codart.credits.data.remote.OfferDetailRemoteDataSource
import com.codart.credits.utils.performGetOperationWithoutDB
import javax.inject.Inject

class OfferDetailRepository @Inject constructor(
        private val remoteDataSource: OfferDetailRemoteDataSource,
) {
    fun getOffer(product_id:Int) = performGetOperationWithoutDB(
            networkCall = { remoteDataSource.getOffer(product_id) }
    )
}