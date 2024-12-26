package com.example.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.example.myapplication.R;
import com.example.myapplication.adapter.CourseAdapter;
import com.example.myapplication.adapter.ViewPagerAdapter;
import com.example.myapplication.courses.Courses;
import com.example.myapplication.model.Course;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView detailedCoursesRecyclerView;
    private CourseAdapter detailedCourseAdapter;
    private List<Course> detailedCourses;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private List<Integer> imageList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // 初始化详细课程数据
        initializeDetailedCourses();
        initializeImageList();

        // 初始化详细课程RecyclerView
        detailedCoursesRecyclerView = view.findViewById(R.id.detailedCoursesRecyclerView);
        detailedCoursesRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        detailedCourseAdapter = new CourseAdapter(getContext(), detailedCourses, true);
        detailedCoursesRecyclerView.setAdapter(detailedCourseAdapter);

        // 初始化ViewPager
        viewPager = view.findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getContext(), imageList);
        viewPager.setAdapter(viewPagerAdapter);

        return view;
    }

    private void initializeDetailedCourses() {
        detailedCourses = new ArrayList<>();

        detailedCourses.add(Courses.getCourse1());
        detailedCourses.add(Courses.getCourse2());
    }

    private void initializeImageList() {
        imageList = new ArrayList<>();
        // 添加滚动图片资源ID
        imageList.add(R.drawable.image1);
        imageList.add(R.drawable.image2);
    }
}