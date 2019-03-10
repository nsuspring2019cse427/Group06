package com.example.pillreminder;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Calendar;

import static android.support.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;
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
    public void testLaunchActivity_TextView(){
        View view = reminderActivity.findViewById(R.id.textView);
        assertNotNull(view);
    }
    @Test
    public void testLaunchActivity_cancelbuttonView(){
        View view1 = reminderActivity.findViewById(R.id.cancelbutton);
        assertNotNull(view1);
    }
    @Test
    public void testLaunchActivity_setbuttonView(){
        View view2 = reminderActivity.findViewById(R.id.setbutton);
        assertNotNull(view2);
    }
    @Test
    public void testLaunchActivity_timepickerView(){
        View view3 = reminderActivity.findViewById(R.id.timepicker);
        assertNotNull(view3);
    }
    @Test
    public void testLaunchActivity_medicinenameView(){
        View view4 = reminderActivity.findViewById(R.id.medicinename);
        assertNotNull(view4);
    }
    @Test
    public void testLaunchActivity_iconreminderView(){
        View view5 = reminderActivity.findViewById(R.id.iconreminder);
        assertNotNull(view5);
    }
    @Test
    public void testLaunchActivity_layoutreminderView(){
        View view6 = reminderActivity.findViewById(R.id.layoutreminder);
        assertNotNull(view6);
    }
    @Test
    public void testLaunchOfActivity_backgroundView(){
        View view7 = reminderActivity.findViewById(R.id.backgroud);
        assertNotNull(view7);
    }


    @After
    public void tearDown() throws Exception {
        reminderActivity = null;
    }


    @Test
    public void getTimeInMillis() throws Throwable {
        runOnUiThread(new Runnable(){
            public void run() {
                int hour=8;
                int minute=0;

                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.HOUR_OF_DAY, hour);
                cal.set(Calendar.MINUTE, minute);
                cal.set(Calendar.SECOND, 0);

                Reminder reminder = new Reminder();
                long result = reminder.getTimeInMillis(hour,minute);
                assertEquals(cal.getTimeInMillis() ,result);

            }
        });
        }
}