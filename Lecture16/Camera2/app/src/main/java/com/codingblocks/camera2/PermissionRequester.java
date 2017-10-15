package com.codingblocks.camera2;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import java.util.ArrayList;

/**
 * Created by arnav on 10/15/2017.
 */

public class PermissionRequester {
    private Activity act;
    private ArrayList<OnPermissionResponseListener> oprlList = new ArrayList<>();

    public PermissionRequester(Activity act) {
        this.act = act;
    }

    interface OnPermissionResponseListener {
        void onDenied();
        void onGranted();
    }

    void request(String permission, OnPermissionResponseListener onPermissionResponseListener) {
        int code = 100 + oprlList.size();
        ActivityCompat.requestPermissions(act,
                new String[]{permission},
                code);
        oprlList.add((code - 100), onPermissionResponseListener);
    }

    void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        int code = requestCode - 100;
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            oprlList.get(code).onGranted();
        } else {
            oprlList.get(code).onDenied();
        }
    }
}
