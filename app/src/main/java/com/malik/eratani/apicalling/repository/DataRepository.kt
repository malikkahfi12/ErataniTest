package com.malik.eratani.apicalling.repository

import com.malik.eratani.apicalling.model.DataTable
import com.malik.eratani.apicalling.service.ApiService
import io.reactivex.Single

class DataRepository() : IDataRepository {
    override fun getDataTable(): Single<List<DataTable>> {
        return ApiService.getClient.getDataUser()
    }
}