package io.ecocode.testapp.social.privacy;

import android.content.Context;
import android.telephony.TelephonyManager;

public class TrackingIdTest {

    private TrackingIdTest() {}

    public static String getDeviceIdentifier(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getDeviceId();
    }
}
