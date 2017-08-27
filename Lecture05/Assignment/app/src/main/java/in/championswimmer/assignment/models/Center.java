package in.championswimmer.assignment.models;

import java.util.ArrayList;
import java.util.Random;

import in.championswimmer.assignment.R;

/**
 * Created by championswimmer on 27/08/17.
 */

public class Center {
    String location;
    String city;
    String contactNumber;

    public static final int LAYOUT_TYPE = R.layout.list_item_center_card;

    public Center(String location, String city, String contactNumber) {
        this.location = location;
        this.city = city;
        this.contactNumber = contactNumber;
    }

    public String getLocation() {
        return location;
    }

    public String getCity() {
        return city;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    private static String[] locNames = {
            "Pitampura", "Noida", "Model Town", "Dwarka", "New Colony"
    };
    private static String[] cities = {
            "New Delhi", "Gurgaon", "Greater Noida", "Amritsar"
    };

    public static ArrayList<Center> generateCenters(int n) {
        ArrayList<Center> centers = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            Center newCenter = new Center(
                    locNames[r.nextInt(locNames.length)],
                    cities[r.nextInt(cities.length)],
                    String.valueOf(90000000 + r.nextInt(999999))
            );
            centers.add(newCenter);
        }
        return centers;
    }
}
