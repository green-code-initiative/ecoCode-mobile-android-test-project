package io.ecocode.testapp.environment.sobriety;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceControl;

import static android.view.Surface.CHANGE_FRAME_RATE_ALWAYS;
import static android.view.Surface.CHANGE_FRAME_RATE_ONLY_IF_SEAMLESS;
import static android.view.Surface.FRAME_RATE_COMPATIBILITY_DEFAULT;
import static android.view.Surface.FRAME_RATE_COMPATIBILITY_FIXED_SOURCE;


public class HighFrameRateTest extends Activity {

  private static final float FRAME_RATE_0 = 0.0f;
  private static final float FRAME_RATE_60 = 60.0f;
  private static final float FRAME_RATE_90 = 90.0f;
  private static final float FRAME_RATE_120 = 120.0f;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    SurfaceControl surfaceControl = null;
    Surface surface = null;
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
      surfaceControl = (new SurfaceControl.Builder()).build();
      surface = new Surface(surfaceControl);
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
      surface.setFrameRate(FRAME_RATE_0, FRAME_RATE_COMPATIBILITY_DEFAULT);
      surface.setFrameRate(FRAME_RATE_60, FRAME_RATE_COMPATIBILITY_DEFAULT);
      surface.setFrameRate(FRAME_RATE_90, FRAME_RATE_COMPATIBILITY_DEFAULT); // Issue {Sobriety: High Frame Rate}
      surface.setFrameRate(FRAME_RATE_120, FRAME_RATE_COMPATIBILITY_DEFAULT); // Issue {Sobriety: High Frame Rate}

      // Test with compatibility fixed source
      surface.setFrameRate(0.0f, FRAME_RATE_COMPATIBILITY_FIXED_SOURCE);
      surface.setFrameRate(60.0f, FRAME_RATE_COMPATIBILITY_FIXED_SOURCE);
      surface.setFrameRate(90.0f, FRAME_RATE_COMPATIBILITY_FIXED_SOURCE); // Issue {Sobriety: High Frame Rate}
      surface.setFrameRate(120.0f, FRAME_RATE_COMPATIBILITY_FIXED_SOURCE); // Issue {Sobriety: High Frame Rate}
    }

    // Test with 3 args
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
      surface.setFrameRate(0.0f, FRAME_RATE_COMPATIBILITY_DEFAULT, CHANGE_FRAME_RATE_ONLY_IF_SEAMLESS);
      surface.setFrameRate(60.0f, FRAME_RATE_COMPATIBILITY_DEFAULT, CHANGE_FRAME_RATE_ONLY_IF_SEAMLESS);
      surface.setFrameRate(90.0f, FRAME_RATE_COMPATIBILITY_DEFAULT, CHANGE_FRAME_RATE_ONLY_IF_SEAMLESS); // Issue {Sobriety: High Frame Rate}
      surface.setFrameRate(120.0f, FRAME_RATE_COMPATIBILITY_DEFAULT, CHANGE_FRAME_RATE_ONLY_IF_SEAMLESS); // Issue {Sobriety: High Frame Rate}

      surface.setFrameRate(0.0f, FRAME_RATE_COMPATIBILITY_DEFAULT, CHANGE_FRAME_RATE_ALWAYS);
      surface.setFrameRate(60.0f, FRAME_RATE_COMPATIBILITY_DEFAULT, CHANGE_FRAME_RATE_ALWAYS);
      surface.setFrameRate(90.0f, FRAME_RATE_COMPATIBILITY_DEFAULT, CHANGE_FRAME_RATE_ALWAYS); // Issue {Sobriety: High Frame Rate}
      surface.setFrameRate(120.0f, FRAME_RATE_COMPATIBILITY_DEFAULT, CHANGE_FRAME_RATE_ALWAYS); // Issue {Sobriety: High Frame Rate}

      surface.setFrameRate(0.0f, FRAME_RATE_COMPATIBILITY_FIXED_SOURCE, CHANGE_FRAME_RATE_ALWAYS);
      surface.setFrameRate(60.0f, FRAME_RATE_COMPATIBILITY_FIXED_SOURCE, CHANGE_FRAME_RATE_ALWAYS);
      surface.setFrameRate(90.0f, FRAME_RATE_COMPATIBILITY_FIXED_SOURCE, CHANGE_FRAME_RATE_ALWAYS); // Issue {Sobriety: High Frame Rate}
      surface.setFrameRate(120.0f, FRAME_RATE_COMPATIBILITY_FIXED_SOURCE, CHANGE_FRAME_RATE_ALWAYS); // Issue {Sobriety: High Frame Rate}

      surface.setFrameRate(0.0f, FRAME_RATE_COMPATIBILITY_FIXED_SOURCE, CHANGE_FRAME_RATE_ONLY_IF_SEAMLESS);
      surface.setFrameRate(60.0f, FRAME_RATE_COMPATIBILITY_FIXED_SOURCE, CHANGE_FRAME_RATE_ONLY_IF_SEAMLESS);
      surface.setFrameRate(90.0f, FRAME_RATE_COMPATIBILITY_FIXED_SOURCE, CHANGE_FRAME_RATE_ONLY_IF_SEAMLESS); // Issue {Sobriety: High Frame Rate}
      surface.setFrameRate(120.0f, FRAME_RATE_COMPATIBILITY_FIXED_SOURCE, CHANGE_FRAME_RATE_ONLY_IF_SEAMLESS); // Issue {Sobriety: High Frame Rate}
    }
  }
}