package com.wind.poem.net

import com.google.gson.JsonIOException
import io.reactivex.functions.Consumer
import retrofit2.HttpException


/**
 * Created by Jiwei Yuan on 18-7-4.
 */
 class ErrorConsumer<T>(private val listener: ErrorListener) : Consumer<T> {
    /**
     * Performs this operation on the given argument.
     *
     * @param t the input argument
     */


    override fun accept(t: T) {
        if (t is HttpException) {
            val ex = t as HttpException
            val code = ex.code()
            when (code) {
                401 ->
                    listener.unauthenticated()
                in 400..500 ->
                    listener.clientError(code)
                in 500..600 ->
                    listener.serverError(code)
                else ->
                    listener.httpError(code)
            }
        }else if(t is JsonIOException){
            //数据解析错误

        }else if(t is KotlinNullPointerException){
            //NPE错误
        }else if(t is RuntimeException){
            //运行时错误
        }else{

        }
    }



}

abstract  class ErrorListener{
    open fun httpError(code: Int) {
    }

    open fun serverError(code: Int) {
        httpError(code)
    }

    open fun clientError(code: Int) {
        httpError(code)
    }

    open fun unauthenticated() {}
}