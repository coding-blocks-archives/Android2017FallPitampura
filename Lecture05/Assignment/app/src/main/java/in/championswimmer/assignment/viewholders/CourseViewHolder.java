package in.championswimmer.assignment.viewholders;

import android.view.View;
import android.widget.TextView;

import in.championswimmer.assignment.R;
import in.championswimmer.assignment.models.Course;

/**
 * Created by championswimmer on 27/08/17.
 */

public class CourseViewHolder extends ItemViewHolder<Course> {

    TextView tvName, tvTeacher, tvDate, tvClasses;

    public CourseViewHolder(View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tvName);
        tvTeacher = itemView.findViewById(R.id.tvTeacher);
        tvDate = itemView.findViewById(R.id.tvDate);
        tvClasses = itemView.findViewById(R.id.tvClasses);
    }

    @Override
    public void bindView(Course thisCourse) {
        super.bindView(thisCourse);
        tvName.setText(thisCourse.getName());
        tvTeacher.setText(thisCourse.getTeacherName());
        tvDate.setText(thisCourse.getStartDate());
        tvClasses.setText(thisCourse.getClasses().toString());
    }
}
