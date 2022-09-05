package com.android.fetchrewards

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class FetchRewardsViewModel : ViewModel() {
    val fetchDataList: MutableLiveData<List<FetchRewardsModel>> = MutableLiveData()
    fun fetchItems() {
        viewModelScope.launch {
            fetchDataList.value = FetchRewardsData.network.fetchItems()
        }
    }
}
