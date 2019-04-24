package com.example.pillreminder;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Calendar;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;
import static org.junit.Assert.*;

public class ReminderTest {

    @Rule
    public ActivityTestRule<Reminder> mActivityTestRule = new ActivityTestRule<Reminder>(Reminder.class);

    private Reminder reminderActivity = null;
   // Instrumentation.ActivityMonitor monitor = getInstrumentation.addMonitor(Alarm.class.getName(),null,false);

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
    public void testLaunchActivity_medicinenameview(){
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
   /* @Test
    public void testLaunchOfSetButtonActivity(){
        assertNotNull(reminderActivity.findViewById(R.id.setbutton));
        onView(withId(R.id.setbutton)).perform(click());
        Intent intent = new Intent(reminderActivity, Alarm.class);
        Activity alarm = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);
        assertNotNull(alarm);

    }
   @Test
    public void testMedicineNameEditTextFieldValidation(){
        EditText editText = reminderActivity.findViewById(R.id.medicinename);
        assertEquals(true, editText);
        InputFilter letterFilter;
        assertNotNull( editText.setFilters(new InputFilter[]{letterFilter}));
    }*/


    /*@Test
    public void testonClick(View view){
        if (view.getId() == R.id.setbutton) {
            assertNotNull(reminderActivity.findViewById(R.id.timepicker));
           // int hour = timePicker.getCurrentHour();
            //int minute = timePicker.getCurrentMinute();

            //long alarmStartTime = getTimeInMillis();
            //Toast.makeText(reminderActivity, "T" +alarmStartTime + "C" +System.currentTimeMillis(), Toast.LENGTH_LONG).show();

        }

    }


    @After
    public void tearDown() throws Exception {
        reminderActivity = null;
    }*/


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

    //Improper time false case test
    @Test
    public void improperTimeFalseCase() throws Throwable{
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Reminder reminder = new Reminder();

                int hour = 20;
                boolean result = reminder.improperTime(hour);
                assertEquals(false,result);

            }
        });
    }
    //Improper time true case test
    @Test
    public void improperTimeTrueCase() throws Throwable{
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Reminder reminder = new Reminder();

                int hour = 23;
                boolean result = reminder.improperTime(hour);
                assertEquals(true,result);

            }
        });
    }


}