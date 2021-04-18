package com.codart.credits.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
//import com.codart.credits.data.entities.Attribute
//import com.codart.credits.data.entities.AttributeGroup
import com.codart.credits.data.entities.Offer
import com.codart.credits.data.entities.OfferCategory

@Database(entities = [Offer::class], version = 1, exportSchema = false)
abstract class OffersDatabase: RoomDatabase() {

    abstract fun offersDao(): OffersDao

    companion object {
        @Volatile private var instance: OffersDatabase? = null

        fun getDatabase(context: Context): OffersDatabase =
                instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
                Room.databaseBuilder(appContext, OffersDatabase::class.java, "offers")
                        .fallbackToDestructiveMigration()
                        .build()
    }
}