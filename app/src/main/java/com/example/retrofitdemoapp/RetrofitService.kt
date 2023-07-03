package com.example.retrofitdemoapp

import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {

    @GET("/albums")
    suspend fun getAlbumsList ():Response<AlbumsList>


}