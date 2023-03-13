package io.ecocode.testapp.environment.idleness;

import android.os.Build;
import android.os.Bundle;
import android.service.voice.VoiceInteractionSession;

import androidx.appcompat.app.AppCompatActivity;

import io.ecocode.testapp.R;

public class KeepVoiceAwakeToFalseTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        VoiceInteractionSession voiceSession = new VoiceInteractionSession(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            voiceSession.setKeepAwake(false);
        }
    }
}
