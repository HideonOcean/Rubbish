package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CoursesActivity extends AppCompatActivity {

    private ListView coursesListView;
    private String[] courses = {"课程1", "课程2", "课程3", "课程4", "课程5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        coursesListView = findViewById(R.id.coursesListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courses);
        coursesListView.setAdapter(adapter);

        coursesListView.setOnItemClickListener((parent, view, position, id) -> {
            String courseName = courses[position];
            Intent intent = new Intent(CoursesActivity.this, CourseDetailActivity.class);
            intent.putExtra("courseName", courseName);
            startActivity(intent);
        });
    }
}
