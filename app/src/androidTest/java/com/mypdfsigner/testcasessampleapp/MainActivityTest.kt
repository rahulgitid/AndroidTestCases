package com.mypdfsigner.testcasessampleapp

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun textNextButton_expectdCorrectQuote() {
        onView(withId(R.id.buttonNext)).perform(click())
        onView(withId(R.id.buttonNext)).perform(click())
        onView(withId(R.id.buttonNext)).perform(click())
        onView(withId(R.id.textViewOnCard)).check(matches(withText("Two roads diverged in a wood, and I—I took the one less traveled by, And that has made all the difference.")))
    }

    @Test
    fun shareButton_expectedIntentChooser() {
        Intents.init()
        onView(withId(R.id.btn_share)).perform(click())
        intended(allOf(hasAction(Intent.ACTION_SEND)))
        Intents.release()

    }

}