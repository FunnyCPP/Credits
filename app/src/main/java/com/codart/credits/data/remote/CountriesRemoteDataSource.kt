package com.codart.credits.data.remote

import javax.inject.Inject

class CountriesRemoteDataSource @Inject constructor(
    private val countriesService: CountriesService
): BaseDataSource() {
    suspend fun getCountries() = getResult { countriesService.getCountries() }
}