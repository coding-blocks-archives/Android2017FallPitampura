package in.championswimmer.listviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by championswimmer on 26/08/17.
 */

public class CourseAdapter extends BaseAdapter {



    ArrayList<Course> courses;
    Context context;

    public CourseAdapter(Context context, ArrayList<Course> courses) {
        this.context = context;
        this.courses = courses;
    }

    @Override
    public int getCount() {
        return courses.size();
    }

    @Override
    public Course getItem(int i) {
        return courses.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater li =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = li.inflate(R.layout.list_item_course, viewGroup, false);

        ((TextView) itemView.findViewById(R.id.tvCourseName)).setText(getItem(i).getName());
        ((TextView) itemView.findViewById(R.id.tvCenter)).setText(getItem(i).getCenter());
        ((TextView) itemView.findViewById(R.id.tvClasses)).setText(getItem(i).getClasses().toString());

        return itemView;
    }
}
