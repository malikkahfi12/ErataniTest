package com.malik.eratani.apicalling.repository

import com.malik.eratani.apicalling.model.DataTable
import io.reactivex.Single

interface IDataRepository {
    fun getDataTable() : Single<List<DataTable>>
}