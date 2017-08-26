package in.championswimmer.listviews;

/**
 * Created by championswimmer on 26/08/17.
 */

public class Course {
    String name;
    String center;
    Integer classes;

    public String getName() {
        return name;
    }

    public String getCenter() {
        return center;
    }

    public Integer getClasses() {
        return classes;
    }

    public Course(String name, String center, int classes) {
        this.name = name;
        this.center = center;
        this.classes = classes;
    }
}
