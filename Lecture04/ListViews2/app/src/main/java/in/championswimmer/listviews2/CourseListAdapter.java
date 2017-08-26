package in.championswimmer.listviews2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by championswimmer on 26/08/17.
 */

public class CourseListAdapter extends BaseAdapter {
    public static final String TAG = "LIST";

    Context context;
    ArrayList<Course> courses;

    public CourseListAdapter(Context context, ArrayList<Course> courses) {
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
    public View getView(int i, View itemView, ViewGroup viewGroup) {
        LayoutInflater li =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Log.d(TAG, "getView: position = " + i + "view = " + view);

        if (itemView == null) {
            itemView = li.inflate(R.layout.list_item_course, viewGroup, false);
        } else {

        }

        Course thisCourse = getItem(i);
        TextView tvCourseName = (TextView) itemView.findViewById(R.id.tvCourseName);
        TextView tvCenter = (TextView) itemView.findViewById(R.id.tvCenter);
        TextView tvClasses = (TextView) itemView.findViewById(R.id.tvClasses);

        tvCourseName.setText(thisCourse.getName());
        tvCenter.setText(thisCourse.getCenter());
        tvClasses.setText(thisCourse.getClasses().toString());

        return itemView;
    }
}
