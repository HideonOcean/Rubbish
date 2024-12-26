package com.example.myapplication.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import com.example.myapplication.CartActivity;
import com.example.myapplication.LoginActivity;
import com.example.myapplication.OrdersActivity;
import com.example.myapplication.R;

public class ProfileFragment extends Fragment {

    private ImageView avatarImageView;
    private TextView nameTextView;
    private TextView shoppingCartTextView;
    private TextView ordersTextView;
    private TextView logoutTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        avatarImageView = view.findViewById(R.id.avatarImageView);
        nameTextView = view.findViewById(R.id.nameTextView);
        shoppingCartTextView = view.findViewById(R.id.shoppingCartTextView);
        ordersTextView = view.findViewById(R.id.ordersTextView);
        logoutTextView = view.findViewById(R.id.logoutTextView);

        // 设置点击事件
        avatarImageView.setOnClickListener(v -> {
            // 处理头像点击事件，例如上传头像
            Toast.makeText(getActivity(), "上传头像", Toast.LENGTH_SHORT).show();
        });

        shoppingCartTextView.setOnClickListener(v -> {
            // 处理购物车点击事件
            Intent intent = new Intent(getActivity(), CartActivity.class);
            startActivity(intent);
        });

        ordersTextView.setOnClickListener(v -> {
            // 处理订单点击事件
            Intent intent = new Intent(getActivity(), OrdersActivity.class);
            startActivity(intent);
        });

        logoutTextView.setOnClickListener(v -> {
            // 处理退出登录点击事件
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
            getActivity().finish(); // 结束当前活动，防止用户返回到此活动
        });

        return view;
    }
}