package com.codart.credits.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.codart.credits.data.entities.Category

@Dao
interface CategoriesDao {
    @Query("SELECT * FROM categories")
    fun getCategories() : LiveData<List<Category>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(characters: List<Category>)
}