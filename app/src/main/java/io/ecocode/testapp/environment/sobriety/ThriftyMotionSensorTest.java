package io.ecocode.testapp.environment.sobriety;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;


public class ThriftyMotionSensorTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SensorManager sManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR); // Issue {Sobriety: Thrifty Motion Sensor}
        sManager.getDefaultSensor(((int) Sensor.TYPE_ROTATION_VECTOR)); // Issue {Sobriety: Thrifty Motion Sensor}
        sManager.getDefaultSensor(11); // Issue {Sobriety: Thrifty Motion Sensor}
        sManager.getDefaultSensor(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR);
    }
}