package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.adapter.ChapterAdapter;
import com.example.myapplication.courses.Courses;
import com.example.myapplication.model.Course;

public class CourseDetailActivity extends AppCompatActivity {

    public static final String EXTRA_COURSE_NAME = "course_name";
    public static final String EXTRA_COURSE_DESCRIPTION = "course_description";
    public static final String EXTRA_COURSE_POINTS = "course_points";
    public static final String EXTRA_COURSE_IMAGE = "course_image";
    public static final String EXTRA_INSTRUCTOR = "instructor";

    private TextView courseDescriptionTextView;
    private RecyclerView chaptersRecyclerView;
    private ChapterAdapter chapterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail); // 确保布局文件正确

        // 获取传递过来的数据
        String courseName = getIntent().getStringExtra(EXTRA_COURSE_NAME);
        Course course = getCourseByName(courseName);

        if (course == null) {
            // 处理课程不存在的情况
            Toast.makeText(this, "课程不存在", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        // 确保在 findViewById 之后使用视图对象
        ImageView courseImageView = findViewById(R.id.courseImageView);
        TextView courseNameTextView = findViewById(R.id.courseNameTextView);
        TextView instructorTextView = findViewById(R.id.instructorTextView);
        courseDescriptionTextView = findViewById(R.id.courseDescriptionTextView);
        TextView coursePointsTextView = findViewById(R.id.coursePointsTextView);

        // 设置课程详情
        courseImageView.setImageResource(course.getImageResId());
        courseNameTextView.setText(course.getCourseName());
        instructorTextView.setText(course.getInstructor());
        courseDescriptionTextView.setText(course.getDescription());
        coursePointsTextView.setText("购买所需积分: " + course.getRequiredPoints());

        // 返回按钮
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());

        // 设置章节列表
        chaptersRecyclerView = findViewById(R.id.chaptersRecyclerView);
        chaptersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        chapterAdapter = new ChapterAdapter(this, course.getChapters());
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

    private Course getCourseByName(String courseName) {
        if ("课程1".equals(courseName)) {
            return Courses.getCourse1();
        } else if ("课程2".equals(courseName)) {
            return Courses.getCourse2();
        }
        return null;
    }
}