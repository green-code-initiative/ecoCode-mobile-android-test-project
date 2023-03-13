package io.ecocode.testapp.environment.leakage;

import android.app.Activity;

import android.hardware.Camera;
import android.os.Bundle;

import io.ecocode.testapp.R;


public class CameraLeakTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Camera.open(0); // Issue {Leakage: Camera Leak}

        Camera camera = Camera.open(); // Issue {Leakage: Camera Leak}
    }
}