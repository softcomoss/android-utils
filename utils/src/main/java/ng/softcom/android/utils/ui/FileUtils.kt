/*
 * Copyright 2020 Softcom Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ng.softcom.android.utils.ui

import java.io.File

/**
 * Gets the file size unit
 * e.g 10.7mb, 2.4kb
 */
fun File.getFileSizeInSIUnits(): String {
    val byte = 1024.0
    var unit = ""
    var numOfRecursiveTask = 0//0 for byte

    fun calculateSize(input: Double): Double {
        val nextInput = input / byte
        if (input < byte) {
            unit = "byte"
            return input
        }

        if (nextInput == 0.0 || nextInput < byte || nextInput == byte) {
            numOfRecursiveTask++
            return nextInput
        }

        numOfRecursiveTask++
        return calculateSize(nextInput)
    }

    val standardSize = calculateSize(length().toDouble())
    val fileSize = String.format("%.2f", standardSize).toDouble()

    unit = when (numOfRecursiveTask) {
        1 -> "KB"
        2 -> "MB"
        3 -> "GB"
        4 -> "TB"
        else -> "too large"
    }

    return "$fileSize$unit"
}