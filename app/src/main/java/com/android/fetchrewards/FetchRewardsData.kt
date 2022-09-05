package com.android.fetchrewards

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// Get json file
interface FetchRewardsData {
    @GET(FETCH_REWARDS_FILE_NAME)
    suspend fun fetchItems(): List<FetchRewardsModel>

    companion object {
        val network by lazy {
            Retrofit.Builder()
                .baseUrl(FETCH_REWARDS_FILE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FetchRewardsData::class.java)
        }
    }
}

// constants
const val FETCH_REWARDS_FILE_NAME = "hiring.json"
const val FETCH_REWARDS_FILE_URL = "https://fetch-hiring.s3.amazonaws.com/"