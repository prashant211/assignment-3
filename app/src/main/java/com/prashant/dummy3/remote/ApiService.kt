package com.prashant.dummy3.remote

import com.prashant.dummy3.data.Photo
import retrofit2.http.GET

interface ApiService {
    @GET("photos")
    suspend fun getPhotos(): List<Photo>
}
