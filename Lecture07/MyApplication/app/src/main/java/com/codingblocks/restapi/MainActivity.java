package com.codingblocks.restapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.codingblocks.restapi.activities.PostsActivity;
import com.codingblocks.restapi.activities.UsersActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnPosts).setOnClickListener(this);
        findViewById(R.id.btnUsers).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPosts:
                startActivity(new Intent(this, PostsActivity.class));
                break;
            case R.id.btnUsers:
                startActivity(new Intent(this, UsersActivity.class));
                break;
        }
    }
}
