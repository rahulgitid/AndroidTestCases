package com.mypdfsigner.testcasessampleapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class AddQuoteTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(AddQuote::class.java)

    @Test
    fun testAddQuote() {
        onView(withId(R.id.editTextTitle)).perform(typeText("Hello"))
        onView(withId(R.id.editTextDescription)).perform(typeText("Quote Desciption"),closeSoftKeyboard())
        onView(withId(R.id.buttonSubmit)).perform(click())
        onView(withId(R.id.txt_quote_detail)).check(matches(withText("Quote:- Hello-Quote Desciption")))
    }
}