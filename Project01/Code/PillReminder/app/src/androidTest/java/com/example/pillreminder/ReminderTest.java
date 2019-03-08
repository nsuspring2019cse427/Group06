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
        View view1 = reminderActivity.findViewById(R.id.cancelbutton);
        assertNotNull(view1);
        View view2 = reminderActivity.findViewById(R.id.setbutton);
        assertNotNull(view2);
        View view3 = reminderActivity.findViewById(R.id.timepicker);
        assertNotNull(view3);
        View view4 = reminderActivity.findViewById(R.id.medicinename);
        assertNotNull(view4);
        View view5 = reminderActivity.findViewById(R.id.iconreminder);
        assertNotNull(view5);
        View view6 = reminderActivity.findViewById(R.id.layoutreminder);
        assertNotNull(view6);
        View view7 = reminderActivity.findViewById(R.id.backgroud);
        assertNotNull(view7);
    }

    @After
    public void tearDown() throws Exception {
        reminderActivity = null;
    }
}