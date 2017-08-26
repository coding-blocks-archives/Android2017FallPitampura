package in.championswimmer.listviews2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Course> courseList = new ArrayList<>();
    ListView lvCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateCourses(courseList);
        lvCourses = (ListView) findViewById(R.id.lvCourses);

        CourseListAdapter courseListAdapter = new CourseListAdapter(this, courseList);
        lvCourses.setAdapter(courseListAdapter);


    }

    static void generateCourses (ArrayList<Course> courses) {
        courses.add(new Course("Pandora", "Pitampura", 22));
        courses.add(new Course("Elixir", "Pitampura", 22));
        courses.add(new Course("Crux", "Pitampura", 22));
        courses.add(new Course("Launchpad", "Pitampura", 22));
        courses.add(new Course("Perceptron", "Pitampura", 22));
        courses.add(new Course("Algo++", "Pitampura", 22));
        courses.add(new Course("GameDev", "Pitampura", 22));
        courses.add(new Course("Pandora", "Dwarka", 22));
        courses.add(new Course("Elixir", "Dwarka", 22));
        courses.add(new Course("Launchpad", "Dwarka", 22));
        courses.add(new Course("Algo++", "Dwarka", 22));
        courses.add(new Course("Crux", "Dwarka", 22));
        courses.add(new Course("Pandora", "Pitampura", 22));
        courses.add(new Course("Elixir", "Pitampura", 22));
        courses.add(new Course("Crux", "Pitampura", 22));
        courses.add(new Course("Launchpad", "Pitampura", 22));
        courses.add(new Course("Perceptron", "Pitampura", 22));
        courses.add(new Course("Algo++", "Pitampura", 22));
        courses.add(new Course("GameDev", "Pitampura", 22));
        courses.add(new Course("Pandora", "Dwarka", 22));
        courses.add(new Course("Elixir", "Dwarka", 22));
        courses.add(new Course("Launchpad", "Dwarka", 22));
        courses.add(new Course("Algo++", "Dwarka", 22));
        courses.add(new Course("Crux", "Dwarka", 22));
        courses.add(new Course("Pandora", "Pitampura", 22));
        courses.add(new Course("Elixir", "Pitampura", 22));
        courses.add(new Course("Crux", "Pitampura", 22));
        courses.add(new Course("Launchpad", "Pitampura", 22));
        courses.add(new Course("Perceptron", "Pitampura", 22));
        courses.add(new Course("Algo++", "Pitampura", 22));
        courses.add(new Course("GameDev", "Pitampura", 22));
        courses.add(new Course("Pandora", "Dwarka", 22));
        courses.add(new Course("Elixir", "Dwarka", 22));
        courses.add(new Course("Launchpad", "Dwarka", 22));
        courses.add(new Course("Algo++", "Dwarka", 22));
        courses.add(new Course("Crux", "Dwarka", 22));
    }

}
