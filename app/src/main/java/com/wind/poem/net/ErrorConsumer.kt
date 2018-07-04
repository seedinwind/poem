package com.wind.poem.net

import com.google.gson.JsonIOException
import com.wind.poem.BuildConfig
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
        } else if (t is JsonIOException) {
            //数据解析错误

        } else if (t is KotlinNullPointerException) {
            //NPE错误
        } else if (t is RuntimeException) {
            //运行时错误
        } else {

        }

        debug(t as Throwable)
    }

    fun debug(t: Throwable) {
        if (BuildConfig.DEBUG) {
            t.printStackTrace()
        }
    }
}

abstract class ErrorListener {
    /**
     * 处理http错误码
     */
    open fun httpError(code: Int) {
    }

    /**
     * 处理http错误码--服务端错误
     */
    open fun serverError(code: Int) {
        httpError(code)
    }

    /**
     * 处理http错误码--客户端错误
     */
    open fun clientError(code: Int) {
        httpError(code)
    }

    /**
     * 登录认证错误401
     */
    open fun unauthenticated() {}

    /**
     * 服务端返回的数据体（JsonResult data为空，rescode正常）
     */
    open fun onDataError() {
        //默认实现，服务端返回数据错误
    }
}