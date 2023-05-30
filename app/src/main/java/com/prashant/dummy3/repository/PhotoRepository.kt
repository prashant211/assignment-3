package com.prashant.dummy3.repository

import com.prashant.dummy3.data.Photo
import com.prashant.dummy3.remote.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PhotoRepository {
    private val apiService: ApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }

    suspend fun getPhotos(): List<Photo> {
        return apiService.getPhotos()
    }
}
