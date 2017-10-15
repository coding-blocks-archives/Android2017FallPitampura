package com.codingblocks.firebase;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by arnav on 10/15/2017.
 */

public class MyIdService extends FirebaseInstanceIdService {
    public static final String TAG = "FIRE";
    @Override
    public void onTokenRefresh() {
        String fireToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "onTokenRefresh: " + fireToken);
        super.onTokenRefresh();
    }
}
