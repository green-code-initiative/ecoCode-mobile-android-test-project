package io.ecocode.testapp.environment.power;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PowerManager;

import androidx.annotation.Nullable;

public class SaveModeAwarenessTest extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

            }
        };
        registerReceiver(receiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));//Issue {Power: Save Mode Awareness}
        IntentFilter filter2 = new IntentFilter(Intent.ACTION_ANSWER);

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);//Issue {Power: Save Mode Awareness}
        filter.addAction("android.provider.Telephony.SMS_RECEIVED");
        IntentFilter.create(Intent.ACTION_BATTERY_CHANGED,"");//Issue {Power: Save Mode Awareness}
        IntentFilter.create("foo", "application/blatz");

        PowerManager manager = (PowerManager) getSystemService(POWER_SERVICE);
        manager.isPowerSaveMode(); //Issue {Power: Save Mode Awareness}
    }
}