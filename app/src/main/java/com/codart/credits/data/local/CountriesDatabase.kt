package com.codart.credits.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.codart.credits.data.entities.Country

@Database(entities = [Country::class], version = 1, exportSchema = false)
abstract class CountriesDatabase : RoomDatabase() {

    abstract fun countriesDao(): CountriesDao

    companion object {
        @Volatile private var instance: CountriesDatabase? = null

        fun getDatabase(context: Context): CountriesDatabase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, CountriesDatabase::class.java, "countries")
                .fallbackToDestructiveMigration()
                .build()
    }

}