package com.example.myapplication;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;

public class OrdersActivity extends AppCompatActivity {

    private ListView ordersListView;
    private List<String> ordersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        ordersListView = findViewById(R.id.ordersListView);
        ordersList = new ArrayList<>();
        ordersList.add("订单1");
        ordersList.add("订单2");
        ordersList.add("订单3");

        // 使用 ArrayAdapter 并设置给 ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ordersList);
        ordersListView.setAdapter(adapter);

        ordersListView.setOnItemClickListener((parent, view, position, id) -> {
            String orderName = ordersList.get(position);
            Toast.makeText(OrdersActivity.this, "查看 " + orderName, Toast.LENGTH_SHORT).show();
            // 这里可以添加查看订单详情逻辑
        });
    }
}