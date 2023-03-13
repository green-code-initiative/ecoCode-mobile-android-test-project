package io.ecocode.testapp.environment.idleness;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;


public class KeepCpuOnTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        WakeLock manager = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, getPackageName()); // Issue {Idleness: Keep Cpu On}
    }
}
