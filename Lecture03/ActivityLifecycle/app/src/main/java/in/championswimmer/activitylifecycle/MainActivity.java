package in.championswimmer.activitylifecycle;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "AL";
    int backPressed = 0;
    long lastBackpressed = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        Toast.makeText(this, "Hello There !", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onBackPressed() {
        backPressed++;
        long currentTime = System.currentTimeMillis();
        if (lastBackpressed < (currentTime - 2000)) {
            lastBackpressed = currentTime;
            Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();
        } else {
            if (backPressed > 1) {
                super.onBackPressed();
            } else {
                Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
