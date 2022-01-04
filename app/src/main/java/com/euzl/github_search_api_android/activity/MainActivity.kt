package com.euzl.github_search_api_android.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.euzl.github_search_api_android.R
import com.euzl.github_search_api_android.adapter.RepositoryAdapter
import com.euzl.github_search_api_android.databinding.ActivityMainBinding
import com.euzl.github_search_api_android.dto.SearchResponse
import com.euzl.github_search_api_android.service.RepositoryService
import com.euzl.github_search_api_android.util.RetrofitCallback

private const val TAG = "MainActivity_컬리"
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var repositoryAdapter: RepositoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.searchEditText.setOnEditorActionListener { _, id, _ ->
            if (id == EditorInfo.IME_ACTION_SEARCH) {
                if (binding.searchEditText.text.toString() == "") {
                    Toast.makeText(this, "검색어를 입력해 주세요.", Toast.LENGTH_SHORT).show()
                    false
                }

                search(binding.searchEditText.text.toString())
                true
            }
            false
        }
    }

    private fun search(searchWord: String) {
        RepositoryService().getRepositoryList(searchWord, SearchCallback())
    }

    inner class SearchCallback : RetrofitCallback<SearchResponse> {
        override fun onSuccess(code: Int, res: SearchResponse) {
            Log.d(TAG, "onSuccess: ${res.totalCount}")

            if (res.items != null) {
                repositoryAdapter = RepositoryAdapter(this@MainActivity, res.items)

                binding.recyclerView.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = repositoryAdapter
                }
            }
        }

        override fun onError(t: Throwable) {
            Log.d(TAG, "onError: ${t.message}")
        }

        override fun onFailure(code: Int) {
            Log.d(TAG, "onFailure: Error code $code")
        }
    }
}