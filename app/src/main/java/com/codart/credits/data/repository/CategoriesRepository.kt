package com.codart.credits.data.repository

import com.codart.credits.data.local.CategoriesDao
import com.codart.credits.data.remote.CategoriesRemoteDataSource
import com.codart.credits.utils.performGetOperation
import javax.inject.Inject

class CategoriesRepository  @Inject constructor(
        private val remoteDataSource: CategoriesRemoteDataSource,
        private val localDataSource: CategoriesDao
) {
    fun getCategories() = performGetOperation(
            databaseQuery = { localDataSource.getCategories() },
            networkCall = { remoteDataSource.getCategories() },
            saveCallResult = { localDataSource.insertAll(it.data) }
    )
}
