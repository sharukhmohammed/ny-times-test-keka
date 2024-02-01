package com.sharukh.sampletest.searchlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.sharukh.sampletest.R
import com.sharukh.sampletest.databinding.ActivitySearchListBinding

class SearchListActivity : AppCompatActivity() {

    private lateinit var viewModel: SearchListViewModel
    private lateinit var binding: ActivitySearchListBinding
    private lateinit var adapter: SearchListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[SearchListViewModel::class.java]
        adapter = SearchListAdapter()
        binding.articleList.adapter = adapter
        viewModel.listData.observe(this) {
            Log.i("SearchListActivity", "Got Response")
            adapter.setData(it)
        }

        viewModel.errorStat.observe(this) {
            Log.e("SearchListActivity", it.err.toString())
            Toast.makeText(this, it.err.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}