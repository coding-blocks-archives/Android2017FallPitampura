package com.codingblocks.animations;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgBackup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgBackup = findViewById(R.id.imgBackup);



        findViewById(R.id.btnSwitch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(
                        MainActivity.this,
                        SecondActivity.class
                );
                ActivityOptions transitionOptions =
                        ActivityOptions.makeSceneTransitionAnimation(
                                MainActivity.this, imgBackup, "backup");

                startActivity(i, transitionOptions.toBundle());
            }
        });

        findViewById(R.id.btnFinish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_up, R.anim.slide_up);

            }
        });
    }

}
