package com.codart.credits.data.repository

import com.codart.credits.data.local.CountriesDao
import com.codart.credits.data.remote.CountriesRemoteDataSource
import com.codart.credits.utils.performGetOperation
import javax.inject.Inject

class CountriesRepository @Inject constructor(
    private val remoteDataSource: CountriesRemoteDataSource,
    private val localDataSource: CountriesDao
) {
    fun getCountries() = performGetOperation(
        databaseQuery = { localDataSource.getCountries() },
        networkCall = { remoteDataSource.getCountries() },
        saveCallResult = { localDataSource.insertAll(it.data) }
    )
}