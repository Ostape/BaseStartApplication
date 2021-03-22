package com.robosh.basestartapplication.net.api

import com.robosh.basestartapplication.net.model.PhotoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface UnsplashApi {

    private companion object {
        const val ACCESS_KEY = "AI77QwuXt1Nfhm9zi_LDk5ll2ndPRpVkYZMrmOsIwGI"
        const val AUTHORIZATION_HEADER = "Authorization: Client-ID $ACCESS_KEY"
    }

    @GET("photos/")
    @Headers(AUTHORIZATION_HEADER)
    suspend fun getPhotos(): Response<List<PhotoResponse>>
}