package com.wind.poem.net

import com.wind.poem.models.JsonResult
import io.reactivex.functions.Consumer

/**
 * Created by Jiwei Yuan on 18-7-4.
 */
class NextConsumer<T>(private val listener: NextListener<T>, private val errorListener: ErrorListener) : Consumer<JsonResult<T>> {
    /**
     * Consume the given value.
     * @param t the value
     * @throws Exception on error
     */
    override fun accept(t: JsonResult<T>) {
        if (t.resCode == 0) {
            if (t.data != null) {
                listener.onDataSuccess(t.data)
            } else {
                errorListener.onDataError()
            }
        } else {
            listener.onDataFail(t.resCode, t.error)
        }

    }

}

abstract class NextListener<T> {
    open fun onDataSuccess(data: T) {}
    open fun onDataFail(code: Int, msg: String) {}
}