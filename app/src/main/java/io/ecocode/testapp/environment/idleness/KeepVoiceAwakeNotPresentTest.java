package io.ecocode.testapp.environment.idleness;

import android.os.Bundle;
import android.service.voice.VoiceInteractionSession;

import androidx.appcompat.app.AppCompatActivity;

import io.ecocode.testapp.R;

public class KeepVoiceAwakeNotPresentTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        VoiceInteractionSession voiceSession = new VoiceInteractionSession(this); // Issue {Idleness : Keep Voice Awake}
    }
}
