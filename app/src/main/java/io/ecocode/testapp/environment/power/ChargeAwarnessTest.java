package io.ecocode.testapp.environment.power;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class ChargeAwarnessTest extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

            }
        };
        IntentFilter intentfilter = new IntentFilter();
        IntentFilter.create(Intent.ACTION_BATTERY_LOW,""); // Issue {Power: Charge Awareness
        IntentFilter.create(Intent.ACTION_APP_ERROR,"");
        intentfilter.addAction(Intent.ACTION_BATTERY_LOW); // Issue {Power: Charge Awareness
        IntentFilter.create(Intent.ACTION_APP_ERROR,"");
        registerReceiver(receiver,new IntentFilter(Intent.ACTION_POWER_CONNECTED)); // Issue {Power: Charge Awareness}
        registerReceiver(receiver,new IntentFilter(Intent.ACTION_POWER_DISCONNECTED)); // Issue {Power: Charge Awareness}
        registerReceiver(receiver,new IntentFilter(Intent.ACTION_BATTERY_LOW)); // Issue {Power: Charge Awareness}
        registerReceiver(receiver,new IntentFilter(Intent.ACTION_BATTERY_OKAY)); // Issue {Power: Charge Awareness}

        IntentFilter newFilter = new IntentFilter(Intent.ACTION_APP_ERROR);


        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_LOW); // Issue {Power: Charge Awareness}

    }
}
