package com.codingblocks.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "FIRE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String fireToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "onCreate: " + fireToken);
    }
}
