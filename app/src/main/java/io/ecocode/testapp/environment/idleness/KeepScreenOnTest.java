package io.ecocode.testapp.environment.idleness;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;
import static android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
import static android.view.WindowManager.LayoutParams.FLAG_LAYOUT_IN_OVERSCAN;

public class KeepScreenOnTest extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(((int)WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)); // Issue {Idleness: Keep Screen On (addFlags)}
        getWindow().addFlags(FLAG_FULLSCREEN);
        getWindow().addFlags(FLAG_FULLSCREEN | FLAG_KEEP_SCREEN_ON); // Issue {Idleness: Keep Screen On (addFlags)}
        getWindow().addFlags(FLAG_KEEP_SCREEN_ON | FLAG_FULLSCREEN); // Issue {Idleness: Keep Screen On (addFlags)}
        getWindow().addFlags(FLAG_LAYOUT_IN_OVERSCAN | FLAG_FULLSCREEN);
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_KEEP_SCREEN_ON); // Issue {Idleness: Keep Screen On (setFlags)}
        getWindow().setFlags(FLAG_KEEP_SCREEN_ON, FLAG_KEEP_SCREEN_ON); // Issue {Idleness: Keep Screen On (setFlag)}, // Issue {Idleness: Keep Screen On (setFlags)}
        getWindow().setFlags(FLAG_KEEP_SCREEN_ON, FLAG_KEEP_SCREEN_ON | FLAG_FULLSCREEN); // Issue {Idleness: Keep Screen On (setFlag)}, // Issue {Idleness: Keep Screen On (setFlags)}
        getWindow().setFlags(0, FLAG_KEEP_SCREEN_ON); // False positive
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN | FLAG_KEEP_SCREEN_ON); // False positive
        Window v = getWindow();
        v.addFlags(FLAG_KEEP_SCREEN_ON); // Issue {Idleness: Keep Screen On (addFlags)}
        v.addFlags(FLAG_FULLSCREEN);
        v.addFlags(FLAG_FULLSCREEN | FLAG_KEEP_SCREEN_ON); // Issue {Idleness: Keep Screen On (addFlags)}
        v.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);
        v.setFlags(FLAG_FULLSCREEN, FLAG_KEEP_SCREEN_ON); // Issue {Idleness: Keep Screen On (setFlag)}, // Issue {Idleness : Keep Screen On (setFlags)}
        v.setFlags(FLAG_KEEP_SCREEN_ON, FLAG_KEEP_SCREEN_ON | FLAG_FULLSCREEN); // Issue {Idleness: Keep Screen On (setFlag)}, // Issue {Idleness: Keep Screen On (setFlags)}
    }
}
