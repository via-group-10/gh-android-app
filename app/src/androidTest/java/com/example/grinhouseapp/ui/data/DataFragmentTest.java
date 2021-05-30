package com.example.grinhouseapp.ui.data;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.example.grinhouseapp.R;
import com.example.grinhouseapp.ui.main.HomeActivity;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static androidx.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static androidx.test.espresso.matcher.ViewMatchers.hasImeAction;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class DataFragmentTest {

    @Rule
   // public ActivityTestRule<HomeActivity> activityTestRule = new ActivityTestRule<HomeActivity>(HomeActivity.class);
    public IntentsTestRule<HomeActivity> intentsTestRule =
            new IntentsTestRule<>(HomeActivity.class);


    @Test
    public void temperatureGraphAndIntent() {
        Espresso.onView(withId(R.id.navigation_data)).perform(click());
        Espresso.onView(withId(R.id.seeMoreTemperature)).perform(click());
        Espresso.onView(withId(R.id.bigGraph)).check(matches(isDisplayed()));
        intended(hasExtra("measurement",0));
    }

    @Test
    public void humidityGraphAndIntent() {
        Espresso.onView(withId(R.id.navigation_data)).perform(click());
        Espresso.onView(withId(R.id.seeMoreHumidity)).perform(click());
        Espresso.onView(withId(R.id.bigGraph)).check(matches(isDisplayed()));
        intended(hasExtra("measurement",1));
        Espresso.onView(withId(R.id.monthlyButton)).check(matches(isChecked()));
    }

    @Test
    public void co2GraphAndIntent() {
        Espresso.onView(withId(R.id.navigation_data)).perform(click());
        Espresso.onView(withId(R.id.seeMoreCO2)).perform(click());
        Espresso.onView(withId(R.id.bigGraph)).check(matches(isDisplayed()));
        intended(hasExtra("measurement",2));
    }
}