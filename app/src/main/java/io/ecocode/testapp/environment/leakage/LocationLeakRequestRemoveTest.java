package io.ecocode.testapp.environment.leakage;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location; // Issue {Optimized API: Fused Location}
import android.location.LocationListener; // Issue {Optimized API: Fused Location}
import android.location.LocationManager; // Issue {Optimized API: Fused Location}
import android.os.Bundle;

import androidx.core.app.ActivityCompat;

import io.ecocode.testapp.R;


public class LocationLeakRequestRemoveTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000L, 1.0f, getListener());
        locationManager.removeUpdates(getListener());

    }

    private LocationListener getListener() {
        return new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
    }
}