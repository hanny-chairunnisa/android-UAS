package com.ac.id.todolist;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("DataPribadi", MODE_PRIVATE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sharedPreferences.getBoolean("isLogin",false)){
                    Intent intent = new Intent(com.ac.id.todolist.MainActivity.this, HomesActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(com.ac.id.todolist.MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                finish();

            }
        }, 3000);
    }
}