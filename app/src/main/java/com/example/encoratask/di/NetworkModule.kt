package com.example.encoratask.di

import com.example.encoratask.repository.APICharacterImpl
import com.example.encoratask.repository.network.APICharacter
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun getServiceAPI(): APICharacter {
        return Retrofit.Builder()
            .baseUrl(APICharacter.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(APICharacter::class.java)
    }

    @Provides
    fun getAPI(service: APICharacter): APICharacterImpl{
        return APICharacterImpl(service)
    }
}