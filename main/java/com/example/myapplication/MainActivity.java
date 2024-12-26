package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.fragments.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 检查是否已经登录
        if (!isLoggedIn()) {
            // 如果未登录，启动登录活动
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish(); // 结束当前活动，防止用户返回到此活动
            return;
        }

        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            if (item.getItemId() == R.id.navigation_home) {
                selectedFragment = new HomeFragment();
            } else if (item.getItemId() == R.id.navigation_learning) {
                selectedFragment = new LearningFragment();
            } else if (item.getItemId() == R.id.navigation_discovery) {
                selectedFragment = new DiscoveryFragment();
            } else if (item.getItemId() == R.id.navigation_profile) {
                selectedFragment = new ProfileFragment();
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container, selectedFragment)
                        .commit();
                return true;
            }

            return false;
        });

        // 默认选中首页
        navigationView.setSelectedItemId(R.id.navigation_home);
    }

    // 检查是否已经登录的方法
    private boolean isLoggedIn() {
        // 这里可以检查用户的登录状态，例如通过SharedPreferences
        // 为了简化示例，这里假设用户已登录
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_courses) {
            startActivity(new Intent(MainActivity.this, CoursesActivity.class));
            return true;
        } else if (id == R.id.menu_cart) {
            startActivity(new Intent(MainActivity.this, CartActivity.class));
            return true;
        } else if (id == R.id.menu_orders) {
            startActivity(new Intent(MainActivity.this, OrdersActivity.class));
            return true;
        } else if (id == R.id.menu_profile) {
            startActivity(new Intent(MainActivity.this, UserProfileActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}