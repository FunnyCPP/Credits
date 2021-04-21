package com.codart.credits.ui.offer_detail

import androidx.lifecycle.ViewModel
import com.codart.credits.data.repository.OfferDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OfferDetailViewModel @Inject constructor(
        val repository: OfferDetailRepository
) : ViewModel()
{

    fun getOffer(product_id: Int) = repository.getOffer(product_id)
}