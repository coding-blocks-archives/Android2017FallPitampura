package in.championswimmer.assignment.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import in.championswimmer.assignment.R;
import in.championswimmer.assignment.adapters.CourseRecyclerAdapter;
import in.championswimmer.assignment.models.Course;
import in.championswimmer.assignment.viewholders.GenericRecyclerAdapter;

public class CourseListActivity extends AppCompatActivity {

    RecyclerView rvCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        rvCourses = (RecyclerView) findViewById(R.id.rvCourses);
        rvCourses.setLayoutManager(new LinearLayoutManager(this));

        GenericRecyclerAdapter<Course> courseAdapter =
                new GenericRecyclerAdapter<>(
                        this,
                        Course.generateCourses(50),
                        R.layout.list_item_course_card
                );

        rvCourses.setAdapter(courseAdapter);
    }
}
