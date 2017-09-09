package com.codingblocks.networkops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
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
                new WebPageDownloadTask() {
                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        textView.setText(s);
                    }
                }.execute("http://google.com");
            }
        });
    }
}
