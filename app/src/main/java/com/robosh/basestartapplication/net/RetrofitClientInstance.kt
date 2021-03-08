package com.robosh.basestartapplication.net

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientInstance {

    private lateinit var retrofit: Retrofit
    private const val BASE_URL = "https://api.unsplash.com/"

    val retrofitInstance: Retrofit
        get() {
            if (this::retrofit.isInitialized.not()) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
}
