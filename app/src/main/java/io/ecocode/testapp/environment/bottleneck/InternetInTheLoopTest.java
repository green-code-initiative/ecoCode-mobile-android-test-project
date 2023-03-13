package io.ecocode.testapp.environment.bottleneck;

import android.app.Activity;
import android.os.Bundle;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import io.ecocode.testapp.R;


public class InternetInTheLoopTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HttpURLConnection con;
        URL URL = null;
        try {
            URL = new URL("http://www.android.com/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            for (int i = 0; i < 10; i++) {
                HttpURLConnection connect = (HttpURLConnection) URL.openConnection(); // Issue {Bottleneck: Internet In The Loop}

                connect = (HttpURLConnection) URL.openConnection(); // Issue {Bottleneck: Internet In The Loop}
            }

            int i = 2;
            while (i > 0) {
                //in loop
                i = i - 1;
                HttpURLConnection conn = (HttpURLConnection) URL.openConnection(); // Issue {Bottleneck: Internet In The Loop}
            }
            int f = 1;
            do {
                //in loop
                URL.openConnection(); // Issue {Bottleneck: Internet In The Loop}
                f += f;
            } while (f < 4);
            int[] intArray = {10, 20, 30};
            for (int val : intArray) {
                //in loop
                URL.openConnection(); // Issue {Bottleneck: Internet In The Loop}
            }

            URL.openConnection();

            HttpURLConnection connection;
            for (int g = 0; g < 10; g++)
                connection = (HttpURLConnection) URL.openConnection(); // Issue {Bottleneck: Internet In The Loop}

            for (int t = 0; t < 10; t++)
                connection = (HttpURLConnection) new URL("http://www.google.com/").openConnection(); // Issue {Bottleneck: Internet In The Loop}

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}