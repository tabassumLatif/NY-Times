package com.quantum.nytimes.di

import com.quantum.nytimes.BuildConfig.BASE_URL
import com.quantum.nytimes.api.RetrofitAPI
import com.quantum.nytimes.repository.NyTimeRepository
import com.quantum.nytimes.repository.NyTimeRepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun injectRetrofitAPI() : RetrofitAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL).build().create(RetrofitAPI::class.java)
    }

    @Singleton
    @Provides
    fun injectNormalRepo(api: RetrofitAPI) = NyTimeRepository(api) as NyTimeRepositoryInterface


}