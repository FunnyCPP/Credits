package com.codart.credits.data.repository

import com.codart.credits.data.local.CategoriesDao
import com.codart.credits.data.remote.CategoriesRemoteDataSource
import com.codart.credits.utils.performGetOperation
import javax.inject.Inject

class CategoriesRepository  @Inject constructor(
        private val remoteDataSource: CategoriesRemoteDataSource,
        private val localDataSource: CategoriesDao
) {
    fun getCategories(country_id: Int) = performGetOperation(
            databaseQuery = { localDataSource.getCategories() },
            networkCall = { remoteDataSource.getCategories(country_id) },
            saveCallResult = { localDataSource.insertAll(it.data) }
    )
}
