package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.model.Course;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class CoursesActivity extends AppCompatActivity {

    private ListView coursesListView;
    private List<Course> courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        coursesListView = findViewById(R.id.coursesListView);

        // 读取 JSON 文件
        InputStream inputStream = getResources().openRawResource(R.raw.courses);
        InputStreamReader reader = new InputStreamReader(inputStream);
        Gson gson = new Gson();
        Type courseListType = new TypeToken<List<Course>>() {}.getType();
        courses = gson.fromJson(reader, courseListType);

        // 提取课程名称并设置到 ListView 中
        String[] courseNames = new String[courses.size()];
        for (int i = 0; i < courses.size(); i++) {
            courseNames[i] = courses.get(i).getCourseName();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courseNames);
        coursesListView.setAdapter(adapter);

        coursesListView.setOnItemClickListener((parent, view, position, id) -> {
            Course selectedCourse = courses.get(position);
            Intent intent = new Intent(CoursesActivity.this, CourseDetailActivity.class);
            intent.putExtra("courseName", selectedCourse.getCourseName());
            // 你可以传递更多的课程信息到下一个活动
            startActivity(intent);
        });
    }
}