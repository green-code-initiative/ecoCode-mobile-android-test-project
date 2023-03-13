package io.ecocode.testapp.environment.batch;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;

public class SensorCoalesceTest extends Activity {

    private final int positiveNumberG = 200000;
    private final long positiveNumberLG = 200000L;
    private final int zeroNumberG = 0;
    private final long zeroNumberLG = 0L;
    private final int negativeNumberG = -1;
    private final long negativeNumberLG = -1L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SensorManager sensorManager = null;
        SensorEventListener sensorEventListener = null;
        Sensor sensor = null;
        Handler handler = null;

        final int positiveNumber = 200000;
        final long positiveNumberL = 200000L;
        final int zeroNumber = 0;
        final long zeroNumberL = 0L;
        final int negativeNumber = -1;
        final long negativeNumberL = -1L;

        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL); // Issue {Batch: Sensor Coalesce}
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, handler); // Issue {Batch: Sensor Coalesce}

        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, 0); // Issue {Batch: Sensor Coalesce}
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, (int)0L); // Issue {Batch: Sensor Coalesce}
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, -1); // Issue {Batch: Sensor Coalesce}
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, (int)-1L); // Issue {Batch: Sensor Coalesce}
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, 200000);
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, (int)200000L);
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, 0, handler); // Issue {Batch: Sensor Coalesce}
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, (int)0L, handler); // Issue {Batch: Sensor Coalesce}
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, -1, handler); // Issue {Batch: Sensor Coalesce}
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, (int)-1L, handler); // Issue {Batch: Sensor Coalesce}
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, 200000, handler);
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, (int)200000L, handler);

        /*TODO: 16/02/2022 Global & Local Variable Not Working
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, zeroNumber); // Issue {Batch: Sensor Coalesce}
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, (int)zeroNumberL); // Issue {Batch: Sensor Coalesce}
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, negativeNumber); // Issue {Batch: Sensor Coalesce}
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, (int)negativeNumberL); // Issue {Batch: Sensor Coalesce}
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, positiveNumber);
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, (int)positiveNumberL);
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, zeroNumber, handler); // Issue {Batch: Sensor Coalesce}
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, (int)zeroNumberL, handler); // Issue {Batch: Sensor Coalesce}
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, negativeNumber, handler); // Issue {Batch: Sensor Coalesce}
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, (int)negativeNumberL, handler); // Issue {Batch: Sensor Coalesce}
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, positiveNumber, handler);
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, (int)positiveNumberL, handler);

        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, zeroNumberG); // Issue {Batch: Sensor Coalesce}
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, (int)zeroNumberLG); // Issue {Batch: Sensor Coalesce}
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, negativeNumberG); // Issue {Batch: Sensor Coalesce}
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, (int)negativeNumberLG); // Issue {Batch: Sensor Coalesce}
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, positiveNumberG);
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, (int)positiveNumberLG);
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, zeroNumberG, handler); // Issue {Batch: Sensor Coalesce}
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, (int)zeroNumberLG, handler); // Issue {Batch: Sensor Coalesce}
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, negativeNumberG, handler); // Issue {Batch: Sensor Coalesce}
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, (int)negativeNumberLG, handler); // Issue {Batch: Sensor Coalesce}
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, positiveNumberG, handler);
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL, (int)positiveNumberLG, handler);*/


        sensorManager.unregisterListener(sensorEventListener);
    }
}
