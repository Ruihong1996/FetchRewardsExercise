package com.android.fetchrewards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var dataAdapter: FetchRewardsDataRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        showDataList()
    }

    private fun showDataList() {
        val viewModel = ViewModelProvider(this).get(FetchRewardsViewModel::class.java)
        val dataList = mutableListOf<FetchRewardsModel>()

        viewModel.fetchItems()
        viewModel.fetchDataList.observe(this) {
            for (data in it) {
                if (data.name !== null && data.name.isNotEmpty()) {
                    dataList.add(data)
                }
            }
            val sortedList =
                dataList.sortedWith(compareBy(FetchRewardsModel::listId, FetchRewardsModel::name))
            dataAdapter.populate(sortedList)
        }
    }

    private fun initView() {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            dataAdapter = FetchRewardsDataRecyclerAdapter()
            adapter = dataAdapter
        }
    }
}