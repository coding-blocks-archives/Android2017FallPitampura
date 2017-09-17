package com.codingblocks.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.codingblocks.fragments.fragments.BlueFragment;
import com.codingblocks.fragments.fragments.RedFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FragmentManager fragmentManager;
    BlueFragment blueFragment;
    RedFragment redFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dynamic_fragments);

        fragmentManager = getSupportFragmentManager();

        blueFragment = new BlueFragment();
        redFragment = new RedFragment();

        findViewById(R.id.btnBlue).setOnClickListener(this);
        findViewById(R.id.btnRed).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBlue:
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.flFragContainer, blueFragment)
                        .commit();
                break;
            case R.id.btnRed:
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.flFragContainer, redFragment)
                        .commit();
                break;
        }
    }
}
