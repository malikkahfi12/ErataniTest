package com.malik.eratani.apicalling.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.malik.eratani.apicalling.adapter.DataTableAdapter
import com.malik.eratani.apicalling.repository.DataRepository
import com.malik.eratani.apicalling.resource.Resource
import com.malik.eratani.databinding.ActivityApiCallingBinding

class ApiCallingActivity : AppCompatActivity() {
    lateinit var binding: ActivityApiCallingBinding
    private lateinit var viewModel: ApiCallingViewModel
    private lateinit var adapter : DataTableAdapter
    private val dataRepository = DataRepository()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiCallingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = DataTableAdapter(applicationContext)
        initViewModel()
        observe()
        initAdapter()
    }

    private fun initAdapter() {
        binding.apply {
            rcViewAdapter.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
            rcViewAdapter.adapter = adapter
        }
    }

    private fun initViewModel(){
        val viewModelFactory = ApiCallingViewModel.ApiCallingModelFactory(dataRepository)
        viewModel = ViewModelProvider(this, viewModelFactory)[ApiCallingViewModel::class.java]
    }

    private fun observe(){
        viewModel.observeDataUser().observe(this, Observer {
            when(it){
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    adapter.submitList(it.data)
                }
                is Resource.DataError -> {

                }
            }
        })
    }
}