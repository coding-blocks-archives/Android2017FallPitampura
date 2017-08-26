package in.championswimmer.listviews2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView rvCourses;
    ArrayList<Course> courseList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        MainActivity.generateCourses(courseList);
        rvCourses = (RecyclerView) findViewById(R.id.rvCourses);

        CourseRecyclerAdapter courseAdapter = new CourseRecyclerAdapter(
                this,
                courseList
        );
        rvCourses.setLayoutManager(new LinearLayoutManager(this));
        rvCourses.setAdapter(courseAdapter);
    }
}
