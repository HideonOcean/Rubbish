package com.example.myapplication.model;

import java.util.List;

public class Course {
    private int imageResId; // 课程图片资源ID
    private String courseName; // 课程名
    private int requiredPoints; // 购买所需积分
    private String instructor; // 授课老师
    private String description; // 课程简介
    private List<Chapter> chapters; // 课程章节

    // 必须有一个默认的构造函数，以便 Gson 使用
    public Course() {}

    // Getter 和 Setter 方法
    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getRequiredPoints() {
        return requiredPoints;
    }

    public void setRequiredPoints(int requiredPoints) {
        this.requiredPoints = requiredPoints;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }
}