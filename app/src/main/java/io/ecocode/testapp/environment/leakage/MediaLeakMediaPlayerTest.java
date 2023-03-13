package io.ecocode.testapp.environment.leakage;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;

import io.ecocode.testapp.R;


public class MediaLeakMediaPlayerTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaPlayer player = new MediaPlayer(); // Issue {Leakage: Media Leak (MediaPlayer)}
    }
}