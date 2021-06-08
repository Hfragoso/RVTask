package com.example.encoratask.data.network

import com.example.encoratask.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RickMortyService {
    private var rickMortyApi: RickMortyApi? = null

    private fun okHttpClient(): OkHttpClient.Builder {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.connectTimeout(1, TimeUnit.MINUTES)
        okHttpClient.readTimeout(1, TimeUnit.MINUTES)
        okHttpClient.writeTimeout(1, TimeUnit.MINUTES)

        when {
            BuildConfig.DEBUG -> {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                okHttpClient.addInterceptor(logging)
            }
        }

        return okHttpClient
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(RickMortyApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient().build())
            .build()
    }

    fun getClient(): RickMortyApi {
        when (rickMortyApi) {
            null -> rickMortyApi = getRetrofit().create(RickMortyApi::class.java)
        }

        return rickMortyApi as RickMortyApi
    }
}