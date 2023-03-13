package io.ecocode.testapp.environment.sobriety;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static android.view.WindowManager.LayoutParams.BRIGHTNESS_OVERRIDE_FULL;
import static android.view.WindowManager.LayoutParams.BRIGHTNESS_OVERRIDE_NONE;

public class BrightnessOverrideTest extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        float blabla = BRIGHTNESS_OVERRIDE_FULL;
        Window v = getWindow();
        WindowManager.LayoutParams params = v.getAttributes();
        params.screenBrightness = BRIGHTNESS_OVERRIDE_FULL; // Issue {Sobriety: Brightness Override}
        params.screenBrightness = 1f; // Issue {Sobriety: Brightness Override}
        params.screenBrightness = 1; // Issue {Sobriety: Brightness Override}
        params.screenBrightness = 0.5f;
        params.screenBrightness = BRIGHTNESS_OVERRIDE_NONE;
        params.screenBrightness = blabla;
        blabla-=0.5f;
        blabla*=1.5;
        params.screenBrightness = blabla;
        getWindow().getAttributes().screenBrightness = 1f; // Issue {Sobriety: Brightness Override}
    }
}
