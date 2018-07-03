package com.wind.poem.models

import java.util.*

/**
 * Created by Jiwei Yuan on 18-7-3.
 */
class JsonResult<T> {

    var resCode: Int = 0

    val data: T? = null

    var error: String = ""

    override fun toString(): String {
        return "JsonResult{" +
                "resCode=" + resCode +
                ", data=" + data +
                ", error='" + error + '\''.toString() +
                '}'.toString()
    }


}