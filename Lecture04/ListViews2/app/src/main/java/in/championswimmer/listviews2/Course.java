package in.championswimmer.listviews2;

/**
 * Created by championswimmer on 26/08/17.
 */

public class Course {

    String name;
    String center;
    Integer classes;

    public Course(String name, String center, Integer classes) {
        this.name = name;
        this.center = center;
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public String getCenter() {
        return center;
    }

    public Integer getClasses() {
        return classes;
    }
}
