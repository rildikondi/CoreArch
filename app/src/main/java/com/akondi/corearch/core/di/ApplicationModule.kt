package com.akondi.corearch.core.di

import android.content.Context
import com.akondi.corearch.BuildConfig
import com.akondi.corearch.features.materials.domain.repository.MaterialsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule() {

    @Provides
    @Singleton
    fun provideApplicationContext(@ApplicationContext appContext: Context): Context = appContext

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.geogebra.org/v1.0/search/")
            .client(createClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createClient(): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor =
                HttpLoggingInterceptor().apply { this.level = HttpLoggingInterceptor.Level.BASIC }
            okHttpClientBuilder.addInterceptor(loggingInterceptor)
        }
        return okHttpClientBuilder.build()
    }

    @Provides
    @Singleton
    fun provideMaterialsRepository(dataSource: MaterialsRepository.Network): MaterialsRepository =
        dataSource
}