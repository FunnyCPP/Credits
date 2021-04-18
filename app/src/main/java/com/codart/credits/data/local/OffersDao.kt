package com.codart.credits.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.codart.credits.data.entities.Offer

@Dao
interface OffersDao {
    @Query("SELECT * FROM offers WHERE country_id =:country_id")
    fun getOffers(country_id: Int) : LiveData<List<Offer>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(characters: List<Offer>)
}