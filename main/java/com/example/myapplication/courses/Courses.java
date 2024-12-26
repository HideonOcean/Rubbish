package com.example.myapplication.courses;

import com.example.myapplication.R;
import com.example.myapplication.model.Chapter;
import com.example.myapplication.model.Course;

import java.util.ArrayList;
import java.util.List;

public class Courses {

    // 获取课程1的数据
    public static Course getCourse1() {
        List<Chapter> chapters1 = new ArrayList<>();
        chapters1.add(new Chapter("第一章", "这是第一章的内容"));
        chapters1.add(new Chapter("第二章", "这是第二章的内容"));
        chapters1.add(new Chapter("第三章", "这是第三章的内容"));
        chapters1.add(new Chapter("第四章", "这是第四章的内容"));
        chapters1.add(new Chapter("第五章", "这是第五章的内容"));

        return new Course(R.drawable.course_image1, "课程1", "老师1", 150, "这是课程1的介绍", chapters1);
    }

    // 获取课程2的数据
    public static Course getCourse2() {
        List<Chapter> chapters2 = new ArrayList<>();
        chapters2.add(new Chapter("第一章", "这是第一章的内容"));
        chapters2.add(new Chapter("第二章", "这是第二章的内容"));
        chapters2.add(new Chapter("第三章", "这是第三章的内容"));
        chapters2.add(new Chapter("第四章", "这是第四章的内容"));
        chapters2.add(new Chapter("第五章", "这是第五章的内容"));
        chapters2.add(new Chapter("第六章", "这是第六章的内容"));
        chapters2.add(new Chapter("第七章", "这是第七章的内容"));
        chapters2.add(new Chapter("第八章", "这是第八章的内容"));

        return new Course(R.drawable.course_image2, "课程2", "老师2", 250, "这是课程2的介绍", chapters2);
    }
}