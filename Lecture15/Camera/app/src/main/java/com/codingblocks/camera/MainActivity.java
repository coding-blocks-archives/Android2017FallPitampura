package com.codingblocks.camera;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity
        implements SurfaceHolder.Callback, Camera.PictureCallback {
    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;
    Button btnPreview, btnCapture;
    Camera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surfaceView = (SurfaceView) findViewById(R.id.svCamPrev);
        btnCapture = (Button) findViewById(R.id.btnCapture);
        btnPreview = (Button) findViewById(R.id.btnPreview);
        surfaceHolder = surfaceView.getHolder();
        btnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                camera.startPreview();
                camera.setDisplayOrientation(90);
            }
        });

        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                camera.takePicture(null, MainActivity.this, MainActivity.this);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        if (camera == null) {
            camera = Camera.open();
        } else {
            try {
                camera.reconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        surfaceHolder.addCallback(this);
    }

    @Override
    protected void onPause() {
        camera.release();
        super.onPause();
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        try {
            camera.setPreviewDisplay(surfaceHolder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        if (surfaceHolder.getSurface() == null) {
            return;
        }

        restartPreview();

    }

    void restartPreview () {
        try {
            camera.stopPreview();
        } catch ( Exception e) {}
        try {
            camera.setPreviewDisplay(surfaceHolder);
            switch (getWindowManager().getDefaultDisplay().getRotation()) {
                case Surface.ROTATION_0:
                    camera.setDisplayOrientation(90);
                    break;
                case Surface.ROTATION_90:
                    camera.setDisplayOrientation(0);
                    break;
                case Surface.ROTATION_180:
                    camera.setDisplayOrientation(270);
                    break;
                case Surface.ROTATION_270:
                    camera.setDisplayOrientation(180);
                    break;

            }
            camera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void onPictureTaken(byte[] bytes, Camera camera) {
        if (bytes != null)
        Log.d("SIZE", "onPictureTaken: " + bytes.length);
        restartPreview();
    }
}
