package com.codart.credits.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.codart.credits.data.entities.Category

@Database(entities = [Category::class], version = 1, exportSchema = false)
abstract class CategoriesDatabase: RoomDatabase() {

    abstract fun categoriesDao(): CategoriesDao

    companion object {
        @Volatile private var instance: CategoriesDatabase? = null

        fun getDatabase(context: Context): CategoriesDatabase =
                instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
                Room.databaseBuilder(appContext, CategoriesDatabase::class.java, "categories")
                        .fallbackToDestructiveMigration()
                        .build()
    }
}