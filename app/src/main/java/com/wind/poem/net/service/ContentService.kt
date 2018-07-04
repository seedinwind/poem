package com.wind.poem.net.service

import com.wind.poem.models.JsonResult
import com.wind.poem.models.Poem
import io.reactivex.Observable
import retrofit2.http.POST
import retrofit2.http.Query

interface ContentService{

    @POST("/content/poem/title")
    fun findPoemsByTitle(@Query("title")title:String ): Observable<JsonResult<List<Poem>>>

    @POST("/content/poem/author")
    fun findPoemsByAuthor(@Query("author")author:String ): Observable<JsonResult<List<Poem>>>
}