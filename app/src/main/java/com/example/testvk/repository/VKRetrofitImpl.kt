package com.example.testvk.repository

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private val url = "https://api.vk.com/method/"
private val urlUsers = "https://api.github.com/"

val gsonVK = GsonBuilder().setLenient()
    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
    .excludeFieldsWithoutExposeAnnotation()
    .create()

val retrofitVK = Retrofit.Builder()
    .baseUrl(url)
    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    .addConverterFactory(GsonConverterFactory.create(gsonVK))
    .client(createOkHttpClient(FrendsApiInterceptor()))
    .build()

val apiVK = retrofitVK.create(IDataSource::class.java)
val apiVK2 = retrofitVK.create(IDataSourceFollewers::class.java)

private fun createOkHttpClient(interceptor: Interceptor): OkHttpClient {
    val httpClient = OkHttpClient.Builder()
    httpClient.addInterceptor(interceptor)

    httpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
    return httpClient.build()
}


