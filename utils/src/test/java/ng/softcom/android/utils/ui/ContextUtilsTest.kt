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

import android.content.Context
import android.graphics.Color
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import ng.softcom.android.utils.test.TestActivity
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ContextUtilsTest {

    @Test
    fun createDialog_isShown() {
        val scenario = ActivityScenario.launch(TestActivity::class.java)
        scenario.onActivity {
            val dialog = it.createDialog()
            dialog.show()

            assert(dialog.isShowing)
        }
    }

    @Test
    fun getColorCompat_correctColor() {
        val context: Context = ApplicationProvider.getApplicationContext()

        val actualColor = context.getColorCompat(android.R.color.white)

        val expectedColor = Color.WHITE

        assert(actualColor == expectedColor)
    }
}
