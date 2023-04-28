package com.example.pagging3demo.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.pagging3demo.databinding.ActivityMainBinding
import com.example.pagging3demo.ui.adapter.LoaderAdapter
import com.example.pagging3demo.ui.adapter.QuoteListAdapter
import com.example.pagging3demo.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    lateinit var quoteListAdapter: QuoteListAdapter
    private lateinit var binding: ActivityMainBinding  //defining the binding class


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //initializing the binding class
        setContentView(binding.root) // we now set the contentview as the binding.root
        setUpViews()
        setUpObservers()
    }

    private fun setUpObservers() {
        mainViewModel.list.observe(this, Observer {
            quoteListAdapter.submitData(lifecycle, it)
        })
    }

    private fun setUpViews() {
        quoteListAdapter = QuoteListAdapter()
        binding.rvQuoteList.apply {
            adapter = quoteListAdapter.withLoadStateHeaderAndFooter(LoaderAdapter(),LoaderAdapter())
        }

    }
}