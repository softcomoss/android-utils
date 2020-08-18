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

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import ng.softcom.android.utils.R

/**
 * Show a snack bar.
 *
 * @param rootView the view to anchor the snack bar on.
 * @param text the string to display on the snack bar.
 * @param isError whether or not the snack bar is displaying an error.
 * @param duration the snack bar duration type.
 * @param backgroundColor option to override the background color of the snack bar (defaults to the
 *                        primary color of the context's theme).
 * @param textColor option to override the text color of the snack bar (defaults to [Color.WHITE]).
 */
fun Context.showSnackBar(
    rootView: View,
    text: String,
    isError: Boolean = false,
    duration: Int = Snackbar.LENGTH_SHORT,
    @ColorInt backgroundColor: Int? = null,
    @ColorInt textColor: Int = Color.WHITE
) {
    val snackBar = Snackbar.make(rootView, text, duration)
    val snackBarLayout = snackBar.view as Snackbar.SnackbarLayout
    snackBarLayout.findViewById<TextView>(com.google.android.material.R.id.snackbar_text).run {
        setTextColor(textColor)
    }

    snackBarLayout.backgroundTintList = when {
        isError -> {
            ColorStateList.valueOf(Color.RED)
        }
        backgroundColor != null -> {
            ColorStateList.valueOf(backgroundColor)
        }
        else -> {
            ColorStateList.valueOf(getPrimaryColor())
        }
    }

    snackBar.show()
}

private fun Context.getPrimaryColor(): Int {
    val typedValue = TypedValue()
    theme.resolveAttribute(R.attr.colorPrimary, typedValue, true)
    return typedValue.data
}

/**
 * Show a toast.
 *
 * @param message the string to display in the toast.
 * @param length the toast length tye.
 */
fun Context.showToast(message: String, length: Int = Toast.LENGTH_SHORT) {
    val toast = Toast.makeText(this, message, length)
    toast.setGravity(Gravity.CENTER, 0, 0)
    toast.show()
}

/**
 * Create a new alert dialog.
 *
 * @param title the optional title of the dialog.
 * @param message the optional message in th dialog
 * @param block block of code to run on the dialog before creating it.
 *
 * @return the created dialog
 */
fun Context.createDialog(
    title: String? = null,
    message: String? = null,
    block: AlertDialog.Builder.() -> Unit = {}
): AlertDialog =
    AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(message)
        .apply(block).create()

/**
 * Create and show an alert dialog.
 *
 * @param title the optional title of the dialog.
 * @param message the optional message in th dialog
 * @param block block of code to run on the dialog before creating and showing it.
 */
fun Context.showDialog(
    title: String? = null,
    message: String? = null,
    block: AlertDialog.Builder.() -> Unit = {}
) = createDialog(title, message, block).show()

/**
 * Create an intent for starting an activity from the context.
 *
 * @param T the activity class.
 * @param block block of code to run on the intent.
 *
 * @return the intent for starting the activity.
 */
inline fun <reified T : Activity> Context.createIntent(block: Intent.() -> Unit = {}): Intent {
    val intent = Intent(this, T::class.java)
    intent.block()
    return intent
}

/**
 * Backwards compatible [Context.getColor]
 */
fun Context.getColorCompat(@ColorRes id: Int) = ContextCompat.getColor(this, id)

/**
 * Checks if context has access to the permissions.
 *
 * @param permissions the permissions to check for.
 *
 * @return whether or not the context has all of the given [permissions].
 */
fun Context.hasPermissions(vararg permissions: String) = permissions.all {
    ContextCompat.checkSelfPermission(
        this,
        it
    ) == PackageManager.PERMISSION_GRANTED
}
