package com.codart.credits.ui.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.codart.credits.data.entities.Category
import com.codart.credits.data.repository.CategoriesRepository
import com.codart.credits.data.repository.CountriesRepository
import com.codart.credits.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel  @Inject constructor(
        val repository: CategoriesRepository
) : ViewModel(){

    fun  getCategories(country_id:Int): LiveData<Resource<List<Category>>> = repository.getCategories(country_id)
}