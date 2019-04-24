package com.example.pillreminder;

import android.app.AliasActivity;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlarmTest {

    @Rule
    public ActivityTestRule<Reminder> mActivityRule = new ActivityTestRule<Reminder>(Alarm.class, false, false);
    private Reminder alarmActivity = null;

    @Before
    public void setUp() throws Exception {
        alarmActivity = mActivityRule.getActivity();
    }
    @After
    public void tearDown() throws Exception {
        alarmActivity = null;
    }


}
