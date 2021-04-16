package com.codart.credits.ui.countries


import androidx.lifecycle.ViewModel
import com.codart.credits.data.repository.CountriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
     repository: CountriesRepository
) : ViewModel()
 {

    val countries = repository.getCountries()
}