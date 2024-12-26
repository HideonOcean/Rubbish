package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.ChapterAdapter;
import com.example.myapplication.model.*;

import java.util.ArrayList;
import java.util.List;

public class CourseDetailActivity extends AppCompatActivity {

    public static final String EXTRA_COURSE_NAME = "course_name";
    public static final String EXTRA_COURSE_DESCRIPTION = "course_description";
    public static final String EXTRA_COURSE_POINTS = "course_points";
    public static final String EXTRA_COURSE_IMAGE = "course_image";
    public static final String EXTRA_INSTRUCTOR = "instructor";

    private TextView courseDescriptionTextView;
    private RecyclerView chaptersRecyclerView;
    private ChapterAdapter chapterAdapter;
    private List<Chapter> chapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        // 获取传递过来的数据
        String courseName = getIntent().getStringExtra(EXTRA_COURSE_NAME);
        String courseDescription = getIntent().getStringExtra(EXTRA_COURSE_DESCRIPTION);
        int coursePoints = getIntent().getIntExtra(EXTRA_COURSE_POINTS, 0);
        int courseImage = getIntent().getIntExtra(EXTRA_COURSE_IMAGE, 0);
        String instructor = getIntent().getStringExtra(EXTRA_INSTRUCTOR);

        // 设置课程详情
        ImageView courseImageView = findViewById(R.id.courseImageView);
        courseImageView.setImageResource(courseImage);

        TextView courseNameTextView = findViewById(R.id.courseNameTextView);
        courseNameTextView.setText(courseName);

        TextView instructorTextView = findViewById(R.id.instructorTextView);
        instructorTextView.setText(instructor);

        courseDescriptionTextView = findViewById(R.id.courseDescriptionTextView);
        courseDescriptionTextView.setText(courseDescription);

        TextView coursePointsTextView = findViewById(R.id.coursePointsTextView);
        coursePointsTextView.setText("购买所需积分: " + coursePoints);

        // 返回按钮
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());

        // 初始化章节数据
        initializeChapters(courseName);

        // 设置章节列表
        chaptersRecyclerView = findViewById(R.id.chaptersRecyclerView);
        chaptersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        chapterAdapter = new ChapterAdapter(this, chapters);
        chaptersRecyclerView.setAdapter(chapterAdapter);

        // 按钮点击事件
        Button descriptionButton = findViewById(R.id.descriptionButton);
        Button catalogButton = findViewById(R.id.catalogButton);

        descriptionButton.setOnClickListener(v -> {
            courseDescriptionTextView.setVisibility(View.VISIBLE);
            chaptersRecyclerView.setVisibility(View.GONE);
        });

        catalogButton.setOnClickListener(v -> {
            courseDescriptionTextView.setVisibility(View.GONE);
            chaptersRecyclerView.setVisibility(View.VISIBLE);
        });

        // 默认显示简介
        courseDescriptionTextView.setVisibility(View.VISIBLE);
        chaptersRecyclerView.setVisibility(View.GONE);
    }

    private void initializeChapters(String courseName) {
        chapters = new ArrayList<>();

        if (courseName.equals("课程1")) {
            chapters.add(new Chapter("第一章", "这是第一章的内容"));
            chapters.add(new Chapter("第二章", "这是第二章的内容"));
            chapters.add(new Chapter("第三章", "这是第三章的内容"));
            chapters.add(new Chapter("第四章", "这是第四章的内容"));
            chapters.add(new Chapter("第五章", "这是第五章的内容"));
        } else if (courseName.equals("课程2")) {
            chapters.add(new Chapter("第一章", "这是第一章的内容"));
            chapters.add(new Chapter("第二章", "这是第二章的内容"));
            chapters.add(new Chapter("第三章", "这是第三章的内容"));
            chapters.add(new Chapter("第四章", "这是第四章的内容"));
            chapters.add(new Chapter("第五章", "这是第五章的内容"));
            chapters.add(new Chapter("第六章", "这是第六章的内容"));
            chapters.add(new Chapter("第七章", "这是第七章的内容"));
            chapters.add(new Chapter("第八章", "这是第八章的内容"));
        }
    }
}