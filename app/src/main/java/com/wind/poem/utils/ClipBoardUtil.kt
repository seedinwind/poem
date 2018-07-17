package com.wind.poem.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context

/**
 * Created by Jiwei Yuan on 18-7-16.
 */
object ClipBoardUtil {
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