package io.ecocode.testapp.environment.sobriety;

import android.app.Activity;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;


public class TorchFreeTest extends Activity {

    public static final boolean IS_ENABLED = true;
    public static final boolean IS_NOT_ENABLED = false;

    public static final Boolean IS_ENABLED_BOOL = Boolean.TRUE;
    public static final Boolean IS_NOT_ENABLED_BOOL = Boolean.FALSE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CameraManager camManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        String cameraId = null;
        boolean isEnabled = true;
        boolean isNotEnabled = false;
        try {
            cameraId = camManager.getCameraIdList()[0];
            camManager.setTorchMode(cameraId, true);  // Issue {Sobriety: Torch Free}

            camManager.setTorchMode(cameraId, IS_ENABLED); // Issue {Sobriety: Torch Free}
            camManager.setTorchMode(cameraId, IS_NOT_ENABLED);

            camManager.setTorchMode(cameraId, IS_ENABLED_BOOL); // Issue {Sobriety: Torch Free} TODO
            camManager.setTorchMode(cameraId, IS_NOT_ENABLED_BOOL);

            camManager.setTorchMode(cameraId, isEnabled); // Issue {Sobriety: Torch Free} TODO
            camManager.setTorchMode(cameraId, isNotEnabled);
            isEnabled = false;
            camManager.setTorchMode(cameraId, isEnabled);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

    }

    private String[] getCameraIdList() {
        return new String[]{"0", "1", "2"};
    }
}