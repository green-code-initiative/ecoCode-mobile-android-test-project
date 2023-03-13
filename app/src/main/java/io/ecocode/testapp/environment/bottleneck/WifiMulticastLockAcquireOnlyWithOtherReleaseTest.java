package io.ecocode.testapp.environment.bottleneck;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;

import io.ecocode.testapp.R;


public class WifiMulticastLockAcquireOnlyWithOtherReleaseTest extends Activity {

    WifiManager.MulticastLock lock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        lock = wifiManager.createMulticastLock("tag");

        release();
    }

    public void release() {
        lock.acquire(); // Issue {Bottleneck: Wifi Multicast Lock}
    }
}