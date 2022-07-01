package com.example.recyclerviewretrofitcoroutines

import retrofit2.Response
import retrofit2.http.GET

interface JsonApi {
   @GET("posts")
   suspend fun getPost():Response<List<JsonApiResponse>>
}