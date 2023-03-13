package io.ecocode.testapp.environment.bottleneck;

import android.app.Activity;
import android.os.Bundle;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPOutputStream;

import javax.net.ssl.HttpsURLConnection;

import io.ecocode.testapp.R;


public class UncompressedDataTransmissionTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            URL url = new URL("https://www.ecocode.io");
            HttpsURLConnection httpsCon = (HttpsURLConnection) url.openConnection();
            URLConnection con = url.openConnection();

            OutputStream stream = httpsCon.getOutputStream();// Issue {Bottleneck: Uncompressed Data Transmission}
            OutputStream stream2 = (OutputStream)httpsCon.getOutputStream();// Issue {Bottleneck: Uncompressed Data Transmission}
            OutputStream stream3 = ((OutputStream)httpsCon.getOutputStream());// Issue {Bottleneck: Uncompressed Data Transmission}
            OutputStream stream4 = ((OutputStream)con.getOutputStream());// Issue {Bottleneck: Uncompressed Data Transmission}
            OutputStream stream5 = (DataOutputStream)con.getOutputStream();// Issue {Bottleneck: Uncompressed Data Transmission}
            OutputStream stream6 = ((DataOutputStream)con.getOutputStream());// Issue {Bottleneck: Uncompressed Data Transmission}
            OutputStream stream7 = ((DataOutputStream)httpsCon.getOutputStream());// Issue {Bottleneck: Uncompressed Data Transmission}
            OutputStream stream8 = (DataOutputStream)httpsCon.getOutputStream();// Issue {Bottleneck: Uncompressed Data Transmission}

            OutputStream stream9 = new FileOutputStream("myfile.zip");
            OutputStream stream10 = new BufferedOutputStream(new FileOutputStream("myfile.zip"));
            OutputStream stream11 = new BufferedOutputStream(con.getOutputStream());// Issue {Bottleneck: Uncompressed Data Transmission}

            OutputStream stream12 = new GZIPOutputStream(httpsCon.getOutputStream());
            GZIPOutputStream stream13 = new GZIPOutputStream(httpsCon.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}