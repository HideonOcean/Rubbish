package com.example.myapplication.model;

import java.util.List;

public class Course {
    private int imageResId; // 课程图片资源ID
    private String courseName; // 课程名
    private int requiredPoints; // 购买所需积分
    private String instructor; // 授课老师
    private String description; // 课程简介
    private List<Chapter> chapters; // 课程章节

    // 构造函数
    public Course(int imageResId, String courseName, String instructor, int requiredPoints, String description, List<Chapter> chapters) {
        this.imageResId = imageResId;
        this.courseName = courseName;
        this.instructor = instructor;
        this.requiredPoints = requiredPoints;
        this.description = description;
        this.chapters = chapters;
    }

    // Getter 方法
    public int getImageResId() {
        return imageResId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getRequiredPoints() {
        return requiredPoints;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getDescription() {
        return description;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }
}