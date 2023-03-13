package io.ecocode.testapp.environment.sobriety;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;


public class ThriftyGeolocationTest extends Activity implements LocationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        locationManager.requestLocationUpdates("",
                0, // Issue {Sobriety: Thrifty Geolocation}
                0, // Issue {Sobriety: Thrifty Geolocation}
                this);

        locationManager.requestLocationUpdates("",
                0, // Issue {Sobriety: Thrifty Geolocation}
                0, // Issue {Sobriety: Thrifty Geolocation}
                this,
                null);

        locationManager.requestLocationUpdates(0,// Issue {Sobriety: Thrifty Geolocation}
                0, // Issue {Sobriety: Thrifty Geolocation}
                null,
                this,
                null);

        locationManager.requestLocationUpdates(0,// Issue {Sobriety: Thrifty Geolocation}
                        0, // Issue {Sobriety: Thrifty Geolocation}
                null,
                this,
                null);

        locationManager.requestLocationUpdates("",
                123,
                256,
                (PendingIntent) null);
        locationManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {

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
}