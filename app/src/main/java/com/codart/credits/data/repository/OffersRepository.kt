package com.codart.credits.data.repository

import com.codart.credits.data.local.OffersDao
import com.codart.credits.data.remote.OffersRemoteDataSource
import com.codart.credits.utils.performGetOperation
import javax.inject.Inject

class OffersRepository @Inject constructor(
        private val remoteDataSource: OffersRemoteDataSource,
        private val localDataSource: OffersDao
) {
    fun getOffers(category_id:Int, country_id:Int) = performGetOperation(
            databaseQuery = { localDataSource.getOffers(country_id) },
            networkCall = { remoteDataSource.getOffers(category_id,country_id) },
            saveCallResult = { localDataSource.insertAll(it.data) }
    )
}