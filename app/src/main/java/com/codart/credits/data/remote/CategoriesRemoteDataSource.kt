package com.codart.credits.data.remote

import javax.inject.Inject

class CategoriesRemoteDataSource @Inject constructor(
        private val categoriesService: CategoriesService
): BaseDataSource() {
    suspend fun getCategories(country_id: Int) = getResult { categoriesService.getCategories(country_id) }
}