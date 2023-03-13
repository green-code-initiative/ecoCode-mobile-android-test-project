package io.ecocode.testapp.environment.leakage;

import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;

import io.ecocode.testapp.R;


public class MediaLeakMediaRecorderTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaRecorder recorder = new MediaRecorder(); // Issue {Leakage: Media Leak (MediaRecorder)}
    }
}