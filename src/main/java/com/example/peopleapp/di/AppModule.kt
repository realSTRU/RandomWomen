package com.example.peopleapp.di

import com.example.peopleapp.data.remote.api.RandomPersonApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }


    @Provides
    @Singleton
    fun provideRandomPersonApi(moshi: Moshi): RandomPersonApi {
        return Retrofit.Builder()
            .baseUrl("https://randomuser.me/api/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(RandomPersonApi::class.java)
    }


}