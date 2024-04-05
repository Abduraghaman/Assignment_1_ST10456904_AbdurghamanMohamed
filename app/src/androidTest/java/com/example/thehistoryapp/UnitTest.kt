package com.example.thehistoryapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testGenerateHistoryButton() {
        // Type a valid age
        onView(withId(R.id.editTextEnterAge)).perform(typeText("25"))

        // Click the generate history button
        onView(withId(R.id.buttonGenerateHistory)).perform(click())

        // Check if the infoTextView displays historic figure information
        onView(withId(R.id.infoTextView)).check(matches(withText(containsString("Sylvia Plath"))))
    }

    @Test
    fun testClearButton() {
        // Type a valid age
        onView(withId(R.id.editTextEnterAge)).perform(typeText("25"))

        // Click the generate history button
        onView(withId(R.id.buttonGenerateHistory)).perform(click())

        // Check if the infoTextView displays historic figure information
        onView(withId(R.id.infoTextView)).check(matches(withText(containsString("Sylvia Plath"))))

        // Click the clear button
        onView(withId(R.id.buttonClear)).perform(click())

        // Check if the infoTextView is empty
        onView(withId(R.id.infoTextView)).check(matches(withText("")))
    }

    @Test
    fun testInvalidAge() {
        // Type an invalid age
        onView(withId(R.id.editTextEnterAge)).perform(typeText("abc"))

        // Click the generate history button
        onView(withId(R.id.buttonGenerateHistory)).perform(click())

        // Check if the infoTextView displays an error message
        onView(withId(R.id.infoTextView)).check(matches(withText("Please enter a valid age")))

        // Check if the infoTextView is not empty
        onView(withId(R.id.infoTextView)).check(matches(not(withText(""))))
    }
}