package com.example.pillreminder;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Reminder extends AppCompatActivity implements View.OnClickListener{

    private int notificationId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        // Set Onclick Listener.
        findViewById(R.id.setbutton).setOnClickListener(this);
        findViewById(R.id.cancelbutton).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        EditText editText = findViewById(R.id.medicinename);

        // Set notificationId & text.
        Intent intent = new Intent(this, Alarm.class);
        intent.putExtra("notificationId", notificationId);
        intent.putExtra("todo", editText.getText().toString());

        // getBroadcast(context, requestCode, intent, flags)
        PendingIntent alarmIntent = PendingIntent.getBroadcast(this, 0,
                intent, PendingIntent.FLAG_CANCEL_CURRENT);

        AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);

        switch (view.getId()) {
            case R.id.setbutton:
                //get alarm time
                long alarmStartTime = getTime();
                // Set alarm.
                // set(type, milliseconds, intent)
                alarm.setRepeating(AlarmManager.RTC_WAKEUP, alarmStartTime,
                        AlarmManager.INTERVAL_DAY,alarmIntent);
                Toast.makeText(this, "Done!" , Toast.LENGTH_SHORT).show();
                break;

            case R.id.cancelbutton:
                alarm.cancel(alarmIntent);
                Toast.makeText(this, "Canceled.", Toast.LENGTH_SHORT).show();
                break;
        }

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK){
            finish();
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
    public long getTime(){
        TimePicker timePicker = findViewById(R.id.timepicker);

        int hour = timePicker.getCurrentHour();
        int minute = timePicker.getCurrentMinute();

        // Create time.
        Calendar startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, hour);
        startTime.set(Calendar.MINUTE, minute);
        startTime.set(Calendar.SECOND, 0);
        return startTime.getTimeInMillis();
    }
}
