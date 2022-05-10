package com.malik.eratani.searchword

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import com.malik.eratani.databinding.ActivitySearchStringBinding

class SearchStringActivity : AppCompatActivity() {

    private val dataString = arrayListOf<String>("Mango", "Banana", "Rice", "Cooker", "Farm", "Agro")
    lateinit var binding : ActivitySearchStringBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchStringBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitle("Pencarian Kata")
        binding.textArrayString.setText(dataString.toString())
        binding.edtSearch.setOnEditorActionListener { textView, i, keyEvent ->
            if (i == EditorInfo.IME_ACTION_DONE){
                val value = binding.edtSearch.text.toString()
                Log.d("value", value)
                searchFun(value)
                true
            } else{
                false
            }

        }
    }

    private fun searchFun(value: String) {
        val result = dataString.filter { it.lowercase() in value.lowercase() }
        if (result.size > 0){
            binding.textResultData.apply {
                setText("Data ditemukan : $result")
                setTextColor(Color.parseColor("#00FF00"))
            }

        } else {
            binding.textResultData.apply {
                setText("Data tidak ditemukan : []")
                setTextColor(Color.parseColor("#FF0000"))
            }
        }
    }
}