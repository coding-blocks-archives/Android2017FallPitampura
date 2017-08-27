package in.championswimmer.assignment.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import in.championswimmer.assignment.R;
import in.championswimmer.assignment.adapters.CourseRecyclerAdapter;
import in.championswimmer.assignment.models.Course;

public class CourseListActivity extends AppCompatActivity {

    RecyclerView rvCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        rvCourses = (RecyclerView) findViewById(R.id.rvCourses);
        rvCourses.setLayoutManager(new LinearLayoutManager(this));

        rvCourses.setAdapter(new CourseRecyclerAdapter(
                this,
                Course.generateCourses(50)
        ));
    }
}
