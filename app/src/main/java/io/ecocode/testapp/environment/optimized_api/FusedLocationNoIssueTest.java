package io.ecocode.testapp.environment.optimized_api;

import android.app.Activity;
import android.location.GnssStatus;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.location.FusedLocationProviderClient;
import io.ecocode.testapp.R;


public class FusedLocationNoIssueTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // This is not the right object to use. Import is not good
        Location loc = new Location("Dijon");
        GnssStatus sta;
        Log.d("ecoCode", loc.getProvider());
        FusedLocationProviderClient client = new FusedLocationProviderClient(this);
    }
}