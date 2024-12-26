package com.example.myapplication.model;

public class Chapter {
    private String title; // 章节标题
    private String content; // 章节内容

    // 必须有一个默认的构造函数，以便 Gson 使用
    public Chapter() {}

    // Getter 和 Setter 方法
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}