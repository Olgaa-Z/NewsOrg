package com.sourcey.materiallogindemo.api

import com.sourcey.materiallogindemo.model.article.ResponseArticles
import com.sourcey.materiallogindemo.model.source.ResponseSource
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

//    @GET("top-headlines/sources?category=business")

    @GET("top-headlines/sources")
    fun getAllSources(
        @Query("category") category : String ,
        @Query("apiKey") apiKey : String = "e604f4b947784474a99a6dcecce2599e"
    ) : Call<ResponseSource>

    @GET("top-headlines")
    fun getAllArticles(
        @Query("sources") sources : String ,
        @Query("apikey") apikey : String = "e604f4b947784474a99a6dcecce2599e"
    ) : Call<ResponseArticles>

    @GET("everything")
    fun searchNews(
        @Query("q") searchQuery: String,
        @Query("page") pageNumber: Int = 1,
        @Query("apiKey") apiKey: String = "e604f4b947784474a99a6dcecce2599e"
    ): Call<ResponseArticles>
}