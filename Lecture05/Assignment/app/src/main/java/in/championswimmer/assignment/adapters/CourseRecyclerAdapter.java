package in.championswimmer.assignment.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import in.championswimmer.assignment.R;
import in.championswimmer.assignment.models.Course;

/**
 * Created by championswimmer on 27/08/17.
 */

public class CourseRecyclerAdapter extends RecyclerView.Adapter<CourseRecyclerAdapter.CourseViewHolder> {

    private Context context;
    private ArrayList<Course> courses;

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

        Course thisCourse = courses.get(position);
        holder.bindView(thisCourse);


    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvTeacher, tvDate, tvClasses;

        public CourseViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvTeacher = itemView.findViewById(R.id.tvTeacher);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvClasses = itemView.findViewById(R.id.tvClasses);
        }
        public void bindView (Course thisCourse) {
            tvName.setText(thisCourse.getName());
            tvTeacher.setText(thisCourse.getTeacherName());
            tvDate.setText(thisCourse.getStartDate());
            tvClasses.setText(thisCourse.getClasses().toString());
        }
    }
}
