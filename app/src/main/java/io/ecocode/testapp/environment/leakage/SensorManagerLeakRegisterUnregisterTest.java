package io.ecocode.testapp.environment.leakage;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import io.ecocode.testapp.R;


public class SensorManagerLeakRegisterUnregisterTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor accelerometer = sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sManager.registerListener(getAccelerometerListener(),accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
        sManager.unregisterListener(getAccelerometerListener());
    }

    private SensorEventListener getAccelerometerListener() {
        return new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
    }
}