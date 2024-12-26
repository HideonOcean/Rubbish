package com.example.myapplication.model;

public class Chapter {
    private String chapterName; // 章节名
    private String chapterContent; // 章节内容

    // 构造函数
    public Chapter(String chapterName, String chapterContent) {
        this.chapterName = chapterName;
        this.chapterContent = chapterContent;
    }

    // Getter 和 Setter 方法
    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getChapterContent() {
        return chapterContent;
    }

    public void setChapterContent(String chapterContent) {
        this.chapterContent = chapterContent;
    }
}