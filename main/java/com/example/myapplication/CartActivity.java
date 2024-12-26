package com.example.myapplication;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;

public class CartActivity extends AppCompatActivity {

    private ListView cartListView;
    // 使用 List 替代数组
    private List<String> cartList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartListView = findViewById(R.id.cartListView);
        // 初始化 List
        cartList = new ArrayList<>();
        cartList.add("课程1");
        cartList.add("课程3");
        cartList.add("课程5");

        // 使用 ArrayAdapter 适配 List
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cartList);
        cartListView.setAdapter(adapter);

        cartListView.setOnItemClickListener((parent, view, position, id) -> {
            String courseName = cartList.get(position);
            Toast.makeText(CartActivity.this, "购买 " + courseName, Toast.LENGTH_SHORT).show();
            // 这里可以添加购买逻辑
        });
    }
}