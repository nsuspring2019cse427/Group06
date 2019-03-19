package com.example.pillreminder;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MyBroadcastReceiverTest extends BroadcastReceiver {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void onReceive() {
    }
    @Test
    public void testIntentHandling() {
        Alarm receiver = (Alarm) receiversForIntent.get(0);
        receiver.onReceive(Robolectric.getShadowApplication().getApplicationContext(), intent);

        Intent serviceIntent = Robolectric.getShadowApplication().peekNextStartedService();
        assertNotNull("Expected the MyBroadcast service to be invoked",

                Alarm.class.getCanonicalName(),
                serviceIntent.getComponent().getClassName());

    }

    private void assertNotNull(String s, String canonicalName, String className) {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        assertNotNull(NotificationManager myNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
);

    }
}

}