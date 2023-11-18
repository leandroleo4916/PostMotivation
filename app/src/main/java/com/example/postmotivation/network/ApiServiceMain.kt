package com.example.postmotivation.network

import com.example.postmotivation.dataclass.Page
import com.example.postmotivation.dataclass.Pagination
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServiceMain {
    @GET("curated/?page={page}&per_page=10")
    fun getImages(
        @Path("page") page: Int
    ): Response<Page>
}

interface ListPhoto {
    @GET("search?query=tiger&per_page=3")
    fun getPhotoApi(): Call<Pagination>
}