package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Chapter;

import java.util.List;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ChapterViewHolder> {

    private Context context;
    private List<Chapter> chapterList;

    // 构造函数
    public ChapterAdapter(Context context, List<Chapter> chapterList) {
        this.context = context;
        this.chapterList = chapterList;
    }

    @NonNull
    @Override
    public ChapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout
        View view = LayoutInflater.from(context).inflate(R.layout.item_chapter, parent, false);
        return new ChapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterViewHolder holder, int position) {
        // Bind data to the views
        Chapter chapter = chapterList.get(position);
        holder.chapterNameTextView.setText(chapter.getChapterName());
        holder.chapterContentTextView.setText(chapter.getChapterContent());
    }

    @Override
    public int getItemCount() {
        return chapterList.size();
    }

    // ViewHolder class
    public static class ChapterViewHolder extends RecyclerView.ViewHolder {
        TextView chapterNameTextView;
        TextView chapterContentTextView;

        public ChapterViewHolder(@NonNull View itemView) {
            super(itemView);
            chapterNameTextView = itemView.findViewById(R.id.chapterNameTextView);
            chapterContentTextView = itemView.findViewById(R.id.chapterContentTextView);
        }
    }
}