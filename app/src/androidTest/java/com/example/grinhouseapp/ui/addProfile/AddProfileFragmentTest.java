package com.example.grinhouseapp.ui.addProfile;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import com.example.grinhouseapp.R;
import com.example.grinhouseapp.ui.main.HomeActivity;
import com.example.grinhouseapp.ui.profile.ProfileAdapter;
import com.example.grinhouseapp.ui.profile.ProfileFragment;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class AddProfileFragmentTest {

    @Rule
    public ActivityTestRule<HomeActivity> activityTestRule = new ActivityTestRule<HomeActivity>(HomeActivity.class);

    //this will fail because it can't find the view given how the layout is made...
    @Test
    public void createProfile(){
        Espresso.onView(withId(R.id.navigation_profile)).perform(click());
        Espresso.onView(withId(R.id.fab)).perform(click());
        Espresso.onView(withId(R.id.editTextProfileName)).perform(typeText("testing"));
        Espresso.onView(withId(R.id.editTextTemperatureLow)).perform(typeText("20"));
        Espresso.onView(withId(R.id.editTextTemperatureHigh)).perform(typeText("80"));
        Espresso.onView(withId(R.id.editTextCO2Low)).perform(typeText("20"));
        Espresso.onView(withId(R.id.editTextCO2High)).perform(typeText("55"));

        //here it will crash
        Espresso.onView(withId(R.id.editTextHumidityLow)).perform(typeText("55"));
        Espresso.onView(withId(R.id.editTextHumidityHigh)).perform(typeText("68"));
        Espresso.onView(withId(R.id.button_save_profile)).perform(click());
        Espresso.onView(withId(R.id.fragment_profile)).check(matches(isDisplayed()));

    }

    @Test
    public void cancelAddingProfile(){
        Espresso.onView(withId(R.id.navigation_profile)).perform(click());
        Espresso.onView(withId(R.id.fab)).perform(click());
        Espresso.onView(withId(R.id.button_cancel)).perform(click());
        Espresso.onView(withId(R.id.fragment_profile)).check(matches(isDisplayed()));
    }





}