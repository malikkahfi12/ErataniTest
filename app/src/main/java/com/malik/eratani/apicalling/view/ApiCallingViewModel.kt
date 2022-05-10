package com.malik.eratani.apicalling.view

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.malik.eratani.apicalling.model.DataTable
import com.malik.eratani.apicalling.repository.DataRepository
import com.malik.eratani.apicalling.resource.Resource
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

class ApiCallingViewModel(val repository : DataRepository) : ViewModel() {
    private val dataUserTable : MutableLiveData<Resource<List<DataTable>>> = MutableLiveData()

    init {
        getDataUser()
    }

    @SuppressLint("CheckResult")
    fun getDataUser(){
        dataUserTable.postValue(Resource.Loading())
        repository.getDataTable()
            .subscribeOn(Schedulers.io())
            .subscribe({ resource ->
                dataUserTable.postValue(Resource.Success(data = resource))
            }, {
                dataUserTable.postValue(Resource.DataError(errorCode = 1))
            })
    }

    fun observeDataUser() : MutableLiveData<Resource<List<DataTable>>>{
        return dataUserTable
    }

    class ApiCallingModelFactory(private val dataRepository : DataRepository) : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ApiCallingViewModel::class.java)){
                return ApiCallingViewModel(dataRepository) as T
            }
            throw Exception("Unknown ViewModel Class")
        }
    }
}