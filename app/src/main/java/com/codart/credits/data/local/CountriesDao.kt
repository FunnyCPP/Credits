package com.codart.credits.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.codart.credits.data.entities.Country

@Dao
interface CountriesDao {
    @Query("SELECT * FROM countries")
    fun getCountries() : LiveData<List<Country>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(characters: List<Country>)

}