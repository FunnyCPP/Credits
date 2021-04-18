package com.codart.credits.data.remote

import javax.inject.Inject

class CategoriesRemoteDataSource @Inject constructor(
        private val categoriesService: CategoriesService
): BaseDataSource() {
    suspend fun getCategories() = getResult { categoriesService.getCategories() }
}