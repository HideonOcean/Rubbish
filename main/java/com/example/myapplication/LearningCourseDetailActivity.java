package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.ChapterAdapter;
import com.example.myapplication.model.Chapter;

import java.util.List;

public class LearningCourseDetailActivity extends AppCompatActivity {

    public static final String EXTRA_COURSE_NAME = "course_name";
    public static final String EXTRA_COURSE_IMAGE = "course_image";
    public static final String EXTRA_COURSE_CHAPTERS = "course_chapters";

    private RecyclerView chaptersRecyclerView;
    private ChapterAdapter chapterAdapter;
    private List<Chapter> chapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_course_detail);

        // 获取传递过来的数据
        String courseName = getIntent().getStringExtra(EXTRA_COURSE_NAME);
        int courseImage = getIntent().getIntExtra(EXTRA_COURSE_IMAGE, 0);
        List<Chapter> chapters = getIntent().getParcelableArrayListExtra(EXTRA_COURSE_CHAPTERS);

        // 设置课程详情
        ImageView courseImageView = findViewById(R.id.courseImageView);
        courseImageView.setImageResource(courseImage);

        TextView courseNameTextView = findViewById(R.id.courseNameTextView);
        courseNameTextView.setText(courseName);

        // 返回按钮
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());

        // 设置章节列表
        chaptersRecyclerView = findViewById(R.id.chaptersRecyclerView);
        chaptersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        chapterAdapter = new ChapterAdapter(this, chapters);
        chaptersRecyclerView.setAdapter(chapterAdapter);
    }
}