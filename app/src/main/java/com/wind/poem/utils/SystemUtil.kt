package com.wind.poem.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context

/**
 * 系统提供的服务功能：剪切板，定时器等
 * Created by Jiwei Yuan on 18-7-12.
 */
object SystemUtil {

    fun copyToClipBoard(data: String) {
        val mgr = ApplicationProvider.provide().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("poemClip", data)
        mgr.primaryClip = clipData
    }

    fun getPlainClipData(): String? {
        val mgr = ApplicationProvider.provide().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        if (mgr.hasPrimaryClip()) {
            val clipData = mgr.primaryClip
            clipData?.let {
                return (clipData.getItemAt(0) as ClipData.Item).text as String
            }
        }
        return null
    }

    fun clearClipBoard() {
        copyToClipBoard("")
    }
}