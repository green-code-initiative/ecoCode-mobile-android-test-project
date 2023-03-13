package io.ecocode.testapp.environment.sobriety;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;


public class VibrationFreeTest extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Vibrator v1 = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE); // Issue {Sobriety: Vibration Free}
    Vibrator v2 = (Vibrator) getApplicationContext().getSystemService("vibrator"); // Issue {Sobriety: Vibration Free}
    Vibrator v3 = (Vibrator) getSystemService("vibrator"); // Issue {Sobriety: Vibration Free}
    Vibrator v4 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); // Issue {Sobriety: Vibration Free}
    v1.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
    v2.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
    v3.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
    v4.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));

    VibratorManager v5 = (VibratorManager) getApplicationContext().getSystemService(Context.VIBRATOR_MANAGER_SERVICE); // Issue {Sobriety: Vibration Free}
    VibratorManager v6 = (VibratorManager) getApplicationContext().getSystemService("vibrator_manager"); // Issue {Sobriety: Vibration Free}
    VibratorManager v7 = (VibratorManager) getSystemService("vibrator_manager"); // Issue {Sobriety: Vibration Free}
    VibratorManager v8 = (VibratorManager) getSystemService(Context.VIBRATOR_MANAGER_SERVICE); // Issue {Sobriety: Vibration Free}
    v5.getDefaultVibrator().vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
    v6.getDefaultVibrator().vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
    v7.getDefaultVibrator().vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
    v8.getDefaultVibrator().vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
  }
}