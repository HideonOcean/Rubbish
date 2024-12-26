package com.example.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.CourseDetailActivity;
import com.example.myapplication.LearningCourseDetailActivity;
import com.example.myapplication.R;
import com.example.myapplication.model.Course;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    private Context context;
    private List<Course> courseList;
    private boolean isFromHomeFragment; // Flag to determine which fragment

    // Constructor
    public CourseAdapter(Context context, List<Course> courseList, boolean isFromHomeFragment) {
        this.context = context;
        this.courseList = courseList;
        this.isFromHomeFragment = isFromHomeFragment;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout
        View view = LayoutInflater.from(context).inflate(R.layout.item_course, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        // Bind data to the views
        Course course = courseList.get(position);
        holder.courseImageView.setImageResource(course.getImageResId());
        holder.courseNameTextView.setText(course.getCourseName());
        holder.instructorTextView.setText(course.getInstructor());

        // Set click listener
        holder.itemView.setOnClickListener(v -> {
            Intent intent;
            if (isFromHomeFragment) {
                intent = new Intent(context, CourseDetailActivity.class);
            } else {
                intent = new Intent(context, LearningCourseDetailActivity.class);
            }
            intent.putExtra(CourseDetailActivity.EXTRA_COURSE_NAME, course.getCourseName());
            intent.putExtra(CourseDetailActivity.EXTRA_COURSE_DESCRIPTION, course.getDescription());
            intent.putExtra(CourseDetailActivity.EXTRA_COURSE_POINTS, course.getRequiredPoints());
            intent.putExtra(CourseDetailActivity.EXTRA_COURSE_IMAGE, course.getImageResId());
            intent.putExtra(CourseDetailActivity.EXTRA_INSTRUCTOR, course.getInstructor());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    // ViewHolder class
    public static class CourseViewHolder extends RecyclerView.ViewHolder {
        ImageView courseImageView;
        TextView courseNameTextView;
        TextView instructorTextView;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            courseImageView = itemView.findViewById(R.id.courseImageView); // Ensure this ID matches your layout
            courseNameTextView = itemView.findViewById(R.id.courseNameTextView);
            instructorTextView = itemView.findViewById(R.id.instructorTextView);
        }
    }
}
