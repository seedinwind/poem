package com.wind.poem.net.service

import com.wind.poem.models.Poem
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface ContentService{

    @POST("/content/poem/title")
    fun findPoemsByTitle(@Query("title")title:String ): Call<List<Poem>>

    @POST("/content/poem/author")
    fun findPoemsByAuthor(@Query("author")author:String ): Call<List<Poem>>
}