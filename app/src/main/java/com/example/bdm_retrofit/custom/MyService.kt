package com.example.bdm_retrofit.custom

import com.example.bdm_retrofit.model.MyModel
import retrofit2.Call
import retrofit2.http.GET

interface MyService {
    @GET("posts")
    fun getPosts(): Call<List<MyModel>>
}