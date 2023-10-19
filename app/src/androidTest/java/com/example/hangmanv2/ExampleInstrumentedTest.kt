package com.example.hangmanv2


import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.CoreMatchers
import org.junit.Test
import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ButtonClickTest {

    @Test
    fun testButtonClickAndDisable() {
        val tar = ActivityScenario.launch(MainActivity::class.java)
        Espresso.onView(ViewMatchers.withId(R.id.Abutton)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.Abutton))
            .check(ViewAssertions.matches(ViewMatchers.isNotClickable()))
    tar.close()
    }
}
