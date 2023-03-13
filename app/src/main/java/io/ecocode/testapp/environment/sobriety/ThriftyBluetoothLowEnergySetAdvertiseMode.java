package io.ecocode.testapp.environment.sobriety;

import android.app.Activity;
import android.bluetooth.le.AdvertiseSettings;
import android.os.Bundle;


public class ThriftyBluetoothLowEnergySetAdvertiseMode extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AdvertiseSettings.Builder builder = new AdvertiseSettings.Builder();
        builder.setAdvertiseMode(AdvertiseSettings.ADVERTISE_MODE_BALANCED); // Issue {Sobriety: Thrifty Bluetooth Low Energy (setAdvertiseMode)}
        builder.setAdvertiseMode(AdvertiseSettings.ADVERTISE_MODE_LOW_POWER);
        builder.setAdvertiseMode(AdvertiseSettings.ADVERTISE_MODE_LOW_LATENCY); // Issue {Sobriety: Thrifty Bluetooth Low Energy (setAdvertiseMode)}
        builder.setAdvertiseMode(1); // Issue {Sobriety: Thrifty Bluetooth Low Energy (setAdvertiseMode)}
        builder.setAdvertiseMode(0);
        builder.setAdvertiseMode((int)0L);
    }
}