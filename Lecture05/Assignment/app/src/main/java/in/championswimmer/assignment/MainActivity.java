package in.championswimmer.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import in.championswimmer.assignment.activities.CenterListActivity;
import in.championswimmer.assignment.activities.CourseListActivity;

public class MainActivity
        extends AppCompatActivity
        implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnCenters).setOnClickListener(this);
        findViewById(R.id.btnCourses).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnCenters:
                startActivity(new Intent(this, CenterListActivity.class));
                break;
            case R.id.btnCourses:
                startActivity(new Intent(this, CourseListActivity.class));
                break;
        }
    }
}
