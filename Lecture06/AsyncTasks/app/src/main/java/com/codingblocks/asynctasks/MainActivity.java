package com.codingblocks.asynctasks;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = (TextView) findViewById(R.id.textView);

        MyLongTask task = new MyLongTask();
        task.execute(5);


        setContentView(R.layout.activity_main);
    }

    class MyLongTask extends AsyncTask<Integer, Float, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            for (int i = 0; i < integers[0]; i++) {
                waitForASec();
                publishProgress((float)i/(float)integers[0]);
            }
            return null;
        }

        void waitForASec() {
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() < startTime + 1000);
        }

        @Override
        protected void onProgressUpdate(Float... values) {
            super.onProgressUpdate(values);
            textView.setText(String.valueOf(values[0]));
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            textView.setText("All Done !");
        }


    }
}
