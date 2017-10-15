package com.codingblocks.camera2;

import android.Manifest;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements CameraDevice.StateCallback {
    public static final String TAG = "CAM";
    PermissionRequester pr;
    CameraDevice ourCamera;
    SurfaceView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sv = (SurfaceView) findViewById(R.id.svPreview);
        pr = new PermissionRequester(this);
        pr.request(Manifest.permission.CAMERA, new PermissionRequester.OnPermissionResponseListener() {
            @Override
            public void onDenied() {
                Toast.makeText(MainActivity.this, "We need camera permission", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onGranted() {
                CameraManager cm = (CameraManager) getSystemService(CAMERA_SERVICE);
                try {
                    for (String id : cm.getCameraIdList()) {
                        Log.d(TAG, "onCreate: camera id = " + id);
                        CameraCharacteristics camChar = cm.getCameraCharacteristics(id);
                        Log.d(TAG, "onGranted: flash" + camChar.get(CameraCharacteristics.FLASH_INFO_AVAILABLE));
                        Log.d(TAG, "onGranted: focus" + camChar.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES));
                    }
                    //noinspection MissingPermission
                    cm.openCamera("0", MainActivity.this, null);
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }

            }
        });

        findViewById(R.id.btnPhoto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ourCamera != null) {
                    try {
                        takePhoto();
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Camera not yet ready", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    void takePhoto () throws CameraAccessException {
        ourCamera.createCaptureSession(
                Arrays.asList(sv.getHolder().getSurface()),
                new CameraCaptureSession.StateCallback() {
                    @Override
                    public void onConfigured(@NonNull CameraCaptureSession session) {
                        try {
                            CaptureRequest capReq = ourCamera.createCaptureRequest(CameraDevice.TEMPLATE_STILL_CAPTURE).build();
                            session.capture(
                                    capReq,
                                    new CameraCaptureSession.CaptureCallback() {

                                        @Override
                                        public void onCaptureCompleted(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull TotalCaptureResult result) {
                                            // result = this is the photo
                                            super.onCaptureCompleted(session, request, result);
                                        }
                                    },
                                    null
                            );

                        } catch (CameraAccessException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onConfigureFailed(@NonNull CameraCaptureSession session) {

                    }
                },
                null
        );
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        pr.onRequestPermissionsResult(requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onOpened(@NonNull CameraDevice camera) {
        ourCamera = camera;
    }

    @Override
    public void onDisconnected(@NonNull CameraDevice camera) {

    }

    @Override
    public void onError(@NonNull CameraDevice camera, int error) {

    }
}
