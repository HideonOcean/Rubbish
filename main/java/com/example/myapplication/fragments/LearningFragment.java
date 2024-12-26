package com.example.myapplication.fragments;

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

public class LearningFragment extends Fragment {

    private RecyclerView learningCoursesRecyclerView;
    private CourseAdapter learningCourseAdapter;
    private List<Course> learningCourses;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_learning, container, false);

        // 初始化学习课程数据
        initializeLearningCourses();

        // 初始化RecyclerView
        learningCoursesRecyclerView = view.findViewById(R.id.learningCoursesRecyclerView);
        learningCoursesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        learningCourseAdapter = new CourseAdapter(getContext(), learningCourses,false);
        learningCoursesRecyclerView.setAdapter(learningCourseAdapter);

        return view;
    }

    private void initializeLearningCourses() {
        learningCourses = new ArrayList<>();

        learningCourses.add(Courses.getCourse1());
        learningCourses.add(Courses.getCourse2());
    }
}