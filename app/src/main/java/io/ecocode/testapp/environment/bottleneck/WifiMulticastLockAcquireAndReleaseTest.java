package io.ecocode.testapp.environment.bottleneck;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;

import io.ecocode.testapp.R;


public class WifiMulticastLockAcquireAndReleaseTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiManager.MulticastLock lock = wifiManager.createMulticastLock("tag");
        methodAcquire(lock);
        methodRelease(lock);
    }


    public void methodAcquire(WifiManager.MulticastLock paramLock){
        paramLock.acquire();
    }

    public void methodRelease(WifiManager.MulticastLock paramLock){
        paramLock.release();
    }
}