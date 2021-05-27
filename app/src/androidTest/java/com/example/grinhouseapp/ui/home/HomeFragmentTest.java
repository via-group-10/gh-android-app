package com.example.grinhouseapp.ui.home;

import android.content.Context;

import androidx.fragment.app.FragmentTransaction;
import androidx.test.espresso.Espresso;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.grinhouseapp.R;
import com.example.grinhouseapp.ui.filter.FilterFragment;
import com.example.grinhouseapp.ui.main.HomeActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;
@RunWith(AndroidJUnit4.class)

public class HomeFragmentTest {

    @Rule
    public ActivityTestRule<HomeActivity> activityTestRule = new ActivityTestRule<HomeActivity>(HomeActivity.class);

    @Test
    public void test_isValuesDisplayed() throws Exception{
        Espresso.onView(withId(R.id.text_temData)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.text_cdData)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.text_humData)).check(matches(isDisplayed()));
    }

    @Test
    public void test_navDataFragment(){
        Espresso.onView(withId(R.id.navigation_data)).perform(click());
        Espresso.onView(withId(R.id.fragment_data)).check(matches(isDisplayed()));
    }

    @Test
    public void test_navProfileFragment(){
        Espresso.onView(withId(R.id.navigation_profile)).perform(click());
        Espresso.onView(withId(R.id.fragment_profile)).check(matches(isDisplayed()));
    }

    @Test
    public void test_navFilterFragment(){
        Espresso.onView(withId(R.id.filter)).perform(click());
        Espresso.onView(withId(R.id.filtering)).check(matches(isDisplayed()));
    }

    @Test
    public void test_navThresholdTemperatureFragment(){
        Espresso.onView(withId(R.id.text_temData)).perform(click());
        Espresso.onView(withId(R.id.threshold_temperature)).check(matches(isDisplayed()));
    }

    @Test
    public void test_navThresholdCO2Fragment(){
        Espresso.onView(withId(R.id.text_cdData)).perform(click());
        Espresso.onView(withId(R.id.threshold_co2)).check(matches(isDisplayed()));
    }

    @Test
    public void test_navThresholdHumidityFragment(){
        Espresso.onView(withId(R.id.text_humData)).perform(click());
        Espresso.onView(withId(R.id.threshold_hum)).check(matches(isDisplayed()));
    }


}