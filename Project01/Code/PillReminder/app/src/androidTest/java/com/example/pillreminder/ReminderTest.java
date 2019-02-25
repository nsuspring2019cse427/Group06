package com.example.pillreminder;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReminderTest {

    @Rule
    public ActivityTestRule<Reminder> mActivityTestRule = new ActivityTestRule<Reminder>(Reminder.class);

    private Reminder reminderActivity = null;

    @Before
    public void setUp() throws Exception {
        reminderActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunchOfActivity(){
        View view = reminderActivity.findViewById(R.id.textView);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {
        reminderActivity = null;
    }
}