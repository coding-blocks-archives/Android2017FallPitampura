package in.championswimmer.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;
import android.widget.Toast;

public class WaitingService extends Service {
    public static final String TAG = "SRVC";
    public WaitingService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        waitFor10Sec();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    void waitFor10Sec () {
        long startTime = System.currentTimeMillis();

        while (System.currentTimeMillis() < startTime + 10000);

        Toast.makeText(this, "We waiting 10 sec", Toast.LENGTH_SHORT).show();
    }
}
