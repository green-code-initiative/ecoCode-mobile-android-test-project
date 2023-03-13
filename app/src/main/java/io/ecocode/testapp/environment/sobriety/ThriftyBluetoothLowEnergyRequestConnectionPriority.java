package io.ecocode.testapp.environment.sobriety;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanSettings;
import android.os.Bundle;


public class ThriftyBluetoothLowEnergyRequestConnectionPriority extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BluetoothDevice bluetoothDevice = BluetoothAdapter.getDefaultAdapter().getRemoteDevice("address");
        BluetoothGatt gatt = bluetoothDevice.connectGatt(this, true, new BluetoothGattCallback() {
            @Override
            public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
                super.onConnectionStateChange(gatt, status, newState);
            }
        });
        gatt.requestConnectionPriority(BluetoothGatt.CONNECTION_PRIORITY_BALANCED); // Issue {Sobriety: Thrifty Bluetooth Low Energy (requestConnectionPriority)}
        gatt.requestConnectionPriority(BluetoothGatt.CONNECTION_PRIORITY_HIGH); // Issue {Sobriety: Thrifty Bluetooth Low Energy (requestConnectionPriority)}
        gatt.requestConnectionPriority(BluetoothGatt.CONNECTION_PRIORITY_LOW_POWER);

        BluetoothLeScanner scanner = BluetoothAdapter.getDefaultAdapter().getBluetoothLeScanner();

        ScanSettings.Builder builder = new ScanSettings.Builder();
        builder.setScanMode(ScanSettings.SCAN_MODE_LOW_POWER); // TODO report
        scanner.startScan(null, builder.build(), (ScanCallback) null);
    }
}