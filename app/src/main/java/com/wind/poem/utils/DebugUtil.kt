package com.wind.poem.utils

import android.os.Environment
import java.io.File
import java.io.FileOutputStream
import java.io.PrintStream

/**
 * Created by Jiwei Yuan on 18-7-16.
 */
object DebugUtil {
    fun logtoFile(e: Throwable) {
        val f = File(Environment.getExternalStorageDirectory().absolutePath + "/bug.txt")
        if (!f.exists()) {
            f.createNewFile()
        }

        val outputStream = FileOutputStream(f)
        e.printStackTrace(PrintStream(outputStream))
    }
}
