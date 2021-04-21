package com.codart.credits.ui.offers

import androidx.lifecycle.ViewModel
import com.codart.credits.data.repository.OffersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OffersViewModel  @Inject constructor(
        val repository: OffersRepository
) : ViewModel()
{

    fun getOffers(category_id: Int, country_id: Int) = repository.getOffers(category_id, country_id)
}