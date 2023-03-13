package io.ecocode.testapp.environment.sobriety;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.RingtoneManager;
import android.os.Bundle;

public class ThriftyNotificationTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        NotificationChannel notification = new NotificationChannel("42", "test", NotificationManager.IMPORTANCE_DEFAULT);
        notification.setVibrationPattern(new long[] {1000, 1000, 1000, 1000, 1000}); // Issue {Sobriety: Thrifty Notification}
        notification.setVibrationPattern(null);
        notification.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION), Notification.AUDIO_ATTRIBUTES_DEFAULT); // Issue {Sobriety: Thrifty Notification}
        notification.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION), null); // Issue {Sobriety: Thrifty Notification}
        notification.setSound(null, Notification.AUDIO_ATTRIBUTES_DEFAULT); // Issue {Sobriety: Thrifty Notification}
        notification.setSound(null, null);

        Notification.Builder notificationBuilder = new Notification.Builder(getApplicationContext(), "42");
        notificationBuilder.setVibrate(new long[] {1000, 1000, 1000, 1000, 1000}); // Issue {Sobriety: Thrifty Notification}
        notificationBuilder.setVibrate(null);
        notificationBuilder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION), Notification.AUDIO_ATTRIBUTES_DEFAULT); // Issue {Sobriety: Thrifty Notification}
        notificationBuilder.setSound(null, Notification.AUDIO_ATTRIBUTES_DEFAULT); // Issue {Sobriety: Thrifty Notification}
        notificationBuilder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION), Notification.STREAM_DEFAULT); // Issue {Sobriety: Thrifty Notification}
        notificationBuilder.setSound(null, Notification.STREAM_DEFAULT); // Issue {Sobriety: Thrifty Notification}
        notificationBuilder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION), null); // Issue {Sobriety: Thrifty Notification}
        notificationBuilder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)); // Issue {Sobriety: Thrifty Notification}
        notificationBuilder.setSound(null);
        notificationBuilder.setSound(null, null);
    }

}
