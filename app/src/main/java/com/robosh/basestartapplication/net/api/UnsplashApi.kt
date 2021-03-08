package com.robosh.basestartapplication.net.api

import com.robosh.basestartapplication.net.model.PhotoResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers

interface UnsplashApi {

    private companion object {
        const val ACCESS_KEY = "AI77QwuXt1Nfhm9zi_LDk5ll2ndPRpVkYZMrmOsIwGI"
        const val AUTHORIZATION_HEADER = "Authorization: Client-ID $ACCESS_KEY"
    }

    @GET("photos/")
    @Headers(AUTHORIZATION_HEADER)
    fun getPhotos(): Observable<List<PhotoResponse>>
}