package fr.zzi.androidarchitecture.feature.daylist.ui


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import fr.zzi.androidarchitecture.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainFeaturesTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(DayListActivity::class.java)

    @Test
    fun `checkMainScreensCanRun`() {
        //wait for items to be displayed
        Thread.sleep(2000)

        val cardView = onView(
            allOf(
                withId(R.id.fragment_day_list_recycler),
                childAtPosition(
                    withId(R.id.activity_day_list_layout),
                    0
                )
            )
        )
        cardView.perform(click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
