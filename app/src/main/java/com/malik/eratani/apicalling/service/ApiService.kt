package com.malik.eratani.apicalling.service

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

object ApiService {
    val getClient = Retrofit.Builder()
        .baseUrl("https://gorest.co.in/public/v2/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(UtilsApi.gsonConverter)
        .client(UtilsApi.client)
        .build()
        .create(ApiInterface::class.java)
}