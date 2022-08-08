package com.example.testvk.repository

import com.example.testvk.data.ResponseFollowers
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IDataSource {
    @GET("users.getFollowers")
    fun getFollowers(
        @Query("user_id") user_id: String,
        @Query("offset") offset: String,
        @Query("count") count: String,
        @Query("name_case") name_case: String,
        @Query("fields") fields: String,
        @Query("access_token") access_token: String,
        @Query("v") v: String
    ): Single<List<ResponseFollowers>>


}
