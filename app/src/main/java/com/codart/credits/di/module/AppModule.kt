package com.codart.credits.di.module

import android.content.Context
import com.codart.credits.data.local.*
import com.codart.credits.data.remote.*
import com.codart.credits.data.repository.CategoriesRepository
import com.codart.credits.data.repository.CountriesRepository
import com.codart.credits.data.repository.OffersRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit = Retrofit.Builder()
        .baseUrl("https://zaim.codart.pro/api/rest/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideCountriesService(retrofit: Retrofit): CountriesService = retrofit.create(CountriesService::class.java)

    @Singleton
    @Provides
    fun provideCountriesRemoteDataSource(countriesService: CountriesService) = CountriesRemoteDataSource(countriesService)

    @Singleton
    @Provides
    fun provideCountriesDatabase(@ApplicationContext appContext: Context) = CountriesDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideCountriesDao(db: CountriesDatabase) = db.countriesDao()

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: CountriesRemoteDataSource,
                          localDataSource: CountriesDao) =
        CountriesRepository(remoteDataSource, localDataSource)

    @Provides
    fun provideCategoriesService(retrofit: Retrofit): CategoriesService = retrofit.create(CategoriesService::class.java)

    @Singleton
    @Provides
    fun provideCategoriesRemoteDataSource(categoriesService: CategoriesService) = CategoriesRemoteDataSource(categoriesService)

    @Singleton
    @Provides
    fun provideCategoriesDatabase(@ApplicationContext appContext: Context) = CategoriesDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideCategoriesDao(db: CategoriesDatabase) = db.categoriesDao()

    @Singleton
    @Provides
    fun provideCategoriesRepository(remoteDataSource: CategoriesRemoteDataSource,
                          localDataSource: CategoriesDao) =
            CategoriesRepository(remoteDataSource, localDataSource)

    @Provides
    fun provideOffersService(retrofit: Retrofit): OffersService = retrofit.create(OffersService::class.java)

    @Singleton
    @Provides
    fun provideOffersRemoteDataSource(offersService: OffersService) = OffersRemoteDataSource(offersService)

    @Singleton
    @Provides
    fun provideOffersDatabase(@ApplicationContext appContext: Context) = OffersDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideOffersDao(db: OffersDatabase) = db.offersDao()

    @Singleton
    @Provides
    fun provideOffersRepository(remoteDataSource: OffersRemoteDataSource,
                                    localDataSource: OffersDao) =
            OffersRepository(remoteDataSource, localDataSource)

}