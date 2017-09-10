package com.codingblocks.networkops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "JSON";
    Button btnDownload;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDownload = (Button) findViewById(R.id.btnDownload);
        textView = (TextView) findViewById(R.id.textView);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new JSONDownloadTask() {
                    @Override
                    protected void onPostExecute(ArrayList<Post> posts) {
                        super.onPostExecute(posts);
                        Log.d(TAG, "onPostExecute: " + posts.size());
                    }
                }.execute("http://jsonplaceholder.typicode.com/posts");
            }
        });
    }
}
