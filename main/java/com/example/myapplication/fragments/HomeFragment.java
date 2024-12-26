package com.example.myapplication.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.adapter.CourseAdapter;
import com.example.myapplication.courses.Courses;
import com.example.myapplication.model.Course;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView detailedCoursesRecyclerView;
    private CourseAdapter detailedCourseAdapter;
    private List<Course> detailedCourses;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // 初始化详细课程数据
        initializeDetailedCourses();

        // 初始化详细课程RecyclerView
        detailedCoursesRecyclerView = view.findViewById(R.id.detailedCoursesRecyclerView);
        detailedCoursesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        detailedCourseAdapter = new CourseAdapter(getContext(), detailedCourses, true);
        detailedCoursesRecyclerView.setAdapter(detailedCourseAdapter);

        return view;
    }

    private void initializeDetailedCourses() {
        detailedCourses = new ArrayList<>();

        detailedCourses.add(Courses.getCourse1());
        detailedCourses.add(Courses.getCourse2());
    }
}