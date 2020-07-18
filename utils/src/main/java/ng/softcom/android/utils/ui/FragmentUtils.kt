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
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar

/**
 * Get a view model from the view model factory.
 *
 * @param T The view model class.
 * @param viewModelFactory The view model factory.
 *
 * @return The view model.
 */
inline fun <reified T : ViewModel> Fragment.obtainViewModel(viewModelFactory: ViewModelProvider.Factory) =
    ViewModelProviders.of(this, viewModelFactory).get(T::class.java)

/**
 * Show a snack bar in a fragment.
 *
 * @param rootView the view to anchor the snack bar on.
 * @param text the string to display on the snack bar.
 * @param isError whether or not the snack bar is displaying an error.
 * @param duration the snack bar duration type.
 */
fun Fragment.showSnackBar(
    rootView: View,
    text: String,
    isError: Boolean = false,
    duration: Int = Snackbar.LENGTH_SHORT
) = requireContext().showSnackBar(rootView, text, isError, duration)

/**
 * Show a toast in a fragment.
 *
 * @param message the string to display in the toast.
 * @param length the toast length tye.
 */
fun Fragment.showToast(message: String, length: Int = Toast.LENGTH_SHORT) =
    requireContext().showToast(message, length)

/**
 * Create a new alert dialog in a fragment.
 *
 * @param title the optional title of the dialog.
 * @param message the optional message in th dialog
 * @param block block of code to run on the dialog before creating it.
 *
 * @return the created dialog
 */
fun Fragment.createDialog(
    title: String? = null,
    message: String? = null,
    block: AlertDialog.Builder.() -> Unit = {}
): AlertDialog = requireContext().createDialog(title, message, block)

/**
 * Create and show an alert dialog in a fragment.
 *
 * @param title the optional title of the dialog.
 * @param message the optional message in th dialog
 * @param block block of code to run on the dialog before creating and showing it.
 */
fun Fragment.showDialog(
    title: String? = null,
    message: String? = null,
    block: AlertDialog.Builder.() -> Unit = {}
) = createDialog(title, message, block).show()

/**
 * Create an intent for starting an activity from the context of a fragment.
 *
 * @param T the activity class.
 * @param block block of code to run on the intent.
 *
 * @return the intent for starting the activity.
 */
inline fun <reified T : Activity> Fragment.createIntent(block: Intent.() -> Unit = {}): Intent =
    requireContext().createIntent<T>(block)
