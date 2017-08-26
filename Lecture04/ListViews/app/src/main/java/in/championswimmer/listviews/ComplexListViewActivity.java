package in.championswimmer.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ComplexListViewActivity extends AppCompatActivity {

    ArrayList<Course> courseList = new ArrayList<>();
    ListView lvCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complex_list_view);
        generateCourses(courseList);
        lvCourses = (ListView) findViewById(R.id.lvCourses);

        CourseAdapter courseAdapter = new CourseAdapter(this, courseList);
        lvCourses.setAdapter(courseAdapter);


    }

    void generateCourses (ArrayList<Course> courses) {
        courses.add(new Course("Pandora", "Pitampura", 22));
        courses.add(new Course("Elixir", "Pitampura", 22));
        courses.add(new Course("Launchpad", "Pitampura", 24));
        courses.add(new Course("Crux", "Pitampura", 24));
        courses.add(new Course("Algo++", "Pitampura", 14));
        courses.add(new Course("Perceptron", "Pitampura", 22));
        courses.add(new Course("Pandora", "Dwarka", 22));
        courses.add(new Course("Elixir", "Dwarka", 22));
        courses.add(new Course("Launchpad", "Dwarka", 24));
        courses.add(new Course("Crux", "Dwarka", 24));
    }
}
