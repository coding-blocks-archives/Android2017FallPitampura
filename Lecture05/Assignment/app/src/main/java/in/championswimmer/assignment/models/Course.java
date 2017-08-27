package in.championswimmer.assignment.models;

import java.util.ArrayList;
import java.util.Random;

import in.championswimmer.assignment.R;

/**
 * Created by championswimmer on 27/08/17.
 */

public class Course {
    String name;
    String teacherName;
    String startDate;
    Integer classes;

    public static final int LAYOUT_TYPE = R.layout.list_item_course_card;

    public Course(String name, String teacherName, String startDate, Integer classes) {
        this.name = name;
        this.teacherName = teacherName;
        this.startDate = startDate;
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getStartDate() {
        return startDate;
    }

    public Integer getClasses() {
        return classes;
    }

    private static String[] courseNames = {
            "Pandora", "Crux", "Launchpad", "Elixir", "Algo++"
    };
    private static String[] teachers = {
            "Arnav", "Prateek", "Sumeet", "Rishabh", "Deepak", "Garima"
    };

    public static ArrayList<Course> generateCourses (int n) {
        ArrayList<Course> courses = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < n; i ++) {
            Course newCourse = new Course(
                    courseNames[r.nextInt(courseNames.length)],
                    teachers[r.nextInt(teachers.length)],
                    r.nextInt(30) + "-09-2017",
                    r.nextInt(5) + 20
            );

            courses.add(newCourse);
        }

        return courses;

    }
}
