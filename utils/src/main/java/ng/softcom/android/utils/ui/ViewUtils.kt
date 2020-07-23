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

import android.view.View
import android.widget.EditText

var View.visible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if(value) View.VISIBLE else View.INVISIBLE
    }

fun View.gone() {
    visibility = View.GONE
}

fun View.hide() {
    visibility = View.INVISIBLE
}

fun View.show() {
    visibility = View.VISIBLE
}


fun View.isShowing() = visibility == View.VISIBLE

val <T : EditText> T.stringText get() = text.toString().trim()