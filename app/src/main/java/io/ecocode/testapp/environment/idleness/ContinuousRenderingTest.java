package io.ecocode.testapp.environment.idleness;

import android.opengl.GLSurfaceView;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import io.ecocode.testapp.R;

public class ContinuousRenderingTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GLSurfaceView surfaceView = new GLSurfaceView(this);

        surfaceView.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY); //Issue {idleness: Continuous Rendering}

        surfaceView.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

    }
}
