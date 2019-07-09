package com.johnnylee.krypt_lizt.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.johnnylee.krypt_lizt.R
import com.johnnylee.krypt_lizt.databinding.ActivityMainBinding
import com.johnnylee.krypt_lizt.ui.main.adapter.MarketsAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by lazy {  ViewModelProviders.of(this).get(MainViewModel::class.java)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        binding.mainViewModel = viewModel

        configuraRecyclerView()
    }

    private fun configuraRecyclerView() {
        binding.rvMarkets.adapter = MarketsAdapter(mutableListOf())
        with(binding.rvMarkets) {
            layoutManager = LinearLayoutManager(applicationContext)
            setHasFixedSize(true)
        }
    }

}
