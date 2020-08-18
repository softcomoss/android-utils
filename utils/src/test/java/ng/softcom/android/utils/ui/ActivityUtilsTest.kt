package ng.softcom.android.utils.ui

import androidx.test.core.app.ActivityScenario
import ng.softcom.android.utils.R
import ng.softcom.android.utils.test.TestActivity
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ActivityUtilsTest {

    @Test
    fun findNavControllerFromFragmentContainer_returnsNavController() {
        val scenario = ActivityScenario.launch(TestActivity::class.java)
        scenario.onActivity {
            it.findNavControllerFromFragmentContainer(R.id.fragment_nav_host)
        }
    }

    @Test(expected = IllegalStateException::class)
    fun findNavControllerFromFragmentContainer_throwsError() {
        val scenario = ActivityScenario.launch(TestActivity::class.java)
        scenario.onActivity {
            it.findNavControllerFromFragmentContainer(R.id.fragment_plain)
        }
    }

}