package com.example.bdm_retrofit.helper

import com.example.bdm_retrofit.custom.MyService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyRepository {
    fun create(): MyService {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
        return retrofit.create(MyService::class.java)
    }
}