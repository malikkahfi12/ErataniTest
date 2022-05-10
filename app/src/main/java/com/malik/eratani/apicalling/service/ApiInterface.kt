package com.malik.eratani.apicalling.service

import com.malik.eratani.apicalling.model.DataTable
import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {
    @GET("users")
    fun getDataUser() : Single<List<DataTable>>
}