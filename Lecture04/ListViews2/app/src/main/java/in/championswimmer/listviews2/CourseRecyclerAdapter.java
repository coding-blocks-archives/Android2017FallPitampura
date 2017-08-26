package in.championswimmer.listviews2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by championswimmer on 26/08/17.
 */

public class CourseRecyclerAdapter extends RecyclerView.Adapter<CourseRecyclerAdapter.CourseViewHolder> {

    Context context;
    ArrayList<Course> courses;

    public CourseRecyclerAdapter(Context context, ArrayList<Course> courses) {
        this.context = context;
        this.courses = courses;
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_course_card, parent, false);

        return new CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {

        holder.tvCourseName.setText(courses.get(position).getName());
        holder.tvCenter.setText(courses.get(position).getCenter());
        holder.tvClasses.setText(courses.get(position).getClasses().toString());

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder {

        TextView tvCourseName, tvCenter, tvClasses;

        public CourseViewHolder(View itemView) {
            super(itemView);
            tvCourseName = itemView.findViewById(R.id.tvCourseName);
            tvCenter = itemView.findViewById(R.id.tvCenter);
            tvClasses = itemView.findViewById(R.id.tvClasses);
        }
    }
}
